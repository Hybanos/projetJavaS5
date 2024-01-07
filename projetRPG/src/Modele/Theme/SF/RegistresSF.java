package Modele.Theme.SF;

import Controleur.Controleur;
import Modele.Item.Bibelot;
import Modele.Item.Consommable;
import Modele.Item.Equipement;
import Modele.Personnage.ClassePersonnage;
import Modele.Personnage.Ennemi;

import java.util.HashMap;
import java.util.Map;

public class RegistresSF {

    private static Controleur c = Controleur.getInstance();

    public static Map<Integer, ClassePersonnage> genererClasses() {
        Map<Integer, ClassePersonnage> map = new HashMap<>();

        map.put(1, new ClassePersonnage("Sportif"));
        map.put(2, new ClassePersonnage("Alien"));
        map.put(3, new ClassePersonnage("Robot"));
        map.put(4, new ClassePersonnage("Pirate Spatial"));

        return map;
    }

    public static Map<Integer, Consommable> genererConsomable() {
        Map<Integer, Consommable> map = new HashMap<>();

        map.put(1, new Consommable("Conserve de légumes", "Une boîte de conserve encore bonne à manger", 2, 0));
        map.put(2, new Consommable("Poulet au curry lyophilisé", "Il suffit de rajouter de l'eau chaude !", 3, 0));
        map.put(3, new Consommable("Salade de patates lyophilisée", "Ca n'a jamais été bon", 2, 0));
        map.put(4, new Consommable("Steak cryogénisé", "Un steak synthétique qui se conserve indéfiniment", 2, 0));
        map.put(5, new Consommable("Morceau de pain", "La recette n'a pas changé depuis des siècles", 1, 0));
        map.put(6, new Consommable("Trousse de premier secours", "Ne sauvera la vie de personne, mais est toujours très utile", 5, 0));
        map.put(7, new Consommable("Trousse de soin complète", "Il y a tout ce qu'il faut pour soigner même des plus gros bobos", 1000, 0)); // -1 == potion qui baisse la vie ?
        map.put(8, new Consommable("Panachée stylée", "Permet de récupérer un peu d'énergie", 0, 1));
        map.put(9, new Consommable("Mauvais whisky", "Il sent très fort mais est quand meme buvable", 2, 2));
        map.put(10, new Consommable("Vieux vin", "Un vieux vin bonifié avec l'age", 2, 5));

        return map;
    }

    public static Map<Integer, Equipement> genererArmes() {
        Map<Integer, Equipement> map = new HashMap<>();

        //Armes
        map.put(100, new Equipement("Main", "Une main", "partout", 0, 0, 0, 0, 0, 0, 0));
        map.put(101, new Equipement("Tuyau en métal", "Un morceau de tuyauterie trouvé par terre", "arme", 1, 0, 0.5, 0, 0, 0, 0));
        map.put(102, new Equipement("Sabre laser de l'espace", "Ca rappelle des souvenirs...", "arme", 2, 0, 0.6, 0, 0, 0, 0));
        map.put(103, new Equipement("Pied de biche", "Pour tâper les méchants aliens", "arme", 3, 0, 0.6, 0, 0, 0, 0, (j) -> j.getForce() > 2));
        map.put(104, new Equipement("Épée electrique", "Une épée aussi efficace pour trancher que pour éléctrocuter vos ennemis", "arme", 5, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(1) && j.getForce() > 4));
        map.put(105, new Equipement("Harpon pneumatique", "Un gros harpon qui tape fort", "arme", 3, 0, 0.6, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(4) && j.getForce() > 2));
        map.put(106, new Equipement("Trident en aluminium", "Maniable et léger, c'est vraiment une super arme !", "arme", 5, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(4) && j.getForce() > 4));
        map.put(107, new Equipement("Pistolet laser", "Un petit pistolet qui tire des lasers", "arme", 2, 0, 0.5, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(2)));
        map.put(108, new Equipement("Fusil LaserTech©", "Un puissant laser sort du canon en continu", "arme", 4, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(2) && j.getMana() > 2));
        map.put(109, new Equipement("Canon de gauss", "Emmet de puissantes décharges d'énergie", "arme", 5, 0.07, 0.8, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(2) && j.getMana() > 4));
        map.put(110, new Equipement("Revolver rouillé", "Un simple revolver, il est tout rouillé", "arme", 2, 0, 0.6, 0, 0, 0, 0));
        map.put(111, new Equipement("Revolver", "Un simple revolver, il est en bonne condition", "arme", 2, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(3) || j.getClasse() == c.getTheme().getLesClasses().get(4)));
        map.put(112, new Equipement("Fusil automatique", "Un fusil classique, il est très utilisé par les chasseurs de prime", "arme", 4, 0.07, 0.5, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(3)));
        map.put(113, new Equipement("Haltère", "Un gros haltère, solide mais un peu lourd", "arme", 7, 0.07, 0.5, 0, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(4) && j.getForce() > 6));
        map.put(114, new Equipement("Vielle tôle", "Un morceau de métail découpé, rien de plus", "arme", 1, 0, 0.6, 2, 0, 0, 0));
        map.put(115, new Equipement("Plaque en carbonne", "Un plaque en carbonne très résitante", "arme", 2, 0, 0.6, 4, 0, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(1) && j.getForce() > 2));


        return map;
    }


