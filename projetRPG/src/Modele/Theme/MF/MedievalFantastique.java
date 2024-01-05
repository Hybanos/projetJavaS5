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
        initEnnemis();
    }

    private void initClasses() {
        System.out.println("Init. Classes");
        lesClasses = RegistresMF.genererClasses();
    }

    private void initItems() {
        System.out.println("Init. Items");
        lesConsommables = RegistresMF.genererConsomable();
        lesEquipements = RegistresMF.genererEquipements();
    }

    private void initDonjon() {
        System.out.println("Init. Donjon");
    }

    private void initEnnemis() {
        System.out.println("Init. Ennemis");
        lesEnnemis = RegistresMF.genererEnnemis();
    }
}
