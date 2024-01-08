package Modele.Personnage;

import Modele.Item.Consommable;
import Modele.Item.Equipement;
import Modele.Item.Item;

public abstract class Personnage {
    private String nom;

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

    // on a déplacé le stuff dans l'inventaire


    public Personnage(String nom, int force, int constitution, int dexterite, int intelligence, int capacite) {
        this.nom = nom;
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

    public Personnage(String nom, int vie, int MAX_VIE, int mana, int MAX_MANA, int force, int constitution, int dexterite, int intelligence, int capacite) {
        this.nom = nom;
        this.vie = vie;
        this.MAX_VIE = MAX_VIE;
        this.mana = mana;
        this.MAX_MANA = MAX_MANA;
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


    //Méthodes pour les attaques (lancer et recevoir)

    /**
     * Méthode qui calcule la valeur de dégâts de base d'un sort
     *
     * @return les dégâts du sort
     */
    public int degatsSort() {
        return this.intelligence * 2;
    }

    /**
     * Méthode qui attaque avec le sort sur l'adversaire (un sort touche toujours)
     *
     * @param adversaire adversaire à envoyer l'attaque
     * @return les dégâts que le joueur adverse subit
     */
    public int attaquerSort(Personnage adversaire) {
        if (this.mana >= 2) {
            this.mana -= 2;
            return adversaire.recevoirCoup(degatsSort());
        } else {
            return 0;
        }
    }

    protected abstract boolean coupTouche();

    public abstract int attaquerArme(Personnage adversaire);

    protected abstract int recevoirCoup(int degats);

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
     * Ajoute des statistiques au personnage (utile lorsqu'on équipe)
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
     * Retire des statistiques au personnage (utile lorsqu'on déséquipe)
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

    /**
     * Renvoie s'il reste de la vie à un personnage
     *
     * @return true s'il est en vie, false s'il est mort
     */
    public boolean estEnVie() {
        return vie > 0;
    }

    public String toString() {
        return "Personnage : " + nom;
    }

    public abstract ClassePersonnage getClasse();
}