    public static Map<Integer, Equipement> genererArmures() {
        Map<Integer, Equipement> map = new HashMap<>();

        //Armures
        map.put(200, new Equipement("Nu", "Tout nu", "partout", 0, 0, 0, 0, 0, 0, 0));
        map.put(201, new Equipement("Casquette de marque", "Mais qui a bien pu laisser sa casquette ici ?", "tete", 0, 0, 0, 2, 0, 0, 0));
        map.put(202, new Equipement("Vieux casque d'astronaute", "Un vieux casque qui servait a aller dans l'espace", "tete", 0, 0, 0, 3, 0, 0, 0));
        map.put(203, new Equipement("Casque d'Iron man", "Un casque qui offre une protection hors du commun", "tete", 0, 0, 0, 4, 1, 0, 0, (j) -> j.getDexterite() > 4));
        map.put(204, new Equipement("Bandeau de chasseur", "Un bandana qui tient la tête et augmente votre intelligence", "tete", 0, 0, 0, 2, 0, 0, 1, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(2)));
        map.put(205, new Equipement("Lunettes de vision nocture", "Ces lunettes permettent de voir dans le noir de l'espace profond !", "tete", 0, 0, 0, 2, 0, 1, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(3)));
        map.put(206, new Equipement("Tricorne de Pirate", "Un tricorne noir qui donne un air de grand pirate !", "tete", 0, 0, 0, 2, 1, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(4)));
        map.put(207, new Equipement("Blouson en cuir", "Un simple blouson en cuir", "torse", 0, 0, 0, 2, 0, 0, 0));
        map.put(208, new Equipement("Combinaison spatiale", "Une ancienne combinaison toujours fonctionelle", "torse", 0, 0, 0, 3, 1, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(4) && j.getForce() > 2));
        map.put(209, new Equipement("Plastron renforcé en carbonne", "Un plastron qui semble indestructible", "torse", 0, 0, 0, 5, 1, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(1) && j.getForce() > 4));
        map.put(210, new Equipement("Cape indéchirable", "Il paraît que cette cape a appartenu a quelqu'un d'important", "torse", 0, 0, 0, 2, 0, 0, 1, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(2)));
        map.put(211, new Equipement("Combinaison de camouflage", "Vous sembles presque invisible dans le paysage", "torse", 0, 0, 0, 2, 0, 1, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(3)));
        map.put(212, new Equipement("Sweatshirt Rouge", "Un simple sweatshirt qui ne protège pas grand chose", "torse", 0, 0, 0, 1, 0, 0, 0));
        map.put(213, new Equipement("Jean troué", "Un jean, il est neuf mais troué", "jambes", 0, 0, 0, 2, 0, 0, 0));
        map.put(214, new Equipement("Pantalon de soldat", "Un pantalon résistant", "jambes", 0, 0, 0, 3, 1, 0, 0, (j) -> j.getForce() > 2));
        map.put(215, new Equipement("Pantalon à plaques", "Des plaques de carbonne renforcent ce pantalon très solide", "jambes", 0, 0, 0, 4, 1, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(1) && j.getForce() > 4));
        map.put(216, new Equipement("Bottes de pirate", "On pourrait presque en jouer des claquettes avec leurs semelles dures", "pieds", 0, 0, 0, 3, 0, 1, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(4)));
        map.put(217, new Equipement("Chaussures qui courent vite", "Ce sont de belles baskets flambant neuves", "pieds", 0, 0, 0, 1, 0, 1, 0));
        map.put(218, new Equipement("Nikes de ZINZIN", "TEMA LES CHAUSSURES", "pieds", 0, 0, 0, 2, 0, 0, 0));
        map.put(219, new Equipement("Chaussures de sécurité", "Des souliers qui protèges très bien vos pieds", "pieds", 0, 0, 0, 3, 1, 0, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(1)));
        map.put(220, new Equipement("Bottes de tireur", "Vous pouves vous déplacer en toute discrétion avec ces bottes", "pieds", 0, 0, 0, 3, 0, 2, 0, (j) -> j.getClasse() == c.getTheme().getLesClasses().get(3)));


        return map;
    }

