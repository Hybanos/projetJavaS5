package Modele.Theme.MF;

import Modele.Theme.Theme;

public class MedievalFantastique extends Theme {

    public MedievalFantastique() {
        super("mf");
    }

    public void initialiser() {
        System.out.println("Init. Medieval Fantasique");
        initClasses();
        initItems();
        initDonjon();
        initJoueur();
        initEnnemis();
    }

    private void initClasses() {
        System.out.println("Init. Classes");

    }

    private void initItems() {
        System.out.println("Init. Items");
        lesConsommables = RegistresMF.genererConsomable();
        lesEquipements = RegistresMF.genererEquipements();
    }

    private void initDonjon() {
        System.out.println("Init. Donjon");
    }

    private void initJoueur() {
        System.out.println("Init. Joueur");
    }

    private void initEnnemis() {
        System.out.println("Init. Ennemis");
    }

    private void initNonConsommable() {
        System.out.println("Init. Item-NonConsommable");
        initAttaque();
        initProtection();
    }

    private void initProtection() {
        System.out.println("Init. Item-NonConsommable-Protection");
    }

    private void initAttaque() {
        System.out.println("Init. Item-NonConsommable-Attaque");
    }

    private void initConsommable() {
        System.out.println("Init. Item-Consommable");
    }
}
