package Modele.Theme.MF;

import Controleur.Controleur;
import Modele.Item.Bibelot;
import Modele.Item.Consommable;
import Modele.Item.Equipement;
import Modele.Personnage.Ennemi;

import java.util.HashMap;
import java.util.Map;

public class RegistresMF {

    private static final Controleur c = Controleur.getInstance();

    public static Map<Integer, String> genererClasses() {
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "barbare");
        map.put(2, "mage");
        map.put(3, "archer");
        map.put(4, "chevalier");
        map.put(5, "assassin");

        return map;
    }

    public static Map<Integer, Consommable> genererConsomable() {
        Map<Integer, Consommable> map = new HashMap<>();

        map.put(1, new Consommable("Baguette de pain frais", "Une baguette pas trop cuite s'il vous plait ! \u001B[32m+2 Vie\u001B[0m", 2, 0));
        map.put(2, new Consommable("Morceau de pain rassis", "Ce vieux morceau de pain fait triste mine \u001B[32m+1 Vie\u001B[0m", 1, 0));
        map.put(3, new Consommable("Carotte", "Cette carotte, bien que crue, a l'air apétissante \u001B[32m+1 Vie\u001B[0m", 1, 0));
        map.put(4, new Consommable("Patate","Une simple pomme de terre crue, elle a l'air mangeable \u001B[32m+1 Vie\u001B[0m" , 1, 0));
        map.put(5, new Consommable("Petite potion de soin", "Une petite potion qui régénère un peu de vie \u001B[32m+3 Vie\u001B[0m", 3, 0));
        map.put(6, new Consommable("Potion de soin moyenne", "Cette moyenne potion permet de se soigner en partie \u001B[32m+5 Vie\u001B[0m", 5, 0));
        map.put(7, new Consommable("Grande potion de soin", "Un grande potion de soin, est très efficace pour se soigner \u001B[32m+10 Vie\u001B[0m", 10, 0)); // -1 == potion qui baisse la vie ?
        map.put(8, new Consommable("Petite fiole de mana", "Cette petite fiole vous permettra de récupérer un peu de mana \u001B[32m+1 Mana\u001B[0m", 0, 1));
        map.put(9, new Consommable("Flacon de mana", "Un flacon qui tient dans une poche avec un liquide étrange \u001B[32m+3 Mana\u001B[0m", 0, 3));
        map.put(10, new Consommable("Grande potion de mana", "Cette grande poition a l'air bien utile pour la magie \u001B[32m+5 Mana\u001B[0m", 0, 5));

        return map;
    }

    public static Map<Integer, Equipement> genererArmes() {
        Map<Integer, Equipement> map = new HashMap<>();

        //Armes
        map.put(100, new Equipement("Main", "Une main", "partout", 0, 0, 0, 0, 0, 0, 0));
        map.put(101, new Equipement("Bâton", "Un simple bâton \u001B[32m+1 Dégâts, Précision : 50%\u001B[0m", "arme", 1, 0, 0.5, 0, 0, 0, 0));
        map.put(102, new Equipement("Épée émoussée", "Une épée très usée mais qui peut s'avérer utile \u001B[32m+2 Dégâts, Précision : 60%\u001B[0m", "arme", 2, 0, 0.6, 0, 0, 0, 0));
        map.put(103, new Equipement("Épée en fer", "Une simple épée en fer \u001B[31m(Force min : 3)\u001B[0m \u001B[32m+3 Dégâts, Précision : 60%\u001B[0m", "arme", 3, 0, 0.6, 0, 0, 0, 0, (j) -> j.getForce() > 2));
        map.put(104, new Equipement("Espadon du Forgeron", "Un espadon forgé de la main d'un grand forgeron \u001B[31m(Classe : Barbare / Chevalier, Force min : 5)\u001B[0m \u001B[32m+5 Dégâts, Précision : 70%, Crit : 7%\u001B[0m", "arme", 5, 0.07, 0.7, 0, 0, 0, 0, (j) -> (j.getClasse() == c.getTheme().getLesClasses().get(1) || j.getClasse() == c.getTheme().getLesClasses().get(4)) && j.getForce() > 4));
        map.put(105, new Equipement("Claymore tueuese de Dragons", "On dit que cette claymore aurait permis de tuer un dragon \u001B[31m(Classe : Barbare, Force min : 7)\u001B[0m \u001B[32m+7 Dégâts, Précision : 70%, Crit : 10%\u001B[0m", "arme", 7, 0.1, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(1) && j.getForce() > 6));
        map.put(106, new Equipement("Fine rapière", "Légère et simple mais rudement efficace \u001B[31m(Classe : Chevalier, Dextérité min : 3)\u001B[0m \u001B[32m+4 Dégâts, Précision : 80%, Crit : 10%\u001B[0m", "arme", 4, 0.1, 0.8, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(4) && j.getDexterite() > 2));
        map.put(107, new Equipement("Baguette fragile", "Une simple baguette de débutant \u001B[31m(Classe : Mage)\u001B[0m \u001B[32m+2 Dégâts, Précision : 50%\u001B[0m", "arme", 2, 0, 0.5, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(2)));
        map.put(108, new Equipement("Baguette précieuse", "Cette baguette brille et a l'air rare \u001B[31m(Classe : Mage, Intelligence min : 3)\u001B[0m \u001B[32m+4 Dégâts, Précision : 70%, Crit : 7%\u001B[0m", "arme", 4, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(2) && j.getIntelligence() > 2));
        map.put(109, new Equipement("Relique d'un grand Mage", "Cette baguette d'un autre temps a appartenu a un grand mage \u001B[31m(Classe : Mage, Intelligence min : 5)\u001B[0m \u001B[32m+5 Dégâts, Précision : 80%, Crit : 7%\u001B[0m", "arme", 5, 0.07, 0.8, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(2) && j.getIntelligence() > 4));
        map.put(110, new Equipement("Arc courbé", "Un arc très simple \u001B[32m+2 Dégâts, Précision : 60%\u001B[0m", "arme", 2, 0, 0.6, 0, 0, 0, 0));
        map.put(111, new Equipement("Grand Arc", "Il fait plus que votre taille, mais c'est normal \u001B[31m(Classe : Archer)\u001B[0m \u001B[32m+2 Dégâts, Précision : 70%\u001B[0m", "arme", 2, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(3)));
        map.put(112, new Equipement("Arbalète en bois", "Une belle arbalète, dommage qu'il faille un temps de recharge \u001B[31m(Classe : Archer / Chevalier)\u001B[0m \u001B[32m+4 Dégâts, Précision : 50%, Crit : 7%\u001B[0m", "arme", 4, 0.07, 0.5, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(3) || j.getClasse() == c.getTheme().getLesClasses().get(4)));
        map.put(113, new Equipement("Arc léger", "un petit arc très pratique à manier \u001B[31m(Classe : Archer / Chevalier)\u001B[0m \u001B[32m+2 Dégâts, Précision : 50%\u001B[0m", "arme", 2, 0, 0.5, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(3) || j.getClasse() == c.getTheme().getLesClasses().get(4)));
        map.put(114, new Equipement("Arc en bois d'Orme", "un bel arc en bois noble, de grande qualité ! \u001B[31m(Classe : Archer, Dextérité min : 4)\u001B[0m \u001B[32m+6 Dégâts, Précision : 80%, Crit : 10%\u001B[0m", "arme", 6, 0.1, 0.8, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(3) && j.getDexterite() > 3));
        map.put(115, new Equipement("Couteau de cuisine", "Un grand couteau, sûrement volé dans un restaurant \u001B[32m+2 Dégâts, Précision : 60%\u001B[0m", "arme", 2, 0, 0.6, 0, 0, 0, 0));
        map.put(116, new Equipement("Dagues simples", "Deux petites dagues très pratiques à cacher \u001B[31m(Dextérité min : 3)\u001B[0m \u001B[32m+2 Dégâts, Précision : 70%\u001B[0m", "arme", 2, 0, 0.7, 0, 0, 0, 0, (j) -> j.getDexterite() > 2));
        map.put(117, new Equipement("Dagues renforcées", "Elles sont plus légères et maniables, en plus d'être belles \u001B[31m(Classe : Assassin, Dextérité min : 5)\u001B[0m \u001B[32m+4 Dégâts, Précision : 90%, Crit : 10%\u001B[0m", "arme", 4, 0.1, 0.9, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(5) && j.getDexterite() > 4));
        map.put(118, new Equipement("Bouclier en bois", "Un petit bouclier rond en bois, permet de de protéger mais fait peu de dégâts \u001B[32m+2 Protection, +1 Dégâts, Précision : 60%\u001B[0m", "arme", 1, 0, 0.6, 2, 0, 0, 0));
        map.put(119, new Equipement("Bouclier renforcé", "Un grand bouclier avec du fer, protège bien mais ne permet pas de taper fort \u001B[31m(Classe : Chevalier, Force min : 3)\u001B[0m \u001B[32m+4 Protection, +2 Dégâts, Précision : 60%\u001B[0m", "arme", 2, 0, 0.6, 4, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(4) && j.getForce() > 2));
        map.put(120, new Equipement("Lance élancée", "Une lance qui permet de taper assez loin \u001B[32m+4 Dégâts, Précision : 80%, Crit : 7%\u001B[0m", "arme", 4, 0.07, 0.8, 0, 0, 0, 0));

        return map;
    }


    public static Map<Integer, Equipement> genererArmures() {
        Map<Integer, Equipement> map = new HashMap<>();

        //Armures
        map.put(200, new Equipement("Nu", "Tout nu", "partout", 0, 0, 0, 0, 0, 0, 0));
        map.put(201, new Equipement("Casque en cuir", "Un petit casque en cuir. Simple mais protège un peu \u001B[32m+2 Protection\u001B[0m", "tete", 0, 0, 0, 2, 0, 0, 0));
        map.put(202, new Equipement("Casque en fer", "Un lourd casque en fer, plus solide et résistant \u001B[31m(Classe : Barbare / Chevalier)\u001B[0m \u001B[32m+3 Protection\u001B[0m", "tete", 0, 0, 0, 3, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(1) || j.getClasse() == c.getTheme().getLesClasses().get(4)));
        map.put(203, new Equipement("Heaume en fer", "Un grand heaume de fer, pratique pour se protéger le visage \u001B[31m(Classe : Chavelier, Force min : 5)\u001B[0m \u001B[32m+4 Protection, +1 Force\u001B[0m", "tete", 0, 0, 0, 4, 1, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(4) && j.getForce() > 4));
        map.put(204, new Equipement("Chapeau de magicien", "Ce chapeau de magicien est un classique de la tenue d'un mage \u001B[31m(Classe : Mage)\u001B[0m \u001B[32m+2 Protection, +1 Intelligence\u001B[0m", "tete", 0, 0, 0, 2, 0, 0, 1, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(2)));
        map.put(205, new Equipement("Capuche d'assassin", "Il parait que porter une capuche en public te rend invisible \u001B[31m(Classe : Assassin)\u001B[0m \u001B[32m+2 Protection, +1 Dextérité\u001B[0m", "tete", 0, 0, 0, 2, 0, 1, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(5)));
        map.put(206, new Equipement("Bonnet des bois", "Un petit bonnet vert qui fait penser à un lutin des bois \u001B[31m(Classe : Archer)\u001B[0m \u001B[32m+1 Protection, +1 Dextérité\u001B[0m", "tete", 0, 0, 0, 1, 0, 1, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(3)));
        map.put(207, new Equipement("Manteau en cuir", "Un grand manteau en cuir, il est classe mais pas très utile \u001B[32m+2 Protection\u001B[0m", "torse", 0, 0, 0, 2, 0, 0, 0));
        map.put(208, new Equipement("Cotte de mailles", "Un grande cotte de maille, un peu lourde mais protège bien \u001B[31m(Force min : 3)\u001B[0m \u001B[32m+3 Protection, +1 Force\u001B[0m", "torse", 0, 0, 0, 3, 1, 0, 0, (j) -> j.getForce() > 2));
        map.put(209, new Equipement("Plastron en fer", "Ce beau plastron en fer est très lourd et imposant mais il n'y a rien de mieux ! \u001B[31m(Classe : Chevalier, Force min : 5)\u001B[0m \u001B[32m+5 Protection, +1 Force\u001B[0m", "torse", 0, 0, 0, 5, 1, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(4) && j.getForce() > 4));
        map.put(210, new Equipement("Cape du mage", "On dit que cette cape pourrait rendre invisible \u001B[31m(Classe : Mage)\u001B[0m \u001B[32m+2 Protection, +1 Intelligence\u001B[0m", "torse", 0, 0, 0, 2, 0, 0, 1, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(2)));
        map.put(211, new Equipement("Cape d'assassin", "Cette cape a un peu de paille sur elle, bizarre... \u001B[31m(Classe : Assassin)\u001B[0m \u001B[32m+2 Protection, +1 Dextérité\u001B[0m", "torse", 0, 0, 0, 2, 0, 1, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(5)));
        map.put(212, new Equipement("Tunique verte", "Une belle tunique qui irait bien avec un bonnet vert et de petites chaussures légères \u001B[31m(Classe : Archer)\u001B[0m \u001B[32m+2 Protection, +1 Dextérité\u001B[0m", "torse", 0, 0, 0, 2, 0, 1, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(3)));
        map.put(213, new Equipement("Pantalon en cuir", "Un simple pantalon en cuir légèrement usé \u001B[32m+2 Protection\u001B[0m", "jambes", 0, 0, 0, 2, 0, 0, 0));
        map.put(214, new Equipement("Pantalon renforcé", "Ce pantalon a l'air renforcé avec du fer au niveau des genous \u001B[31m(Force min : 3)\u001B[0m \u001B[32m+3 Protection, +1 Force\u001B[0m", "jambes", 0, 0, 0, 3, 1, 0, 0, (j) -> j.getForce() > 2));
        map.put(215, new Equipement("Jambières en fer", "De grandes jambières, un peu lourdes et ralentissantes mais donne un style de robot \u001B[31m(Classe : Chevalier, Force min : 5)\u001B[0m \u001B[32m+4 Protection, +1 Force\u001B[0m", "jambes", 0, 0, 0, 4, 1, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(4) && j.getForce() > 4));
        map.put(216, new Equipement("Pantalon en peau de sanglier", "Une petite fourrure au niveau de la ceinture, et un tissu bleu, rien d'incroyable mais ça rend bien \u001B[31m(Classe : Barbare)\u001B[0m \u001B[32m+3 Protection, +2 Force\u001B[0m", "jambes", 0, 0, 0, 3, 2, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(1)));
        map.put(217, new Equipement("Chaussures Classiques", "Bah c'est des chaussures, pas de marques, rien \u001B[32m+1 Protection\u001B[0m", "pieds", 0, 0, 0, 1, 0, 0, 0));
        map.put(218, new Equipement("Chaussures légères", "De petites bottines en cuir très légères et maniable \u001B[32m+1 Protection, +1 Dextérité\u001B[0ms", "pieds", 0, 0, 0, 1, 0, 1, 0));
        map.put(219, new Equipement("Bottes en cuir", "Des bottes en cuir un peu étanches \u001B[32m+2 Protection\u001B[0m", "pieds", 0, 0, 0, 2, 0, 0, 0));
        map.put(220, new Equipement("Bottes en fer", "De grosses bottes en fer bien renforcée, elles ont l'air solides \u001B[31m(Classe : Chevalier, Force min : 3)\u001B[0m \u001B[32m+3 Protection, +1 Force\u001B[0m", "pieds", 0, 0, 0, 3, 1, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(4) && j.getForce() > 4));
        map.put(221, new Equipement("Sandalles dures", "Elles ressemblent un peu à des tongs mais bon \u001B[31m(Classe : Barbare)\u001B[0m \u001B[32m+3 Protection, +2 Force\u001B[0m", "pieds", 0, 0, 0, 3, 2, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(1)));

        return map;
    }

    public static Map<Integer, Bibelot> genererBibelots() {
        Map<Integer, Bibelot> map = new HashMap<>();

        map.put(300, new Bibelot("Couronne du vainqueur", "Une belle couronne qui prouve que vous avez fini le jeu"));
        map.put(301, new Bibelot("Feuille", "Une feuille d'arbre, que fait-elle dans un donjon ?"));
        map.put(302, new Bibelot("Caillou", "Rien d'extraordinaire dans ce caillou"));
        map.put(303, new Bibelot("Clou", "Tiens pourquoi il y a clou, ceci dit ça ne sera sûrement pas utile"));
        map.put(304, new Bibelot("Rubis", "Oh un rubis, ça me rappelle la monnaie d'un autre pays..."));
        map.put(305, new Bibelot("Bout de tissu", "Il servira a essuyer vos larmes à la fin du jeu"));
        map.put(306, new Bibelot("Pièce étrange", "Il y a écrit \"Mora\" dessus que veut dire ce mot ?"));

        return map;
    }

    public static Map<Integer, Ennemi> genererPetitsEnnemis() {
        Map<Integer, Ennemi> map = new HashMap<>();

        //Ennemis faibles
        map.put(1, new Ennemi("Gobelin", 1, 1, 1, 1, 1, 1));
        map.put(2, new Ennemi("Squelette", 2, 2, 2, 1, 1, 1));
        map.put(3, new Ennemi("Fantôme", 1, 1, 1, 2, 99, 2));
        map.put(4, new Ennemi("Zombie", 2, 3, 1, 1, 1, 1));
        map.put(5, new Ennemi("Loup", 3, 2, 1, 1, 1, 1));
        map.put(6, new Ennemi("Archer", 2, 1, 4, 1, 1, 1));

        return map;
    }

    public static Map<Integer, Ennemi> genererGrosEnnemis() {
        Map<Integer, Ennemi> map = new HashMap<>();

        //Ennemis moyens
        map.put(11, new Ennemi("Sorcière", 1, 1, 1, 3, 99, 2));
        map.put(12, new Ennemi("Soldat Zombie", 3, 4, 1, 1, 1, 1));
        map.put(13, new Ennemi("Loup Garou", 4, 3, 1, 1, 1, 1));
        map.put(14, new Ennemi("Mage Noir", 1, 2, 1, 3, 99, 2));
        map.put(15, new Ennemi("Arbaliétrier", 3, 1, 5, 1, 1, 1));

        return map;
    }

    public static Map<Integer, Ennemi> genererBoss() {
        Map<Integer, Ennemi> map = new HashMap<>();

        //Ennemis forts
        map.put(21, new Ennemi("Dragon", 1, 3, 1, 5, 99, 2));
        map.put(22, new Ennemi("Cerbère", 5, 5, 5, 1, 1, 1));

        return map;
    }
}