    public static Map<Integer, Bibelot> genererBibelots() {
        Map<Integer, Bibelot> map = new HashMap<>();

        map.put(300, new Bibelot("Couronne du vainqueur", "Une belle couronne qui prouve que vous avez fini le jeu"));
        map.put(301, new Bibelot("Bras robotique", "Mais à qui appartient-il ?"));
        map.put(302, new Bibelot("Câble RJ45", "Au moins avec ça on aura Internet !"));
        map.put(303, new Bibelot("Fleur", "Oh un pissenlit !"));
        map.put(304, new Bibelot("Touche de clavier", "Pas très utilie lorsqu'elle est seule"));
        map.put(305, new Bibelot("Mini trou noir de poche", "Euh... c'est pas dangereux ?"));

        return map;
    }

    public static Map<Integer, Ennemi> genererPetitsEnnemis() {
        Map<Integer, Ennemi> map = new HashMap<>();

        //Ennemis faibles
        map.put(1, new Ennemi("Petit robot", 1, 1, 1, 1, 1, 1));
        map.put(2, new Ennemi("Pirate novice", 2, 2, 2, 1, 1, 1));
        map.put(3, new Ennemi("Petit blob alien", 1, 1, 1, 2, 99, 2));
        map.put(4, new Ennemi("Moustique spatial", 1, 1, 1, 2, 99, 2));

        return map;
    }

    public static Map<Integer, Ennemi> genererGrosEnnemis() {
        Map<Integer, Ennemi> map = new HashMap<>();

        //Ennemis moyens
        map.put(11, new Ennemi("Combatant robot", 1, 1, 1, 3, 99, 2));
        map.put(12, new Ennemi("Pirate de l'espace", 3, 4, 1, 1, 1, 1));
        map.put(13, new Ennemi("Faucheur alien", 4, 3, 1, 1, 1, 1));
        map.put(14, new Ennemi("Soldat corrompu", 1, 2, 1, 3, 99, 2));

        return map;
    }

    public static Map<Integer, Ennemi> genererBoss() {
        Map<Integer, Ennemi> map = new HashMap<>();

        //Ennemis forts
        map.put(21, new Ennemi("TigreGPT", 1, 3, 1, 5, 99, 2));
        map.put(22, new Ennemi("Seigneur alien", 5, 5, 5, 1, 1, 1));

        return map;
    }
}
