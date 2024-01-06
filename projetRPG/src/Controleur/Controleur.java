package Controleur;

import Modele.Donjon.Donjon;
import Modele.Donjon.Salle;
import Modele.Item.Equipement;
import Modele.Personnage.Ennemi;
import Modele.Personnage.Inventaire;
import Modele.Personnage.Joueur;
import Modele.Personnage.Personnage;
import Modele.Theme.MF.MedievalFantastique;
import Modele.Theme.SF.ScienceFiction;
import Modele.Theme.Theme;
import Vue.Ihm;

import java.util.AbstractMap;

public class Controleur {
    //À voir si on ne fait pas un contrôleur par thème
    //Apparemment pas clair
    //En vrai peut-être quand même

    private static Controleur instance;
    private Theme theme = null;
    private Ihm ihm = null;
    private Donjon donjon = null;
    private Salle salle = null;
    private int vie = 2;

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
            switch (choix) {
                case 0:
                    System.exit(0);
                case 1:
                    gererInventaireJoueur(joueur);
                    break;
                case 2:
                    donjon = new Donjon();
                    joueur.setEnDonjon(true);
                    salle = donjon.getSalleActuelle();
                    controleurDonjon(joueur);
                    break;
            }
        }
    }

    /**
     * Permet une gestiuon lorsqu'un joueur est dans un donjon
     *
     * @param j le joueur concerné
     */
    public void controleurDonjon(Joueur j) {
        controleurSalle(j);
    }

    /**
     * Permet une gestion de la salle plus précisément
     *
     * @param j le joueur dans la salle
     */
    public void controleurSalle(Joueur j) {
        while (true) {
            for (int i = 0; i < salle.getLesEnnemis().size(); i++) {
                Ennemi ennemi = salle.getLesEnnemis().get(i);
                if (ennemi.estEnVie()) {
                    System.out.println("L'ennemi " + ennemi.getNom() + " vous a fait " + ennemi.attaquer(j) + " dégâts.");
                } else {
                    salle.getLesEnnemis().remove(i);
                }
            }
            if (salle.estVide()) {
                System.out.println("Bravo vous avez tué tous les ennemis dans cette salle !");
            }
            while (true) {
                int choix = ihm.interractionSalle(j, salle);
                if (choix == 98) {
                    break; // A voir quand tu quittes c'est complexe
                }
                if (choix == 99) {
                    gererInventaireJoueur(j);
                    break;
                }
                if (choix == 97) {
                    gererInventaireSalle(j, salle);
                    break;
                }
                if (choix < salle.getLesEnnemis().size()) {
                    System.out.println("L'ennemi " + salle.getLesEnnemis().get(choix) + " a raçu " + j.attaquerArme(salle.getLesEnnemis().get(choix)) + " dégâts.");
                    break;
                }
                if (choix >= 10 && choix < salle.getLesEnnemis().size() + 10) {
                    System.out.println("L'ennemi " + salle.getLesEnnemis().get(choix - 10) + " a raçu " + j.attaquerSort(salle.getLesEnnemis().get(choix - 10)) + " dégâts.");
                    break;
                }
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
            int choix = ihm.interractionInventaireJoueur(j);
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
                if (j.getInventaire().isItem(choix)) {
                    int action = ihm.interractionItem(j, choix);
                    switch (action) {
                        case 0:
                            break;
                        case 1:
                            if (j.isEnDonjon()) {
                                donjon.getSalleActuelle().ajouterItem(j.jeterItem(choix));
                                break;
                            } else {
                                j.jeterItem(choix);
                                break;
                            }
                        case 2:
                            j.utiliser(choix);
                            break;
                        case 3:
                            Equipement aEquiper = (Equipement) j.getInventaire().getItem(choix); //Equipement à équiper dans l'inventaire
                            Equipement dejaEquipe = j.desequiper(aEquiper.getEmplacement()); //Equipement deja équipé
                            if (j.equiper(aEquiper)) {
                                j.getInventaire().supprItem(choix);
                                if (dejaEquipe != null) {
                                    j.ajouterItem(dejaEquipe);
                                }
                            } else {
                                if (dejaEquipe != null) {
                                    j.equiper(dejaEquipe);
                                }
                            }
                            break;
                    }
                }
            } else {
                System.out.println("L'Objet demandé n'existe pas");
            }
        }
    }

    /**
     * Permet de gérér l'inventaire dans une salle
     *
     * @param j le joueur effectuant des modifications
     * @param s la salle concernée
     */
    public void gererInventaireSalle(Joueur j, Salle s) {
        while (true) {
            int choix = ihm.interractionInventaireSalle(j, s);
            if (choix == 98) {
                break;
            }
            if (choix <= 19) {
                if (s.getLesItems().isItem(choix)) {
                    if (!j.ajouterItem(s.getLesItems().getItem(choix))) {
                        System.out.println("Vous n'avez plus de place");
                    } else {
                        s.getLesItems().supprItem(choix);
                        break;
                    }
                } else {
                    System.out.println("L'Objet demandé n'existe pas");
                }
            }
        }
    }
}
