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
    private Equipement arme;
    private Equipement tete;
    private Equipement torse;
    private Equipement jambes;
    private Equipement pieds;


    public Personnage(String nom, ClassePersonnage classe, Inventaire inventaire, int force, int constitution, int dexterite, int intelligence, int capacite) {
        this.nom = nom;
        this.classe = classe;
        this.inventaire = inventaire;
        this.force = force;
        this.constitution = constitution;
        this.dexterite = dexterite;
        this.intelligence = intelligence;
        this.capacite = capacite;
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

    /**
     * Méthode qui équipe un équipement à la bonne place (jambes, arme, torse,etc...)
     * @param equipement - équipement à équiper
     */
    public void equiper(Equipement equipement) {
        // méthode pour équiper un équipement
    }

    /**
     * Méthode qui renvoie un booléen en fonction du coup qui touche
     * @return true si le coup touche, false sinon
     */
    public boolean calculCoupTouche() {
        double probabilite = (double) (this.getDexterite() / 10) * this.getArme().getPrecision();
        double valeurRandom = Math.random();
        //par exemple, le joueur a 7 de dextérité et un arme à 80% de précision, il a donc 0.70 * 0.80 = 0.56 -> 56% de chances de toucher (pas clair, à voir le calcul)
        return valeurRandom <= probabilite;
    }

    /**
     * Méthoe qui calcule les dégâts lorsqu'un coup touche
     * @return int dégats de base sans ajout de dégats critiques
     */
    public int calculDegatsFlat() {
        return 0;
    }

    /**
     * Méthode qui calcule les dégats finaux a envoyer vers l'ennemi, s'il n'y a pas de coup critique, elle renverra la valeur des degats flat
     * @param degatsFlat valeurs de degats de base
     * @return int dégâts finaux
     */
    public int calculDegatsCrit(int degatsFlat){
        return 0;
    }

    /**
     * Méthode qui attaque avec l'arme sur l'adversaire
     * @param adversaire - adversaire à envoyer l'attaque
     */
    public void attaquerArme(Personnage adversaire) {
        // méthode pour l'attaque d'un joueur ou d'un ennemi
    }

    /**
     * Méthode qui attaque avec le sort sur l'adversaire
     * @param adversaire - adversaire à envoyer l'attaque
     */
    public void attaquerSort(Personnage adversaire) {
        // méthode pour lancer un sort sur un adversaire
    }

    /**
     * Méthode qui calcule les dégâts après réduction par la protection
     * @param degats - degats de bas avant réduction
     * @return int dégats finaux à appliquer au joueur
     */
    public int calculReducDegats(int degats){
        return 0;
    }

    /**
     * Méthode qui enlève des points de vie à un personnage lorsqu'il se reçoit un coup
     * @param degats - dégâts infligés par l'adversaire après calcul du coup
     */
    public void recevoirCoup(int degats) {

    }

    @Override
    public String toString() {
        return nom + "\n" + "Vie : " + vie + "/" + getMAX_VIE() + "\n";
    }
}
