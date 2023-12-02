package Modele.Personnage;

import Modele.Item.Equipement;

public abstract class Personnage {
    private String nom;
    private ClassePersonnage classe;
    private Inventaire inventaire;

    //statistiques mouvantes
    private int vie;
    private int MAX_VIE;

    private int mana;
    private int MAX_MANA;

    //caractéristiques
    private int force;
    private int constitution;
    private int dexterite;
    private int intelligence;
    private int capacite;

    //emplacements
    private Equipement arme = new Equipement("main", "une main", "arme", 0,0,0,0,0,0,0);
    private Equipement tete = new Equipement("nu", "tout nu", "tete", 0,0,0,0,0,0,0);
    private Equipement torse = new Equipement("nu", "tout nu", "torse", 0,0,0,0,0,0,0);
    private Equipement jambes = new Equipement("nu", "tout nu", "jambes", 0,0,0,0,0,0,0);
    private Equipement pieds = new Equipement("nu", "tout nu", "pieds", 0,0,0,0,0,0,0);


    public Personnage(String nom, ClassePersonnage classe, Inventaire inventaire, int force, int constitution, int dexterite, int intelligence, int capacite) {
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

    public Equipement getArme() {
        return arme;
    }

    public void setArme(Equipement arme) {
        this.arme = arme;
    }

    public Equipement getTete() {
        return tete;
    }

    public void setTete(Equipement tete) {
        this.tete = tete;
    }

    public Equipement getTorse() {
        return torse;
    }

    public void setTorse(Equipement torse) {
        this.torse = torse;
    }

    public Equipement getJambes() {
        return jambes;
    }

    public void setJambes(Equipement jambes) {
        this.jambes = jambes;
    }

    public Equipement getPieds() {
        return pieds;
    }

    public void setPieds(Equipement pieds) {
        this.pieds = pieds;
    }


    //Méthodes pour les attaques (lancer et recevoir)

    /**
     * Méthode qui renvoie un booléen en fonction de si le coup touche
     *
     * @return true si le coup touche, false sinon
     */
    public boolean coupTouche() {
        double probabilite = (double) (this.dexterite / 10) * this.arme.getPrecision();
        //par exemple, le joueur a 7 de dextérité et un arme à 80% de précision, il a donc 0.70 * 0.80 = 0.56 -> 56% de chances de toucher (pas clair, à voir le calcul)
        return Math.random() <= probabilite;
    }

    /**
     * Méthoe qui calcule les dégâts lorsqu'un coup touche
     *
     * @return int dégats de base sans ajout de dégats critiques
     */
    public int degatsArme() {
        return this.force + this.arme.getDegats();
    }


    /**
     * Méthode qui calcule les dégats finaux a envoyer vers l'ennemi, s'il n'y a pas de coup critique, elle renverra la valeur des degats flat
     *
     * @param degatsFlat valeurs de degats de base
     * @return int dégâts finaux
     */
    public int degatsCrit(int degatsFlat) {
        if (Math.random() <= this.arme.getCrit()) {
            degatsFlat *= (int) (1 + Math.random());
        }
        return degatsFlat;
    }

    /**
     * Méthode qui attaque avec l'arme sur l'adversaire
     *
     * @param adversaire adversaire à envoyer l'attaque
     * @return int degats que le joueur adverse subit
     */
    public int attaquerArme(Personnage adversaire) {
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
    public void attaquerSort(Personnage adversaire) {
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
        int armure = this.arme.getProtection() + this.tete.getProtection() + this.torse.getProtection() + this.jambes.getProtection() + this.pieds.getProtection();
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
            this.vie -= degatsReels;
        }
        return degatsReels;
    }

    //Méthodes de gestion d'inventaire

    /**
     * Méthode qui équipe un équipement à la bonne place (jambes, arme, torse,etc...)
     *
     * @param equipement équipement à équiper
     * @return boolean l'équipement a bien été équipé
     */
    public boolean equiper(Equipement equipement) {
        boolean effectue = false;
        if (equipement.getPreRequis().test(this)) {
            switch (equipement.getEmplacement()) {
                case "arme":
                    this.arme = equipement;
                    break;
                case "tete":
                    this.tete = equipement;
                    break;
                case "torse":
                    this.torse = equipement;
                    break;
                case "jambes":
                    this.jambes = equipement;
                    break;
                case "pieds":
                    this.pieds = equipement;
                    break;
            }
            effectue = true;
        }
        return effectue;
        //Il manque la rendue d'item si ça en remplace un + suppression d'item de l'inventaire si ça l'équipe
    }

    //Méthodes de gestion du joueur

    /**
     * Renvoie s'il reste de la vie à un joueur
     *
     * @return boolean true s'il est en vie, false s'il est mort
     */
    public boolean estEnVie() {
        return vie > 0;
    }

    @Override
    public String toString() {
        return nom + "\n" + "Vie : " + vie + "/" + getMAX_VIE() + "\n";
    }
}
