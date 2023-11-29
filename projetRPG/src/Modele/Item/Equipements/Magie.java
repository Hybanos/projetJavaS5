package Modele.Item.Equipements;

import Modele.Item.Equipement;
import Modele.Personnage.Personnage;

import java.util.function.Predicate;

public class Magie extends Equipement {
    public Magie(String nom, String description, int degats, double crit, double precision, int protection, int force, int dexterite, int intelligence) {
        super(nom, description, degats, crit, precision, protection, force, dexterite, intelligence);
    }

    public Magie(String nom, String description, int degats, double crit, double precision, int protection, int force, int dexterite, int intelligence, Predicate<Personnage> preRequis) {
        super(nom, description, degats, crit, precision, protection, force, dexterite, intelligence, preRequis);
    }
}
