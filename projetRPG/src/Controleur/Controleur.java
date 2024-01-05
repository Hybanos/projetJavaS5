package Controleur;

import Modele.Item.Equipement;
import Modele.Item.Item;
import Modele.Personnage.ClassePersonnage;
import Modele.Personnage.Inventaire;
import Modele.Personnage.Joueur;
import Modele.Theme.MF.MedievalFantastique;
import Modele.Theme.MF.RegistresMF;
import Modele.Theme.SF.ScienceFiction;
import Modele.Theme.Theme;
import Vue.Ihm;

import java.util.AbstractMap;
import java.util.HashMap;

public class Controleur {
    //À voir si on ne fait pas un contrôleur par thème
    //Apparemment pas clair
    //En vrai peut-être quand même

    private static Controleur instance;
    private Theme theme;
    private Ihm ihm;

    public static Controleur getInstance() {
        if (instance == null)
            instance = new Controleur();
        return instance;
    }

    public Controleur() {
        instance = this;
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    /**
     * Contrôleur principal, permet de gérer le jeu
     */
    public void lancerPartie() {
        this.ihm = new Ihm();
        ihm.afficherDemarrage();
        Joueur joueur = initJoueur();
        if (joueur == null) {
            System.exit(0);
        }
        System.out.println("Fin de la création du personnage, redirection vers le menu principal ...");
        while (true) {
            int choix = ihm.interractionMenu();
            if (choix == 0) {
                System.exit(0);
            }
            if (choix == 1) {
                gererInventaireJoueur(joueur);
            }
            if (choix == 2) {
                // Lancer le dongeon
            }
        }
    }

    /**
     * Initialise le joueur et le thème
     *
     * @return un joueur qui sera celui jouable
     */
    public Joueur initJoueur() {
        while (true) {
            String theme = ihm.choixTheme();
            if ("q".equalsIgnoreCase(theme)) {
                return null;
            }
            if (ihm.demanderValidation(theme)) {
                if ("médiéval fantastique".equalsIgnoreCase(theme)) {
                    this.theme = new MedievalFantastique();
                    return persoMF();
                }
                if ("science fiction".equalsIgnoreCase(theme)) {
                    this.theme = new ScienceFiction();
                    return persoSF();
                }
            }
        }
    }

    /**
     * Permet de créer un joueur avec son nom et sa classe en fonction du thème
     *
     * @return un joueur
     */
    public Joueur persoMF() {
        while (true) {
            String nom = ihm.choixNomJoueur();
            if (ihm.demanderValidation(nom)) {
                while (true) {
                    String classe = ihm.choixClasseMF();
                    if ("q".equalsIgnoreCase(classe)) {
                        return null;
                    }
                    if (ihm.demanderValidation(classe)) {
                        if ("barbare".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, theme.getLesClasses().get(1), new Inventaire(), 4, 5, 2, 1, 2);
                        }
                        if ("mage".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, theme.getLesClasses().get(2), new Inventaire(), 2, 1, 2, 4, 5);
                        }
                        if ("archer".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, theme.getLesClasses().get(3), new Inventaire(), 2, 2, 4, 3, 3);
                        }
                        if ("chevalier".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, theme.getLesClasses().get(4), new Inventaire(), 3, 4, 3, 2, 2);
                        }
                        if ("assassin".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, theme.getLesClasses().get(5), new Inventaire(), 3, 3, 4, 2, 2);
                        }
                    }
                }
            }
        }
    }

    public Joueur persoSF() {
        return null;
    }

    /**
     * Permet une gestion de l'inventaire, que ce soit en menu ou en donjon
     *
     * @param j le joueur concerné
     */
    public void gererInventaireJoueur(Joueur j) {
        while (true) {
            int choix = ihm.interractionInventaire(j);
            if (choix == 98) {
                break;
            }
            if (choix == 99) {
                while (true) {
                    AbstractMap.SimpleEntry<Integer, Integer> addStat = ihm.interractionStatistiques(j);
                    if (addStat == null) {
                        break;
                    } else {
                        if (j.utiliserPoints(addStat.getKey(), addStat.getValue())) {
                            System.out.println("Points ajoutés");
                        } else {
                            System.out.println("Vous n'avez pas assez de points");
                        }
                    }
                }
            }
            if (choix <= 19) {
                while (true) {
                    int action = ihm.interractionItem(j, choix);
                    if (action == 0) {
                        break;
                    }
                    if (action == 1) {
                        //Si un joueur est hors du donjon faire :
                        j.jeterItem(choix);
                        break;
                        //Si un joueur est dans un donjon faire :
                        //Donjon.getSalleActuelle.ajouterItem(j.jeterItem(choix);
                        //break;
                    }
                    if (action == 2) {
                        j.utiliser(choix);
                        break;
                    }
                    if (action == 3) {
                        Equipement aEquiper = (Equipement) j.getInventaire().getItem(choix); //Equipement à équiper dans l'inventaire
                        Equipement dejaEquipe = j.desequiper(aEquiper.getEmplacement()); //Equipement deja équipé
                        if (j.equiper(aEquiper)) {
                            j.getInventaire().supprItem(choix);
                            if (dejaEquipe != null) {
                                j.getInventaire().ajouterItem(dejaEquipe);
                            }
                        } else {
                            if (dejaEquipe != null) {
                                j.equiper(dejaEquipe);
                            }
                        }
                        break;
                    }
                }
            }
        }
    }
}
