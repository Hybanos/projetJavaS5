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
}
