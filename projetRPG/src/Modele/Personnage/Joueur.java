package Modele.Personnage;

import Modele.Item.Equipement;

public class Joueur {
    private String nom;
    private ClassePersonnage classe;
    private Inventaire inventaire;

    //statistiques mouvantes
    private int vie;
    private int MAX_VIE;

    private int mana;
    private int MAX_MANA;
    private int pts_dispo;

    //caractéristiques
    private int force;
    private int constitution;
    private int dexterite;
    private int intelligence;
    private int capacite;

    // on a déplacé le stuff dans l'inventaire


    public Joueur(String nom, ClassePersonnage classe, Inventaire inventaire, int force, int constitution, int dexterite, int intelligence, int capacite) {
        this.nom = nom;
        this.classe = classe;
        this.inventaire = inventaire;
        this.force = force;
        this.constitution = constitution;
        this.dexterite = dexterite;
        this.intelligence = intelligence;
        this.capacite = capacite;
        this.MAX_VIE = constitution * 10;
        this.vie = MAX_VIE;
        this.MAX_MANA = capacite * 2;
        this.mana = MAX_MANA;
        this.pts_dispo = 0;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

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

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }

    public int getMAX_VIE() {
        return MAX_VIE;
    }

    public void setMAX_VIE(int MAX_VIE) {
        this.MAX_VIE = MAX_VIE;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getMAX_MANA() {
        return MAX_MANA;
    }

    public void setMAX_MANA(int MAX_MANA) {
        this.MAX_MANA = MAX_MANA;
    }

    public int getPts_dispo() {
        return pts_dispo;
    }

    public void setPts_dispo(int pts_dispo) {
        this.pts_dispo = pts_dispo;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    public int getDexterite() {
        return dexterite;
    }

    public void setDexterite(int dexterite) {
        this.dexterite = dexterite;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }


    //Méthodes pour les attaques (lancer et recevoir)

    /**
     * Méthode qui renvoie un booléen en fonction de si le coup touche
     *
     * @return true si le coup touche, false sinon
     */
    public boolean coupTouche() {
        double probabilite = (((double) this.dexterite / 10) + inventaire.getEquipement("arme").getPrecision()) / 2;
        //par exemple, le joueur a 7 de dextérité et une arme à 80% de précision, il a donc 0.70 * 0.80 = 0.56 -> 56% de chances de toucher (pas clair, à voir le calcul)
        double random = Math.random();
        return random <= probabilite;
    }

    /**
     * Méthoe qui calcule les dégâts lorsqu'un coup touche
     *
     * @return int dégats de base sans ajout de dégats critiques
     */
    public int degatsArme() {
        return this.force + inventaire.getEquipement("arme").getDegats();
    }


    /**
     * Méthode qui calcule les dégats finaux a envoyer vers l'ennemi, s'il n'y a pas de coup critique, elle renverra la valeur des degats flat
     *
     * @param degatsFlat valeurs de degats de base
     * @return int dégâts finaux
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
     * @return int degats que le joueur adverse subit
     */
    public int attaquerArme(Joueur adversaire) {
        int degats = 0;
        if (this.coupTouche()) {
            degats = this.degatsCrit(this.degatsArme());
        }
        return adversaire.recevoirCoup(degats);
    }

    /**
     * Méthode qui calcule la valeur de dégâts de base d'un sort
     *
     * @param niveau le niveau du sort (1 pour sort simple, 2 pour sort ultime)
     * @return int dégâts du sort
     */
    public int degatsSort(int niveau) {
        return this.intelligence * 2 * niveau;
    }

    /**
     * Méthode qui attaque avec le sort sur l'adversaire (un sort touche toujours)
     *
     * @param adversaire adversaire à envoyer l'attaque
     */
    public void attaquerSort(Joueur adversaire) {
        int degats = 0;
        degats = degatsSort(1);
        adversaire.recevoirCoup(degats);
    }

    /**
     * Méthode qui calcule les dégâts après réduction par la protection
     *
     * @param degats degats de bas avant réduction
     * @return int dégats finaux à appliquer au joueur
     */
    public int reducDegats(int degats) {
        int armure = inventaire.getEquipement("arme").getProtection() + inventaire.getEquipement("tete").getProtection() + inventaire.getEquipement("torse").getProtection() + inventaire.getEquipement("jambes").getProtection() + inventaire.getEquipement("pieds").getProtection();
        return degats - (armure / 2);
    }

    /**
     * Méthode qui enlève des points de vie à un personnage lorsqu'il se reçoit un coup
     *
     * @param degats dégâts infligés par l'adversaire après calcul du coup
     * @return int degats que le joueur subit
     */
    public int recevoirCoup(int degats) {
        int degatsReels = reducDegats(degats);
        if (degatsReels > 0) {
            vie -= degatsReels;
        }
        return degatsReels;
    }

    //Méthodes de gestion d'inventaire

    /**
     * Permet de jeter un item de l'inventaire, ce qui le supprimera de son inventaire, et l'ajoutera à celui de la salle
     *
     * @param index numéro de l'item à supprimer
     */
    public void jeterItem(int index) {
        //ajouter l'item à l'inventaire de la salle
        inventaire.supprItem(index);
    }

    /**
     * Méthode qui équipe un équipement à la bonne place (jambes, arme, torse,etc...)
     *
     * @param equipement équipement à équiper
     * @return boolean l'équipement a bien été équipé
     */
    public boolean equiper(Equipement equipement) {
        boolean effectue = false;
        if (equipement.getPreRequis().test(this)) {
            this.ajouterStats(equipement.getForce(), equipement.getDexterite(), equipement.getIntelligence());
            inventaire.setEquipement(equipement);
            this.inventaire.supprItem(equipement);
            effectue = true;
        }
        return effectue;
    }

    /**
     * Méthode qui déséquipe un équipement s'il y en a un, et le remet dans l'inventaire
     *
     * @param emplacement emplacement à déséquiper
     * @return true si c'est bien déséquipé, false sinon
     */
    public boolean desequiper(String emplacement) {
        boolean effectue = false;
        if (inventaire.getEquipement(emplacement).getEmplacement() != "partout") { // Attention ne pas simplifier par juste emplacement car les items spéciaux "tout nu" sont en emplacement "partout"
            Equipement eqp = inventaire.getEquipement(emplacement);
            this.retirerStats(eqp.getForce(), eqp.getDexterite(), eqp.getIntelligence());
            inventaire.ajouterItem(eqp);
            inventaire.resetEquipement(emplacement);
            effectue = true;
        }
        return effectue;
    }

    //Méthodes de gestion du joueur

    /**
     * Ajoute de la vie en vérifiant que la statistique max n'est pas dépassée
     *
     * @param vie quantité de vie à ajouter
     */
    public void ajouterVie(int vie) {
        if (this.vie + vie >= MAX_VIE) {
            this.vie = MAX_VIE;
        } else this.vie += vie;
    }

    /**
     * Ajoute du mana en vérifiant que la statistique max n'est pas dépassée
     *
     * @param mana quantité de mana à ajouter
     */
    public void ajouterMana(int mana) {
        if (this.mana + mana >= MAX_MANA) {
            this.mana = MAX_MANA;
        } else this.mana += mana;
    }

    /**
     * Ajoute des statistiques au joueur (utile lorsqu'on équipe)
     *
     * @param force        force à ajouter
     * @param dexterite    dextérité à ajouter
     * @param intelligence intelligence à ajouter
     */
    public void ajouterStats(int force, int dexterite, int intelligence) {
        this.force += force;
        this.dexterite += dexterite;
        this.intelligence += intelligence;
    }

    /**
     * Retire des statistiques au joueur (utile lorsqu'on déséquipe)
     *
     * @param force        force à retirer
     * @param dexterite    dextérité à retirer
     * @param intelligence intelligence à retirer
     */
    public void retirerStats(int force, int dexterite, int intelligence) {
        this.force -= force;
        this.dexterite -= dexterite;
        this.intelligence -= intelligence;
    }

    public boolean utiliserPoints(int points, String stat) {
        boolean effectue = false;
        if (points <= this.pts_dispo) {
            effectue = true;
            switch (stat) {
                case "force":
                    this.force += points;
                    this.pts_dispo -= points;
                    break;
                case "constitution":
                    this.constitution += points;
                    this.pts_dispo -= points;
                    break;
                case "dexterite":
                    this.dexterite += points;
                    this.pts_dispo -= points;
                    break;
                case "intelligence":
                    this.intelligence += points;
                    this.pts_dispo -= points;
                    break;
                case "capacite":
                    this.capacite += points;
                    this.pts_dispo -= points;
                    break;
            }
        }
        return effectue;
    }

    /**
     * Renvoie s'il reste de la vie à un joueur
     *
     * @return boolean true s'il est en vie, false s'il est mort
     */
    public boolean estEnVie() {
        return vie > 0;
    }

    public String toString() {
        return nom + "\n" +
                "Vie : " + vie + "/" + MAX_VIE + "\n" +
                "Mana : " + mana + "/" + MAX_MANA + "\n" +
                "Classe : " + classe.getType() + "\n" +
                "\nStatistiques :\n" +
                "Force : " + force + "\n" +
                "Constitution : " + constitution + "\n" +
                "Dextérité : " + dexterite + "\n" +
                "Intelligence : " + intelligence + "\n" +
                "Capacité Magique : " + capacite + "\n" +
                "Équipement :\n" +
                "Arme : " + inventaire.getEquipement("arme") + "\n" +
                "Tête : " + inventaire.getEquipement("tete") + "\n" +
                "Torse : " + inventaire.getEquipement("torse") + "\n" +
                "Jambes : " + inventaire.getEquipement("jambes") + "\n" +
                "Pieds : " + inventaire.getEquipement("pieds") + "\n" +
                "Probabilité de toucher : " + (int) (((((double) getDexterite() / 10) + inventaire.getEquipement("arme").getPrecision()) / 2) * 100) + "%" +
                "\nInventaire :\n" + inventaire;
    }
}
