package Modele.Personnage;

import Modele.Item.Consommable;
import Modele.Item.Equipement;
import Modele.Item.Item;

public class Joueur extends Personnage {

    private ClassePersonnage classe;
    private Inventaire inventaire;
    private boolean enDonjon;
    private int pts_dispo;

    public Joueur(String nom, ClassePersonnage classe, Inventaire inventaire, int force, int constitution, int dexterite, int intelligence, int capacite) {
        super(nom, force, constitution, dexterite, intelligence, capacite);
        this.classe = classe;
        this.inventaire = inventaire;
        this.enDonjon = false;
        this.pts_dispo = 0;
    }

    public Joueur(Joueur j){
        super(j.getNom(), j.getVie(), j.getMAX_VIE(), j.getMana(), j.getMAX_MANA(), j.getForce(), j.getConstitution(), j.getDexterite(), j.getIntelligence(), j.getCapacite());
        this.classe = j.classe;
        this.inventaire = new Inventaire(j.inventaire);
        this.enDonjon = j.enDonjon;
        this.pts_dispo = j.pts_dispo;
    }

    @Override
    public ClassePersonnage getClasse() {
        return classe;
    }

    public void setClasse(ClassePersonnage classe) {
        this.classe = classe;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
    }

    public boolean isEnDonjon() {
        return enDonjon;
    }

    public void setEnDonjon(boolean enDonjon) {
        this.enDonjon = enDonjon;
    }

    public int getPts_dispo() {
        return pts_dispo;
    }

    public void setPts_dispo(int pts_dispo) {
        this.pts_dispo = pts_dispo;
    }

    /**
     * Méthode qui renvoie un booléen en fonction de si le coup touche
     *
     * @return true si le coup touche, false sinon
     */
    @Override
    public boolean coupTouche() {
        double probabilite = (((double) this.getDexterite() / 10) * inventaire.getEquipement("arme").getPrecision());
        //par exemple, le joueur a 7 de dextérité et une arme à 80% de précision, il a donc 0.70 * 0.80 = 0.56 -> 56% de chances de toucher (pas clair, à voir le calcul)
        double random = Math.random();
        return random <= probabilite;
    }

    /**
     * Méthoe qui calcule les dégâts lorsqu'un coup touche
     *
     * @return les dégats de base sans ajout de dégats critiques
     */
    public int degatsArme() {
        return this.getForce() + inventaire.getEquipement("arme").getDegats();
    }


    /**
     * Méthode qui calcule les dégats finaux a envoyer vers l'ennemi, s'il n'y a pas de coup critique, elle renverra la valeur des degats flat
     *
     * @param degatsFlat valeurs de degats de base
     * @return les dégâts finaux
     */
    public int degatsCrit(int degatsFlat) {
        double random = Math.random();
        int degats = degatsFlat;
        if (random <= inventaire.getEquipement("arme").getCrit()) {
            degats = (int) (degatsFlat * (1 + Math.random()));
        }
        return degats;
    }

    /**
     * Méthode qui attaque avec l'arme sur l'adversaire
     *
     * @param adversaire adversaire à envoyer l'attaque
     * @return les dégats que le joueur adverse subit
     */
    @Override
    public int attaquerArme(Personnage adversaire) {
        int degats = 0;
        if (this.coupTouche()) {
            degats = this.degatsCrit(this.degatsArme());
        }
        return adversaire.recevoirCoup(degats);
    }

    /**
     * Méthode qui calcule les dégâts après réduction par la protection
     *
     * @param degats degats de bas avant réduction
     * @return les dégats finaux à appliquer au joueur
     */
    public int reducDegats(int degats) {
        int armure = inventaire.getEquipement("arme").getProtection() + inventaire.getEquipement("tete").getProtection() + inventaire.getEquipement("torse").getProtection() + inventaire.getEquipement("jambes").getProtection() + inventaire.getEquipement("pieds").getProtection();
        return degats - (armure / 2);
    }

