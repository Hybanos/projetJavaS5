package Vue;

import Controleur.Controleur;
import Modele.Donjon.Salle;
import Modele.Personnage.Joueur;
import Modele.Personnage.Personnage;

import java.util.AbstractMap;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Ihm {

    private final Controleur c = Controleur.getInstance();

    public Ihm() {
    }


    // Demander

    /**
     * Demande au joueur de choisir un thème
     *
     * @return le thème choisi
     */
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

    /**
     * Demande au joueur de choisir une classe parmis celles médiéval fantastique
     *
     * @return la classe choisie
     */
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

    /**
     * Demande au joueur de chosiir une classe parmis celles science fiction
     *
     * @return la classe choisie
     */
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

    /**
     * Permet de demander une validation sur un choix
     *
     * @param texte un texte pour personnaliser la demande
     * @return true si le choix est validé, false sinon
     */
    public boolean demanderValidation(String texte) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Vous avez choisi " + texte + ". Validez-vous votre choix ?");

            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("o".equalsIgnoreCase(rep) || "oui".equalsIgnoreCase(rep) || "y".equalsIgnoreCase(rep) || "yes".equalsIgnoreCase(rep) || "ok".equalsIgnoreCase(rep)) {
                    return true;
                }
                if ("n".equalsIgnoreCase(rep) || "non".equalsIgnoreCase(rep) || "no".equalsIgnoreCase(rep)) {
                    return false;
                }
            }
        }
    }

    /**
     * Permet une intterraction avec le menu du jeu
     *
     * @return un entier correspondant au choix fait
     */
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

    /**
     * Permet une interraction avec l'inventaire d'un joueur
     *
     * @param j le joueur concerné
     * @return un entier correspondant à l'action faite
     */
    public int interractionInventaireJoueur(Joueur j) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            afficherEssentiel(j);
            afficherInventaireJoueur(j);
            System.out.println("\n[S] Ouvrir le panneau des statistiques\n[E] <nombre> Interaction avec l'objet indiqué\n[Q] Quitter");
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("q".equalsIgnoreCase(rep) || "quitter".equalsIgnoreCase(rep)) {
                    return 98;
                }
                if ("s".equalsIgnoreCase(rep) || "stats".equalsIgnoreCase(rep) || "statistiques".equalsIgnoreCase(rep)) {
                    return 99;
                }
                int index = patternsItems(rep);
                if (index != -1) {
                    return index;
                }
            }
        }
    }

    /**
     * Permet une interraction avec l'inventaire de la salle
     *
     * @param j le joueur interragissant
     * @param s la salle concernée
     * @return l'entier correcpondant l'action faite
     */
    public int interractionInventaireSalle(Joueur j, Salle s) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            afficherEssentiel(j);
            afficherInventaireSalle(s);
            System.out.println("\n[E] <nombre> Récupérer l'objet indiqué\n[Q] Quitter");
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("q".equalsIgnoreCase(rep) || "quitter".equalsIgnoreCase(rep)) {
                    return 98;
                }
                int index = patternsItems(rep);
                if (index != -1) {
                    return index;
                }
            }
        }
    }

    /**
     * Une méthode utile pour éviter la duplication de code
     *
     * @param rep la réponse à traiter
     * @return une chiffre de 0 à 19 pour l'item dans l'inventaire
     */
    public int patternsItems(String rep) {
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
        return -1;
    }

    /**
     * Permet d'interragir avec une salle
     *
     * @param j le joueur interragissant
     * @param s la salle concernée
     * @return un entier correcpondant à l'interraction
     */
    public int interractionSalle(Joueur j, Salle s, int option) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            afficherEssentiel(j);
            afficherSalle(s);
            String message = "\n[E] Accéder à l'inventaire du joueur\n[R] Voir les objets dans la pièce";
            if (option == 1) {
                message = "\n[A] Attaquer le monstre indiqué avec son arme\n[S] Attaquer le monstre indiqué avec un sort" + message;
            }
            if (option == 2) {
                message = "\n[N] Accéder à la pièce suivante" + message;
            }
            System.out.println(message);
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("e".equalsIgnoreCase(rep)) {
                    return 99;
                }
                if ("r".equalsIgnoreCase(rep)) {
                    return 98;
                }
                if ("n".equalsIgnoreCase(rep) && option == 2) {
                    return 97;
                }
                if (option == 1) {
                    Pattern pattern1 = Pattern.compile("^[Aa][0-9]$");
                    Pattern pattern2 = Pattern.compile("^[Aa] [0-9]$");
                    Pattern pattern3 = Pattern.compile("^[Ss][0-9]$");
                    Pattern pattern4 = Pattern.compile("^[Ss] [0-9]$");

                    boolean compa1 = pattern1.matcher(rep).find();
                    boolean compa2 = pattern2.matcher(rep).find();
                    boolean compa3 = pattern3.matcher(rep).find();
                    boolean compa4 = pattern4.matcher(rep).find();

                    if (compa1) {
                        return Integer.parseInt(rep.substring(1));
                    }
                    if (compa2) {
                        return Integer.parseInt(rep.substring(2));
                    }
                    if (compa3) {
                        return Integer.parseInt(rep.substring(1)) + 10;
                    }
                    if (compa4) {
                        return Integer.parseInt(rep.substring(2)) + 10;
                    }
                }
            }
        }
    }

    public int interractionMort(int retours) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Vous êtes morts...\n\n[1] Menu principal\n[2] Revenir dans la salle précédente (Retours possibles : " + retours + ")");
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("1".equalsIgnoreCase(rep) || "2".equalsIgnoreCase(rep)) {
                    int ch = Integer.parseInt(rep);
                    return ch;
                }
            }
        }
    }

    /**
     * Permet une interraction avec les statistiques du joueur
     *
     * @param j le joueur concerné
     * @return un couple <ValeurD'Ajout, IndiceStatistique> pour savoir combien à quelle statistique ajouter les points
     */
    public AbstractMap.SimpleEntry<Integer, Integer> interractionStatistiques(Joueur j) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            afficherStatistiques(j);
            System.out.println("[A] <stat> <nombre> Ajouter des points\n(Exemple : -> A 1 5 ajoute 5 points à la Force.)\n1 -> Force\n2 -> Constitution\n3 -> Dextérité\n4 -> Intelligence\n5 -> Capacité Magique\n[Q] Quitter");
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
                    return new AbstractMap.SimpleEntry<>(Integer.parseInt(rep.substring(2, 3)), Integer.parseInt(rep.substring(4)));
                }
            }
        }
    }

    /**
     * Permet une interraction avec un item en particulier (jeter, equiper, utiliser, etc..)
     *
     * @param j le joueur qui fait l'interraction
     * @param i l'index de l'item concerné par l'interraction
     * @return un entier correcpondant à l'action choisie
     */
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

    /**
     * Permet d'afficher un joueur complet
     *
     * @param j le joueur à afficher
     */
    public void afficherJoueur(Joueur j) {
        afficherEssentiel(j);
        afficherStatistiques(j);
        afficherInventaireJoueur(j);
    }

    /**
     * Permet d'afficher uniquement l'essentiel (nom, vie et mana) d'un joueur
     *
     * @param j le joueur concerné
     */
    public void afficherEssentiel(Joueur j) {
        System.out.println(j.getNom() +
                "\n\nVie : " + j.getVie() + "/" + j.getMAX_VIE() + "\n" +
                "Mana : " + j.getMana() + "/" + j.getMAX_MANA() + "\n");
    }

    /**
     * Permet d'afficher les statistiques du joueur
     *
     * @param j le joueur concerné
     */
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

    /**
     * Permet d'afficher l'inventaire d'un joueur
     *
     * @param j le joueur concerné
     */
    public void afficherInventaireJoueur(Joueur j) {
        System.out.println("Équipement :\n" +
                "- Arme : " + j.getInventaire().getEquipement("arme") + "\n" +
                "- Tête : " + j.getInventaire().getEquipement("tete") + "\n" +
                "- Torse : " + j.getInventaire().getEquipement("torse") + "\n" +
                "- Jambes : " + j.getInventaire().getEquipement("jambes") + "\n" +
                "- Pieds : " + j.getInventaire().getEquipement("pieds") + "\n" +
                "\nInventaire : " + j.getInventaire().getNbItems() + "/" + j.getInventaire().getTailleMax() + "\n" +
                j.getInventaire());
    }

    /**
     * Permet d'afficher l'inventaire d'un salle
     *
     * @param s la salle concernée
     */
    public void afficherInventaireSalle(Salle s) {
        System.out.println("Objets au sol :\n" +
                s.getLesItems());
    }

    /**
     * Permet d'afficher une salle
     */
    public void afficherSalle(Salle s) {
        System.out.println(s.affichertLesEnnemis());
    }

    /**
     * Une petite méthode supplémentaire juste pour s'ammuser à écrire un mots en très gros
     */
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
