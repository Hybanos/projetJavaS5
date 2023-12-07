package Modele.Theme.MF;

import Modele.Theme.MF.Item.Registres;
import Modele.Theme.Theme;

public class MedievalFantastique extends Theme {

    public MedievalFantastique() {
        super();
    }

    public void initialiser() {
        System.out.println("Init. Medieval Fantasique");
        initItems();
        initDonjon();
        initJoueur();
        initEnnemis();
    }

    private void initItems() {
        System.out.println("Init. Items");
        lesArmes = Registres.genererArmes();
        lesConsommables = Registres.genererConsomable();
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
