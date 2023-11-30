package Modele.Theme.MF.Item;

import Modele.Item.Consommable;
import Modele.Item.Equipements.CorpsACorps;
import Modele.Item.Equipements.Magie;
import Modele.Item.Equipements.Projectile;
import Modele.Personnage.ClassePersonnage;
import Modele.Theme.MF.Item.Consomable.ConsommableBuff;

import java.util.HashSet;
import java.util.Set;

public class Registres {
    public static Set<CorpsACorps> genererCorpsACorps() {
        Set<CorpsACorps> set = new HashSet<>();

        set.add(new CorpsACorps("Bâton", "Un simple bâton", 1, 0, 0.5, 0, 0, 0, 0));
        set.add(new CorpsACorps("Épée émoussée", "Une épée très usée mais qui peut s'avérer utile", 2, 0, 0.6, 0, 0, 0, 0));
        set.add(new CorpsACorps("Épée en fer", "Un simple bâton", 3, 0, 0.6, 0, 0, 0, 0, (j) -> j.getForce() > 2));
        set.add(new CorpsACorps("Espadon du Forgeron", "Un espadon forgé de la main d'un grand forgeron", 5, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("barbare") && j.getForce() > 4));
        set.add(new CorpsACorps("Claymore tueuese de Dragons", "On dit que cette claymore aurait permis de tuer un dragon", 7, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("Barbare") && j.getForce() > 6));
        set.add(new CorpsACorps("Fine rapière", "Légère et simple mais rudement efficace", 4, 0.1, 0.8, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("chevalier") && j.getDexterite() > 2));

        return set;
    }

    public static Set<Magie> genererMagie() {
        Set<Magie> set = new HashSet<>();

        set.add(new Magie("Baguette fragile", "Une simple baguette de débutant", 2, 0, 0.5, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("mage")));
        set.add(new Magie("Baguette précieuse", "Cette baguette brille et a l'air rare", 4, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("mage") && j.getMana() > 2));
        set.add(new Magie("Relique d'un grand Mage", "Cette baguette d'un autre temps a appartenu a un grand mage", 5, 0.07, 0.8, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("mage") && j.getMana() > 4));

        return set;
    }

    public static Set<Projectile> genererProjectile() {
        Set<Projectile> set = new HashSet<>();

        set.add(new Projectile("Arc coubeh", "Un arc très simple", 2, 0, 0.6, 0, 0, 0, 0));
        set.add(new Projectile("Grand Arc", "Il fait plus que votre taille, mais c'est normal", 2, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("archer")));
        set.add(new Projectile("Arbalète en bois", "Une belle arbalète, dommage qu'il faille un temps de recharge", 4, 0.07, 0.5, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("archer") && j.getClasse() == new ClassePersonnage("chevalier")));
        set.add(new Projectile("Arc léger", "un petit arc très pratique à manier", 2, 0, 0.5, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("archer") && j.getClasse() == new ClassePersonnage("chevalier")));
        set.add(new Projectile("Arc en bois d'Orme", "un bel arc en bois noble, de grande qualité !", 6, 0.1, 0.8, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("archer") && j.getDexterite() > 3));

        return set;
    }

    public static Set<Consommable> genererConsomable() {
        Set<Consommable> set = new HashSet<>();

        set.add(new Consommable("Baguette de pain frais", "", 2, 0));
        set.add(new Consommable("Morceau de pain rassis", "", 1, 0));
        set.add(new Consommable("Petit potion de soin", "", 3, 0));
        set.add(new Consommable("Carotte", "", 1, 0));
        set.add(new Consommable("Patate", "", 1, 0));
        set.add(new Consommable("Potion de soin moyenne", "", 5, 0));
        set.add(new Consommable("Grande potion de soin", "", 1000, 0)); // -1 == potion qui baisse la vie ?
        set.add(new Consommable("Petite fiole de mana", "", 0, 1));
        set.add(new Consommable("Flacon de mana", "", 2, 3));
        set.add(new Consommable("Grande potion de mana", "", 2, 5));
        set.add(new ConsommableBuff("Fortifiant", "",0 , 0, 3, 0, 0, 0, 0, 3));
        set.add(new ConsommableBuff("Potion de rage", "",0 , 0, 2, 2, 0, 0, 0, 2));

        return set;
    }
}