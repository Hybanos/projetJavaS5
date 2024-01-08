package Controleur;

import Modele.Donjon.Donjon;
import Modele.Donjon.Salle;
import Modele.Item.Equipement;
import Modele.Personnage.Ennemi;
import Modele.Personnage.Inventaire;
import Modele.Personnage.Joueur;
import Modele.Theme.MF.MedievalFantastique;
import Modele.Theme.SF.ScienceFiction;
import Modele.Theme.Theme;
import Vue.Ihm;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Random;

public class Controleur {
    //À voir si on ne fait pas un contrôleur par thème
    //Apparemment pas clair
    //En vrai peut-être quand même

    private static Controleur instance;
    private Theme theme = null;
    private Ihm ihm = null;
    private Donjon donjon = null;
    private Salle salle = null;
    private Joueur backupJoueur = null; // sauvegarde temporaire de début de salle
    private Joueur saveJoueur = null; // véritable sauvegarde du joueur à récupérer
    private Salle backupSalle = null;
    private int lvlSalle = 1;
    private final int lvlMax = 10;
    private int retours = 2;

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
        joueur.equiper(theme.getLesArmes().get(101)); // première arme
        joueur.ajouterItem(theme.getLesArmures().get(201)); // première armure
        joueur.ajouterItem(theme.getLesConsommables().get(1));
        System.out.println("\u001B[36mFin de la création du personnage, redirection vers le menu principal ...\n\u001B[0m");
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
                    lvlSalle = 1;
                    retours = 2;
                    joueur.setEnDonjon(true);
                    salle = donjon.getSalleActuelle();
                    joueur = controleurDonjon(joueur);
                    break;
            }
        }
    }

    /**
     * Permet une gestiuon lorsqu'un joueur est dans un donjon
     *
     * @param j le joueur concerné
     * @return le joueur modifié après son passage dans le donjon
     */
    public Joueur controleurDonjon(Joueur j) {
        while (true) {
            backupSalle = new Salle(salle);
            backupJoueur = new Joueur(j);
            int resultat = controleurSalle(j);
            switch (resultat) {
                case 0:
                    if (lvlSalle < lvlMax) {
                        donjon.saveSalle(backupSalle);
                        saveJoueur = new Joueur(backupJoueur);
                        lvlSalle++;
                        ArrayList<Ennemi> ennemis = genererEnnemis(lvlSalle);
                        Inventaire objets = genererObjets(lvlSalle);
                        salle.ajouterSalleFin(new Salle(ennemis, objets));
                        salle = donjon.salleSuivante();
                        j.setPts_dispo(j.getPts_dispo() + (int) (lvlSalle / 1.5));
                        System.out.println("\u001B[32mVous avez récupéré " + (int) (lvlSalle / 1.5) + " points de statistiques\u001B[0m");
                        j.ajouterMana(j.getCapacite());
                        System.out.println("\u001B[32mVous avez récupéré " + j.getCapacite() + " points de capacité\u001B[0m");
                        j.ajouterVie(2 * j.getConstitution());
                        System.out.println("\u001B[32mVous avez récupéré " + 2 * j.getConstitution() + " points de vie\u001B[0m");
                        break;
                    } else {
                        System.out.println("\u001B[33mBravo ! vous avez fini le jeu !");
                        j.ajouterItem(theme.getLesBibelots().get(300));
                        j.setEnDonjon(false);
                        return j;
                    }
                case 1:
                    j.setVie(1);
                    j.getInventaire().supprConsommables();
                    j.setEnDonjon(false);
                    return j;
                case 2:
                    //cas où le joueur reviens à la salle précédente
                    retours--;
                    lvlSalle--;
                    j = new Joueur(saveJoueur);
                    salle = donjon.getSaveSalle();
                    donjon.setSalleActuelle(salle);
                    break;
            }
        }
    }

    /**
     * Génère les ennemis dans une salle
     *
     * @param niveau le niveau de la salle
     * @return une liste dennemis
     */
    public ArrayList<Ennemi> genererEnnemis(int niveau) {
        ArrayList<Ennemi> liste = new ArrayList<>();
        Random ran = new Random();

        for (int i = 1; i <= niveau; i++) {
            if (i % 5 == 0) {
                liste.add(theme.getLesBoss().get(ran.nextInt(theme.getLesBoss().size()) + 21).copy());
            }
            if (i % 3 == 0) {
                liste.add(theme.getLesGrosEnnemis().get(ran.nextInt(theme.getLesGrosEnnemis().size()) + 11).copy());
            } else {
                liste.add(theme.getLesPetitsEnnemis().get(ran.nextInt(theme.getLesPetitsEnnemis().size()) + 1).copy());
            }
        }

        return liste;
    }

    /**
     * Génère les objets d'une salle selon son niveau
     *
     * @param niveau le nivea de la salle
     * @return l'inventaire d'objets créé
     */
    public Inventaire genererObjets(int niveau) {
        Inventaire inv = new Inventaire();
        Random ran = new Random();

        for (int i = 1; i <= niveau; i++) {
            if (i % 3 == 0) {
                int num = ran.nextInt(theme.getLesArmes().size() - 1) + 101;
                inv.ajouterItem(theme.getLesArmes().get(num));
                num = ran.nextInt(theme.getLesArmures().size() - 1) + 201;
                inv.ajouterItem(theme.getLesArmures().get(num));
            } else if (i % 2 == 0) {
                int num = ran.nextInt(theme.getLesConsommables().size()) + 1;
                inv.ajouterItem(theme.getLesConsommables().get(num));
            } else {
                int num = ran.nextInt(theme.getLesBibelots().size() - 1) + 301;
                inv.ajouterItem(theme.getLesBibelots().get(num));
            }
        }

        return inv;
    }

    /**
     * Permet une gestion de la salle plus précisément
     *
     * @param j le joueur dans la salle
     * @return 0 si le joueur a gagné et passe à la salle suivante, 1 s'il est mort et décide de revenir au menu principal, 2 s'il est mort et décide de revenir à la salle précédente
     */
    public int controleurSalle(Joueur j) {
        while (true) {
            if (j.estEnVie()) {
                int choix;
                if (salle.estVide()) {
                    System.out.println("\u001B[32mBravo vous avez tué tous les ennemis dans cette salle !\n\u001B[0m");
                    choix = ihm.interractionSalle(j, salle, 2);
                } else {
                    System.out.println("\n");
                    choix = ihm.interractionSalle(j, salle, 1);
                }
                if (choix == 99) {
                    gererInventaireJoueur(j);
                }
                if (choix == 98) {
                    gererInventaireSalle(j, salle);
                }
                if (choix == 97) {
                    return 0;
                }
                if (choix < salle.getLesEnnemis().size()) {
                    System.out.println("L'ennemi " + salle.getLesEnnemis().get(choix) + " a reçu \u001B[31m" + j.attaquerArme(salle.getLesEnnemis().get(choix)) + "\u001B[0m dégâts.");
                }
                if (choix >= 10 && choix < salle.getLesEnnemis().size() + 10) {
                    System.out.println("L'ennemi " + salle.getLesEnnemis().get(choix - 10) + " a reçu \u001B[31m" + j.attaquerSort(salle.getLesEnnemis().get(choix - 10)) + "\u001B[0m dégâts.");
                }
                for (int i = 0; i < salle.getLesEnnemis().size(); i++) {
                    Ennemi ennemi = salle.getLesEnnemis().get(i);
                    if (ennemi.estEnVie()) {
                        System.out.println("L'ennemi " + ennemi.getNom() + " vous a fait \u001B[31m" + ennemi.attaquer(j) + "\u001B[0m dégâts.");
                    } else {
                        salle.getLesEnnemis().remove(i);
                        System.out.println("\u001B[32mVous avez tué " + ennemi.getNom() + " !\u001B[0m");
                        if (Math.random() <= 0.3) {
                            Random ran = new Random();
                            salle.ajouterItem(Math.random() <= 0.5 ? theme.getLesArmes().get(ran.nextInt(theme.getLesArmes().size() - 1) + 101) : theme.getLesArmures().get(ran.nextInt(theme.getLesArmures().size() - 1) + 201));
                            System.out.println("\u001B[36mLe monstre a laissé tomber un objet au sol\u001B[0m");
                        }
                    }
                }
            } else {
                return controleurMort();
            }
        }
    }

    /**
     * Permet une gestion de la mort du joueur
     *
     * @return 1 s'il décide de quitter le donjon, 2 s'il décide de retourner dans le passé
     */
    public int controleurMort() {
        if (retours > 0) {
            while (true) {
                int choix = ihm.interractionMort(retours);
                switch (choix) {
                    case 1:
                        if (ihm.demanderValidation("\u001B[36mde \u001B[31mquitter le donjon\u001B[36m : vous sortirez avec \u001B[31m1 PV\u001B[36m et \u001B[31msans vos consommables")) {
                            return 1;
                        }
                    case 2:
                        if (ihm.demanderValidation("\u001B[36mde \u001B[31mretourner dans le passé\u001B[36m : vous reviendrez à la \u001B[31mpièce précédente (utilisera 1 retour)")) {
                            return 2;
                        }
                }
            }
        } else {
            return 1;
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
     * Permet de créer un joueur avec son nom et sa classe sur le thème : Médiéval fantastique
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

    /**
     * Permet de créer un joueur avec son nom et sa classe sur le thème : Science fiction
     *
     * @return un joueur
     */
    public Joueur persoSF() {
        while (true) {
            String nom = ihm.choixNomJoueur();
            if (ihm.demanderValidation(nom)) {
                while (true) {
                    String classe = ihm.choixClasseSF();
                    if ("q".equalsIgnoreCase(classe)) {
                        return null;
                    }
                    if (ihm.demanderValidation(classe)) {
                        if ("sportif".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, theme.getLesClasses().get(1), new Inventaire(), 4, 5, 2, 1, 2);
                        }
                        if ("alien".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, theme.getLesClasses().get(2), new Inventaire(), 2, 1, 2, 4, 5);
                        }
                        if ("robot".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, theme.getLesClasses().get(3), new Inventaire(), 2, 2, 4, 3, 3);
                        }
                        if ("pirate spatial".equalsIgnoreCase(classe)) {
                            return new Joueur(nom, theme.getLesClasses().get(4), new Inventaire(), 3, 4, 3, 2, 2);
                        }
                    }
                }
            }
        }
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
                            System.out.println("\u001B[32mPoints ajoutés\u001B[0m");
                        } else {
                            System.out.println("\u001B[31mVous n'avez pas assez de points\u001B[0m");
                        }
                    }
                }
            }
            if (choix <= 19 && !j.getInventaire().isItem(choix)) {
                System.out.println("\u001B[31mL'Objet demandé n'existe pas\u001B[0m");
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
                                System.out.println("\u001B[32mVous avez équipé l'objet\u001B[0m");
                                j.getInventaire().supprItem(choix);
                                if (dejaEquipe != null) {
                                    j.ajouterItem(dejaEquipe);
                                }
                            } else {
                                System.out.println("\u001B[31mVous ne pouvez pas équiper cet objet\u001B[0m");
                                if (dejaEquipe != null) {
                                    j.equiper(dejaEquipe);
                                }
                            }
                            break;
                        default:
                            System.out.println("\u001B[31mL'Objet demandée est impossible\u001B[0m");
                    }
                }
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
                        System.out.println("\u001B[31mVous n'avez plus de place\u001B[0m");
                    } else {
                        s.getLesItems().supprItem(choix);
                        break;
                    }
                } else {
                    System.out.println("\u001B[31mL'Objet demandé n'existe pas\u001B[0m");
                }
            }
        }
    }
}