    /**
     * Méthode qui enlève des points de vie à un personnage lorsqu'il se reçoit un coup
     *
     * @param degats dégâts infligés par l'adversaire après calcul du coup
     * @return les degats que le joueur subit
     */
    @Override
    public int recevoirCoup(int degats) {
        int degatsReels = reducDegats(degats);
        if (degatsReels > 0) {
            setVie(getVie() - degatsReels);
        }
        return Math.max(degatsReels, 0);
    }

    //Méthodes de gestion d'inventaire

    /**
     * Permet de jeter un item de l'inventaire, ce qui le supprimera de son inventaire, et l'ajoutera à celui de la salle
     *
     * @param index le numéro de l'item à supprimer
     */
    public Item jeterItem(int index) {
        return inventaire.supprItem(index);
    }

    /**
     * Permet d'ajouter un item à l'inventaire du joueur
     *
     * @param item
     */
    public boolean ajouterItem(Item item) {
        return inventaire.ajouterItem(item);
    }

    public void utiliser(int index) {
        Consommable consommable = (Consommable) inventaire.getItem(index);
        this.ajouterVie(consommable.getVie());
        this.ajouterMana(consommable.getMana());
        this.inventaire.supprItem(index);
    }

    /**
     * Méthode qui équipe un équipement à la bonne place (jambes, arme, torse,etc...)
     *
     * @return true si l'équipement a bien été équipé, false sinon
     */
    public boolean equiper(Equipement equipement) {
        boolean effectue = false;
        if (equipement.getPreRequis().test(this)) {
            this.ajouterStats(equipement.getForce(), equipement.getDexterite(), equipement.getIntelligence());
            inventaire.setEquipement(equipement);
            effectue = true;
        }
        return effectue;
    }

    /**
     * Méthode qui déséquipe un équipement s'il y en a un, et le remet dans l'inventaire
     *
     * @param emplacement emplacement à déséquiper
     * @return l'équipement s'il bien déséquipé, null sinon
     */
    public Equipement desequiper(String emplacement) {
        if (inventaire.getEquipement(emplacement).getEmplacement() != "partout") { // Attention ne pas simplifier par juste emplacement car les items spéciaux "tout nu" sont en emplacement "partout"
            Equipement eqp = inventaire.getEquipement(emplacement);
            this.retirerStats(eqp.getForce(), eqp.getDexterite(), eqp.getIntelligence());
            inventaire.resetEquipement(emplacement);
            return eqp;
        } else return null;
    }

    /**
     * Permet d'utiliser les points disponibles sur la statistique renseignée
     *
     * @param stat   statistique concernée (1 Force, 2 Constitution, 3 Dextérité, 4 Intelligence, 5 Capacité magique)
     * @param points nombre de points à utiliser
     * @return true si les points ont bien été mis (false sinon, ex : pas assez de points)
     */
    public boolean utiliserPoints(int stat, int points) {
        boolean effectue = false;
        if (points <= this.pts_dispo) {
            effectue = true;
            switch (stat) {
                case 1:
                    this.setForce(getForce() + points);
                    this.pts_dispo -= points;
                    break;
                case 2:
                    this.setConstitution(getConstitution() + points);
                    this.setMAX_VIE(getMAX_VIE() + getConstitution() * 10);
                    this.setVie(getVie() + points * 10);
                    this.pts_dispo -= points;
                    break;
                case 3:
                    this.setDexterite(getDexterite() + points);
                    this.pts_dispo -= points;
                    break;
                case 4:
                    this.setIntelligence(getIntelligence() + points);
                    this.pts_dispo -= points;
                    break;
                case 5:
                    this.setCapacite(getCapacite() + points);
                    this.setMAX_MANA(getCapacite() * 2);
                    this.setMana(getMana() + points * 2);
                    this.pts_dispo -= points;
                    break;
            }
        }
        return effectue;
    }
}
