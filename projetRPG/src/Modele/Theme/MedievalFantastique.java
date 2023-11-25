package Modele.Theme;

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

    void initItems() {
        System.out.println("Init. Items");
        initNonConsommable();
        initConsommable();
    }

    void initDonjon() {
        System.out.println("Init. Donjon");
    }

    void initJoueur() {
        System.out.println("Init. Joueur");
    }

    void initEnnemis() {
        System.out.println("Init. Ennemis");
    }

    void initNonConsommable() {
        System.out.println("Init. Item-NonConsommable");
        initAttaque();
        initProtection();
    }

    void initProtection() {
        System.out.println("Init. Item-NonConsommable-Protection");
    }

    void initAttaque() {
        System.out.println("Init. Item-NonConsommable-Attaque");
    }

    void initConsommable() {
        System.out.println("Init. Item-Consommable");
    }
}
