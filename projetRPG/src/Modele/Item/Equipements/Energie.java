package Modele.Item.Equipements;

import Modele.Item.Equipement;
import Modele.Personnage.Personnage;

import java.util.function.Predicate;

public class Energie extends Equipement {
    public Energie(String nom, String description, String emplacement, int degats, double crit, double precision, int protection, int force, int dexterite, int intelligence) {
        super(nom, description, emplacement, degats, crit, precision, protection, force, dexterite, intelligence);
    }

    public Energie(String nom, String description, String emplacement, int degats, double crit, double precision, int protection, int force, int dexterite, int intelligence, Predicate<Personnage> preRequis) {
        super(nom, description, emplacement, degats, crit, precision, protection, force, dexterite, intelligence, preRequis);
    }
}
