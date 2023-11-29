package Modele.Item;

import Modele.Item.Item;
import Modele.Personnage.Joueur;
import Modele.Personnage.Personnage;

import java.util.function.Predicate;

public class Equipement extends Item {
    //stats uniquement armes

    private int degats; //valeur de dégâts
    private double crit; //taux de crit (ex: 0.07 pour 7%)
    private double precision; //taux de précision (ex: 0.50 pour 50%)

    //stats armes et armures

    private int protection; //valeur de protection

    //stats uniquement armures

    private int force; //buff stat force
    private int dexterite; //buff stat dexterite
    private int intelligence; //buff stat intelligence

    // pré requis
    private Predicate<Personnage> preRequis;

    public Equipement(String nom, String description, int degats, double crit, double precision, int protection, int force, int dexterite, int intelligence) {
        super(nom, description);
        this.degats = degats;
        this.crit = crit;
        this.precision = precision;
        this.protection = protection;
        this.force = force;
        this.dexterite = dexterite;
        this.intelligence = intelligence;
    }

    public Equipement(String nom, String description, int degats, double crit, double precision, int protection, int force, int dexterite, int intelligence, Predicate<Personnage> preRequis) {
        this(nom, description, degats, crit, precision, protection, force, dexterite, intelligence);
        this.preRequis = preRequis;
    }

    public int getDegats() {
        return degats;
    }

    public double getCrit() {
        return crit;
    }

    public double getPrecision() {
        return precision;
    }

    public int getProtection() {
        return protection;
    }

    public int getForce() {
        return force;
    }

    public int getDexterite() {
        return dexterite;
    }

    public int getIntelligence() {
        return intelligence;
    }
}
