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
                    \u001B[36mVeuillez choisir le thème de la partie :\u001B[0m
                                        
                    \u001B[34m[1]\u001B[0m Médiéval Fantastique - Plongez dans un monde féérique avec sa magie et ses différents monstres imaginaires !
                    \u001B[34m[2]\u001B[0m Science Fiction - Battez-vous pour prendre le contrôle du vaisseau spatial, mais ça ne sera pas de tout repos !
                                        
                    \u001B[31m[Q] Quitter\u001B[0m
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
            System.out.println("\u001B[36mVeuillez saisir le nom du joueur :\n\u001B[0m");

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
                    \u001B[36mVeuillez choisir votre classe :\u001B[0m
                                        
                    \u001B[34m[1]\u001B[0m Barbare : Force ++ / Constitution +++ / Dextérité - / Intelligence -- / Mana -
                    \u001B[34m[2]\u001B[0m Mage : Force - / Constitution -- / Dextérité - / Intelligence ++ / Mana +++
                    \u001B[34m[3]\u001B[0m Archer : Force - / Constitution - / Dextérité ++ / Intelligence + / Mana +
                    \u001B[34m[4]\u001B[0m Chevalier : Force + / Constitution ++ / Dextérité + / Intelligence - / Mana -
                    \u001B[34m[5]\u001B[0m Assassin : Force + / Constitution + / Dextérité ++ / Intelligence - / Mana --
                                        
                    \u001B[31m[Q] Quitter\u001B[0m
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
                    \u001B[36mVeuillez choisir votre classe :\u001B[0m
                                        
                    \u001B[34m[1]\u001B[0m Robot : Force - / Constitution - / Dextérité ++ / Pouvoir + / Énergie +
                    \u001B[34m[2]\u001B[0m Alien : Force - / Constitution -- / Dextérité - / Pouvoir +++ / Énergie ++
                    \u001B[34m[3]\u001B[0m Sportif : Force +++ / Constitution ++ / Dextérité - / Pouvoir -- / Énergie -
                    \u001B[34m[4]\u001B[0m Pirate Spatial : Force + / Constitution ++ / Dextérité + / Pouvoir - / Énergie -
                                        
                    \u001B[31m[Q] Quitter\u001B[0m
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
            System.out.println("\u001B[36mVous avez choisi \u001B[31m" + texte + "\u001B[36m. Validez-vous votre choix ?\n\u001B[0m");

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
                    "\u001B[34m[A]\u001B[0m Accéder à l'inventaire\n" +
                    "\u001B[34m[B]\u001B[0m Entrer dans le " + mot + ".\n\n" +
                    "\u001B[31m[Q] Quitter\n\u001B[0m");
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
            String mot = "\u001B[34m[S]\u001B[0m Ouvrir le panneau des statistiques\n\n\u001B[31m[Q] Quitter\n\u001B[0m";
            if (j.getInventaire().getNbItems() != 0) {
                mot = "\u001B[34m[<nombre>]\u001B[0m Interaction avec l'objet indiqué\n" + mot;
            }
            System.out.println(mot);
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
            String mot = "\u001B[31m[Q] Quitter\n\u001B[0m";
            if (s.getLesItems().getNbItems() != 0) {
                mot = "\u001B[34m[<nombre>]\u001B[0m Récupérer l'objet indiqué\n\n" + mot;
            }
            System.out.println(mot);
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("q".equalsIgnoreCase(rep) || "quitter".equalsIgnoreCase(rep)) {
                    return 98;
                }
                if (s.getLesItems().getNbItems() != 0) {
                    int index = patternsItems(rep);
                    if (index != -1) {
                        return index;
                    }
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
        Pattern pattern1 = Pattern.compile("^[0-9]$");
        Pattern pattern2 = Pattern.compile("^[0-2][0-9]$");

        boolean compa1 = pattern1.matcher(rep).find();
        boolean compa2 = pattern2.matcher(rep).find();

        if (compa1 || compa2) {
            return Integer.parseInt(rep);
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
            String message = "\n\u001B[34m[E]\u001B[0m Accéder à l'inventaire du joueur\n\u001B[34m[R]\u001B[0m Voir les objets dans la pièce\n";
            if (option == 1) {
                message = "\u001B[34m[A] <nombre>\u001B[0m Attaquer le monstre indiqué avec son arme\n\u001B[34m[S] <nombre>\u001B[0m Attaquer le monstre indiqué avec une capacité" + message;
            }
            if (option == 2) {
                message = "\u001B[34m[N]\u001B[0m Accéder à la pièce suivante" + message;
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

    /**
     * Permet de faire un choix lors de la mort
     *
     * @param retours nombre de retours disponibles
     * @return le choix répondu
     */
    public int interractionMort(int retours) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Vous êtes morts...\n\n\u001B[34m[1]\u001B[0m Menu principal\n\u001B[34m[2]\u001B[0m Revenir dans la salle précédente \u001B[31m(Retours possibles : " + retours + ")\n\u001B[0m");
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
            String mot1 = "";
            String mot2 = "";
            switch (c.getTheme().getNom()) {
                case "mf":
                    mot1 = "Intelligence";
                    mot2 = "Capacité Magique";
                    break;
                case "sf":
                    mot1 = "Pouvoir";
                    mot2 = "Énergie";
                    break;
            }
            afficherStatistiques(j, mot1, mot2);
            System.out.println("\u001B[34m[E] <stat> <nombre>\u001B[0m Ajouter des points\n(Exemple : -> E 1 5 ajoute 5 points à la Force.)\n1 -> Force\n2 -> Constitution\n3 -> Dextérité\n4 -> " + mot1 + "\n5 -> " + mot2 + "\n\u001B[31m[Q] Retour\n\u001B[0m");
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("q".equalsIgnoreCase(rep) || "quitter".equalsIgnoreCase(rep)) {
                    return null;
                }
                Pattern pattern1 = Pattern.compile("^[Ee] [1-5] [0-9]$");
                Pattern pattern2 = Pattern.compile("^[Ee] [1-5] [0-9][0-9]$");

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
            System.out.println(j.getInventaire().getItem(i) + "\n\n\u001B[34m[J]\u001B[0m Jeter l'Objet");
            if (j.getInventaire().getItem(i).getType() == 2) {
                System.out.println("\u001B[34m[E]\u001B[0m Utiliser l'Objet");
            }
            if (j.getInventaire().getItem(i).getType() == 3) {
                System.out.println("\u001B[34m[E]\u001B[0m Équiper l'Objet");
            }
            System.out.println("\u001B[31m[Q] Annuler\n\u001B[0m");
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
     * Permet d'afficher uniquement l'essentiel (nom, vie et mana) d'un joueur
     *
     * @param j le joueur concerné
     */
    public void afficherEssentiel(Joueur j) {
        System.out.println("\u001B[33m" + j.getNom() +
                "\n\u001B[36mVie\u001B[0m : " + j.getVie() + "/" + j.getMAX_VIE() + "\n" +
                "\u001B[36mMana\u001B[0m : " + j.getMana() + "/" + j.getMAX_MANA() + "\n");
    }

    /**
     * Permet d'afficher les statistiques du joueur
     *
     * @param j le joueur concerné
     */
    public void afficherStatistiques(Joueur j, String mot1, String mot2) {
        System.out.println("\u001B[33mStatistiques\u001B[0m :\n" +
                "- \u001B[36mForce\u001B[0m : " + j.getForce() + "\n" +
                "- \u001B[36mConstitution\u001B[0m : " + j.getConstitution() + "\n" +
                "- \u001B[36mDextérité\u001B[0m : " + j.getDexterite() + "\n" +
                "- \u001B[36m" + mot1 + "\u001B[0m : " + j.getIntelligence() + "\n" +
                "- \u001B[36m" + mot2 + "\u001B[0m : " + j.getCapacite() + "\n" +
                "- \u001B[35mPoints Disponibles\u001B[0m : " + j.getPts_dispo() + "\n" +
                "- \u001B[35mProbabilité de toucher\u001B[0m : " + (int) (((((double) j.getDexterite() / 10) + j.getInventaire().getEquipement("arme").getPrecision()) / 2) * 100) + "%\n");
    }

    /**
     * Permet d'afficher l'inventaire d'un joueur
     *
     * @param j le joueur concerné
     */
    public void afficherInventaireJoueur(Joueur j) {
        System.out.println("\u001B[33mÉquipement\u001B[0m :\n" +
                "- \u001B[36mArme\u001B[0m : " + j.getInventaire().getEquipement("arme") + "\n" +
                "- \u001B[36mTête\u001B[0m : " + j.getInventaire().getEquipement("tete") + "\n" +
                "- \u001B[36mTorse\u001B[0m : " + j.getInventaire().getEquipement("torse") + "\n" +
                "- \u001B[36mJambes\u001B[0m : " + j.getInventaire().getEquipement("jambes") + "\n" +
                "- \u001B[36mPieds\u001B[0m : " + j.getInventaire().getEquipement("pieds") + "\n" +
                "\n\u001B[33mInventaire\u001B[0m : " + j.getInventaire().getNbItems() + "/" + j.getInventaire().getTailleMax() + "\n\n" +
                j.getInventaire());
    }

    /**
     * Permet d'afficher l'inventaire d'un salle
     *
     * @param s la salle concernée
     */
    public void afficherInventaireSalle(Salle s) {
        System.out.println("\u001B[33mObjets au sol\u001B[0m :\n" +
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
