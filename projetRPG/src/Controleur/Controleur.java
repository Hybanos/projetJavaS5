package Controleur;

import Modele.Personnage.ClassePersonnage;
import Modele.Personnage.Inventaire;
import Modele.Personnage.Joueur;
import Modele.Theme.MF.MedievalFantastique;
import Modele.Theme.SF.ScienceFiction;
import Modele.Theme.Theme;
import Vue.Ihm;

import java.util.concurrent.TimeUnit;

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

    public void lancerPartie() {
        this.ihm = new Ihm();
        ihm.afficherDemarrage();
        Joueur joueur = initJoueur(ihm);
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
                ihm.interractionInventaire(joueur);
            }
            if (choix == 2) {
                // Lancer le dongeon
            }
        }
    }

    public Joueur initJoueur(Ihm ihm) {
        while (true) {
            String theme = ihm.choixTheme();
            if ("q".equalsIgnoreCase(theme)) {
                return null;
            }
            if (ihm.demanderValidation(theme)) {
                if ("médiéval fantastique".equalsIgnoreCase(theme)) {
                    this.theme = new MedievalFantastique();
                    return persoMF(ihm);
                }
                if ("science fiction".equalsIgnoreCase(theme)) {
                    this.theme = new ScienceFiction();
                    return persoSF(ihm);
                }
            }
        }
    }

    public Joueur persoMF(Ihm ihm){
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
                            return new Joueur(nom, new ClassePersonnage("barbare"), new Inventaire(), 4, 5, 2, 1, 2);
                        }
                        if ("mage".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, new ClassePersonnage("mage"), new Inventaire(), 2, 1, 2, 4, 5);
                        }
                        if ("archer".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, new ClassePersonnage("archer"), new Inventaire(), 2, 2, 4, 3, 3);
                        }
                        if ("chevalier".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, new ClassePersonnage("chevalier"), new Inventaire(), 3, 4, 3, 2, 2);
                        }
                        if ("assassin".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, new ClassePersonnage("assassin"), new Inventaire(), 3, 3, 4, 2, 2);
                        }
                    }
                }
            }
        }
    }

    public Joueur persoSF(Ihm ihm) {
        return null;
    }

}
