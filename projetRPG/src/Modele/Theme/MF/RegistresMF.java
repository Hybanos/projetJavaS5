package Modele.Theme.MF;

import Modele.Item.Consommable;
import Modele.Item.Equipement;
import Modele.Personnage.ClassePersonnage;

import java.util.HashMap;
import java.util.Map;

public class RegistresMF {

    /* Ca sert plus a rien mais je laisse ca au cas ou
    private static int currInt;
    private static int nextInt() {
        return currInt++;
    }
    */

    public static Map<Integer, ClassePersonnage> genererClasses() {
        Map<Integer, ClassePersonnage> map = new HashMap<>();

        map.put(1, new ClassePersonnage("barbare"));
        map.put(2, new ClassePersonnage("mage"));
        map.put(3, new ClassePersonnage("archer"));
        map.put(4, new ClassePersonnage("chevalier"));
        map.put(5, new ClassePersonnage("assassin"));

        return map;
    }

    public static Map<Integer, Consommable> genererConsomable() {
        Map<Integer, Consommable> map = new HashMap<>();
        
        map.put(10,new Consommable("Baguette de pain frais", "", 2, 0));
        map.put(11,new Consommable("Morceau de pain rassis", "", 1, 0));
        map.put(12,new Consommable("Petit potion de soin", "", 3, 0));
        map.put(13,new Consommable("Carotte", "", 1, 0));
        map.put(14,new Consommable("Patate", "", 1, 0));
        map.put(15,new Consommable("Potion de soin moyenne", "", 5, 0));
        map.put(16,new Consommable("Grande potion de soin", "", 1000, 0)); // -1 == potion qui baisse la vie ?
        map.put(17,new Consommable("Petite fiole de mana", "", 0, 1));
        map.put(18,new Consommable("Flacon de mana", "", 2, 3));
        map.put(19,new Consommable("Grande potion de mana", "", 2, 5));

        return map;
    }

    public static Map<Integer, Equipement> genererEquipements() {
        Map<Integer, Equipement> map = new HashMap<>();

        // Corps à Corps
        map.put(100,new Equipement("Main", "Une main", "partout", 0, 0, 0, 0, 0, 0, 0));
        map.put(101,new Equipement("Bâton", "Un simple bâton", "arme", 1, 0, 0.5, 0, 0, 0, 0));
        map.put(102,new Equipement("Épée émoussée", "Une épée très usée mais qui peut s'avérer utile", "arme", 2, 0, 0.6, 0, 0, 0, 0));
        map.put(103,new Equipement("Épée en fer", "Un simple bâton", "arme", 3, 0, 0.6, 0, 0, 0, 0, (j) -> j.getForce() > 2));
        map.put(104,new Equipement("Espadon du Forgeron", "Un espadon forgé de la main d'un grand forgeron", "arme", 5, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("barbare") && j.getForce() > 4));
        map.put(105,new Equipement("Claymore tueuese de Dragons", "On dit que cette claymore aurait permis de tuer un dragon", "arme", 7, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("Barbare") && j.getForce() > 6));
        map.put(106,new Equipement("Fine rapière", "Légère et simple mais rudement efficace", "arme", 4, 0.1, 0.8, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("chevalier") && j.getDexterite() > 2));

        // Distance
        map.put(110,new Equipement("Baguette fragile", "Une simple baguette de débutant", "arme", 2, 0, 0.5, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("mage")));
        map.put(111,new Equipement("Baguette précieuse", "Cette baguette brille et a l'air rare", "arme", 4, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("mage") && j.getMana() > 2));
        map.put(112,new Equipement("Relique d'un grand Mage", "Cette baguette d'un autre temps a appartenu a un grand mage", "arme", 5, 0.07, 0.8, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("mage") && j.getMana() > 4));

        // Magie
        map.put(120,new Equipement("Arc coubeh", "Un arc très simple", "arme", 2, 0, 0.6, 0, 0, 0, 0));
        map.put(121,new Equipement("Grand Arc", "Il fait plus que votre taille, mais c'est normal", "arme", 2, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("archer")));
        map.put(122,new Equipement("Arbalète en bois", "Une belle arbalète, dommage qu'il faille un temps de recharge", "arme", 4, 0.07, 0.5, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("archer") && j.getClasse() == new ClassePersonnage("chevalier")));
        map.put(123,new Equipement("Arc léger", "un petit arc très pratique à manier", "arme", 2, 0, 0.5, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("archer") && j.getClasse() == new ClassePersonnage("chevalier")));
        map.put(124,new Equipement("Arc en bois d'Orme", "un bel arc en bois noble, de grande qualité !", "arme", 6, 0.1, 0.8, 0, 0, 0, 0, (j) -> j.getClasse() == new ClassePersonnage("archer") && j.getDexterite() > 3));

        // Armures

        map.put(200, new Equipement("Nu", "Tout nu", "partout", 0, 0, 0, 0, 0, 0, 0));
        map.put(201, new Equipement("Casque en cuir", "Un petit casque en cuir. Simple mais protège un peu", "tete", 0, 0, 0, 2, 0, 0, 0));
        map.put(207, new Equipement("Manteau en cuir", "Un grand manteau en cuir, il est classe mais pas très utile", "torse", 0, 0, 0, 2, 0, 0, 0));
        map.put(213, new Equipement("Pantalon en cuir", "Un simple pantalon en cuir légèrement usé", "jambes", 0, 0, 0, 2, 0, 0, 0));
        map.put(214, new Equipement("Bottes en cuir", "Des bottes en cuir un peu étanches", "pieds", 0, 0, 0, 2, 0, 0, 0));

        return map;
    }
}