package Vue;

import Controleur.Controleur;
import Modele.Donjon.Salle;
import Modele.Item.Item;
import Modele.Personnage.Joueur;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ihm {

    private final Controleur c = Controleur.getInstance();

    public Ihm() {
    }


    // Demander

    public String choixTheme() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Veuillez choisir le thème de la partie :
                                        
                    [1] Médiéval Fantastique - Plongez dans un monde féérique avec sa magie et ses différents monstres imaginaires !
                    [2] Science Fiction - Battez-vous pour prendre le contrôle du vaisseau spatial, mais ça ne sera pas de tout repos !
                                        
                    [Q] Quitter
                    """);
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("1".equalsIgnoreCase(rep) || "mf".equalsIgnoreCase(rep) || "medieval".equalsIgnoreCase(rep) || "medieval fantastique".equalsIgnoreCase(rep) || "médiéval".equalsIgnoreCase(rep) || "médiéval fantastique".equalsIgnoreCase(rep)) {
                    return "Médiéval Fantastique";
                }
                if ("2".equalsIgnoreCase(rep) || "sf".equalsIgnoreCase(rep) || "science".equalsIgnoreCase(rep) || "science fiction".equalsIgnoreCase(rep)) {
                    return "Science Fiction";
                }
                if ("q".equalsIgnoreCase(rep) || "quitter".equalsIgnoreCase(rep)) {
                    return "q";
                }
            }
        }
    }

    /**
     * Demande à l'utilisateur via un objet de type scanner de saisir son nom.
     *
     * @return le nom du joueur.
     */
    public String choixNomJoueur() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Veuillez saisir le nom du joueur :");

            if (sc.hasNextLine()) {
                return sc.nextLine();
            }
        }
    }

    public String choixClasseMF() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Veuillez choisir votre classe :
                                        
                    [1] Barbare : Force ++ / Constitution +++ / Dextérité - / Intelligence -- / Mana -
                    [2] Mage : Force - / Constitution -- / Dextérité - / Intelligence ++ / Mana +++
                    [3] Archer : Force - / Constitution - / Dextérité ++ / Intelligence + / Mana +
                    [4] Chevalier : Force + / Constitution ++ / Dextérité + / Intelligence - / Mana -
                    [5] Assassin : Force + / Constitution + / Dextérité ++ / Intelligence - / Mana --
                                        
                    [Q] Quitter
                    """);
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("1".equalsIgnoreCase(rep) || "barbare".equalsIgnoreCase(rep)) {
                    return "Barbare";
                }
                if ("2".equalsIgnoreCase(rep) || "mage".equalsIgnoreCase(rep)) {
                    return "Mage";
                }
                if ("3".equalsIgnoreCase(rep) || "archer".equalsIgnoreCase(rep)) {
                    return "Archer";
                }
                if ("4".equalsIgnoreCase(rep) || "chevalier".equalsIgnoreCase(rep)) {
                    return "Chevalier";
                }
                if ("5".equalsIgnoreCase(rep) || "assassin".equalsIgnoreCase(rep)) {
                    return "Assassin";
                }
                if ("q".equalsIgnoreCase(rep) || "quitter".equalsIgnoreCase(rep)) {
                    return "q";
                }
            }
        }
    }

    public String choixClasseSF() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Veuillez choisir votre classe :
                                        
                    [1] Robot : Force - / Constitution - / Dextérité ++ / Pouvoir + / Énergie +
                    [2] Alien : Force - / Constitution -- / Dextérité - / Pouvoir +++ / Énergie ++
                    [3] Sportif : Force +++ / Constitution ++ / Dextérité - / Pouvoir -- / Énergie -
                    [4] Pirate spatial : Force + / Constitution ++ / Dextérité + / Pouvoir - / Énergie -
                                        
                    [Q] Quitter
                    """);
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("1".equalsIgnoreCase(rep) || "robot".equalsIgnoreCase(rep)) {
                    return "Robot";
                }
                if ("2".equalsIgnoreCase(rep) || "alien".equalsIgnoreCase(rep)) {
                    return "Alien";
                }
                if ("3".equalsIgnoreCase(rep) || "sportif".equalsIgnoreCase(rep)) {
                    return "Sportif";
                }
                if ("4".equalsIgnoreCase(rep) || "pirate".equalsIgnoreCase(rep) || "pirate spatial".equalsIgnoreCase(rep)) {
                    return "Pirate Spatial";
                }
                if ("q".equalsIgnoreCase(rep) || "quitter".equalsIgnoreCase(rep)) {
                    return "q";
                }
            }
        }
    }

    public boolean demanderValidation(String texte) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Vous avez choisi " + texte + ". Validez-vous votre choix ?");

            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("o".equalsIgnoreCase(rep) || "oui".equalsIgnoreCase(rep) || "y".equalsIgnoreCase(rep) || "yes".equalsIgnoreCase(rep)) {
                    return true;
                }
                if ("n".equalsIgnoreCase(rep) || "non".equalsIgnoreCase(rep) || "no".equalsIgnoreCase(rep)) {
                    return false;
                }
            }
        }
    }

    public int interractionMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String mot = "";
            if (c.getTheme().getNom().equals("mf"))
                mot = "donjon";
            if (c.getTheme().getNom().equals("sf"))
                mot = "vaisseau";
            System.out.println("Menu du jeu :\n\n" +
                    "[A] Accéder à l'inventaire\n" +
                    "[B] Entrer dans le " + mot + ".\n\n" +
                    "[Q] Quitter");
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("q".equalsIgnoreCase(rep) || "quitter".equalsIgnoreCase(rep)) {
                    return 0;
                }
                if ("a".equalsIgnoreCase(rep)) {
                    return 1;
                }
                if ("b".equalsIgnoreCase(rep)) {
                    return 2;
                }
            }
        }
    }

    public int interractionInventaire(Joueur j) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            afficherEssentiel(j);
            afficherInventaire(j);
            System.out.println("\n[Q] Quitter\n[S] Ouvrir le panneau des statistiques\n[E] <nombre> Interaction avec l'objet indiqué");
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("q".equalsIgnoreCase(rep) || "quitter".equalsIgnoreCase(rep)) {
                    return 98;
                }
                if ("s".equalsIgnoreCase(rep) || "stats".equalsIgnoreCase(rep) || "statistiques".equalsIgnoreCase(rep)) {
                    return 99;
                }
                Pattern pattern1 = Pattern.compile("^[E,e][0-9]$");
                Pattern pattern2 = Pattern.compile("^[E,e][0-1][0-9]$");
                Pattern pattern3 = Pattern.compile("^[E,e] [0-9]$");
                Pattern pattern4 = Pattern.compile("^[E,e] [0-1][0-9]$");

                boolean compa1 = pattern1.matcher(rep).find();
                boolean compa2 = pattern2.matcher(rep).find();
                boolean compa3 = pattern3.matcher(rep).find();
                boolean compa4 = pattern4.matcher(rep).find();

                if (compa1 || compa2) {
                    return Integer.parseInt(rep.substring(1));
                }
                if (compa3 || compa4) {
                    return Integer.parseInt(rep.substring(2));
                }
            }
        }
    }

    public AbstractMap.SimpleEntry<Integer, Integer> interractionStatistiques(Joueur j) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            afficherStatistiques(j);
            System.out.println("[Q] Quitter\n[A] <stat> <nombre> Ajouter des points\n(Exemple : -> A 1 5 ajoute 5 points à la Force.)\n1 -> Force\n2 -> Constitution\n3 -> Dextérité\n4 -> Intelligence\n5 -> Capacité Magique");
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("q".equalsIgnoreCase(rep) || "quitter".equalsIgnoreCase(rep)) {
                    return null;
                }
                Pattern pattern1 = Pattern.compile("^[Aa] [1-5] [0-9]$");
                Pattern pattern2 = Pattern.compile("^[Aa] [1-5] [0-9][0-9]$");

                boolean compa1 = pattern1.matcher(rep).find();
                boolean compa2 = pattern2.matcher(rep).find();

                if (compa1 || compa2) {
                    return new AbstractMap.SimpleEntry<Integer, Integer>(Integer.parseInt(rep.substring(2, 3)), Integer.parseInt(rep.substring(4)));
                }
            }
        }
    }

    public int interractionItem(Joueur j, int i) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println(j.getInventaire().getItem(i) + "\n\n[J] Jeter l'Objet");
            if (j.getInventaire().getItem(i).getType() == 2) {
                System.out.println("[E] Utiliser l'Objet");
            }
            if (j.getInventaire().getItem(i).getType() == 3) {
                System.out.println("[E] Équiper l'Objet");
            }
            System.out.println("[Q] Quitter\n");
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("q".equalsIgnoreCase(rep) || "quitter".equalsIgnoreCase(rep)) {
                    return 0;
                }
                if ("j".equalsIgnoreCase(rep)) {
                    return 1;
                }
                if ("e".equalsIgnoreCase(rep) && j.getInventaire().getItem(i).getType() != 1) {
                    return j.getInventaire().getItem(i).getType(); // Renvoie 2 si c'est un consommable, et 3 si c'est un équipement
                }
            }
        }
    }


    // Afficher

    public void afficherJoueur(Joueur j) {
        afficherEssentiel(j);
        afficherStatistiques(j);
        afficherInventaire(j);
    }

    public void afficherEssentiel(Joueur j) {
        System.out.println(j.getNom() +
                "\n\nVie : " + j.getVie() + "/" + j.getMAX_VIE() + "\n" +
                "Mana : " + j.getMana() + "/" + j.getMAX_MANA() + "\n");
    }

    public void afficherStatistiques(Joueur j) {
        System.out.println("Statistiques :\n" +
                "- Force : " + j.getForce() + "\n" +
                "- Constitution : " + j.getConstitution() + "\n" +
                "- Dextérité : " + j.getDexterite() + "\n" +
                "- Intelligence : " + j.getIntelligence() + "\n" +
                "- Capacité Magique : " + j.getCapacite() + "\n" +
                "- Points Disponibles : " + j.getPts_dispo() + "\n" +
                "- Probabilité de toucher : " + (int) (((((double) j.getDexterite() / 10) + j.getInventaire().getEquipement("arme").getPrecision()) / 2) * 100) + "%\n");
    }

    public void afficherInventaire(Joueur j) {
        System.out.println("Équipement :\n" +
                "- Arme : " + j.getInventaire().getEquipement("arme") + "\n" +
                "- Tête : " + j.getInventaire().getEquipement("tete") + "\n" +
                "- Torse : " + j.getInventaire().getEquipement("torse") + "\n" +
                "- Jambes : " + j.getInventaire().getEquipement("jambes") + "\n" +
                "- Pieds : " + j.getInventaire().getEquipement("pieds") + "\n" +
                "\nInventaire :\n" + j.getInventaire());
    }

    public void afficherInventaire(Salle s) {
        System.out.println(s.getLesItems());
    }

    public void afficherSalle() {

    }

    public void afficherDemarrage() {
        System.out.println("""
                ---------------------------------------------------------------------------------------
                |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|
                |+++#####++++++++#####++++++##+++##++++++++++##++++++#####++++++##+++##++++++######+++|
                |+++##++##++++++##+++##+++++###++##++++++++++##+++++##+++##+++++###++##+++++##++++++++|
                |+++##+++##+++++##+++##+++++####+##++++++++++##+++++##+++##+++++####+##++++++###++++++|
                |+++##+++##+++++##+++##+++++##+####++++++++++##+++++##+++##+++++##+####++++++++###++++|
                |+++##++##++++++##+++##+++++##++###+++++##+++##+++++##+++##+++++##++###++++++++++##+++|
                |+++#####++++++++#####++++++##+++##++++++#####+++++++#####++++++##+++##+++++######++++|
                |+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++|
                ---------------------------------------------------------------------------------------
                                        
                                        
                Bienvenue dans le RPG du semestre 5 !
                """);
    }
}
