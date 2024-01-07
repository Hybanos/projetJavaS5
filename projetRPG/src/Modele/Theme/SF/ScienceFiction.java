package Modele.Theme.SF;

import Modele.Theme.Theme;

public class ScienceFiction extends Theme {

    public ScienceFiction() {
        super("sf");
    }

    @Override
    protected void initialiser() {
        System.out.println("Init. Science Fiction");
        initClasses();
        initItems();
        initDonjon();
        initEnnemis();

    }

    private void initClasses() {
        System.out.println("Init. Classes");
        lesClasses = RegistresSF.genererClasses();
    }

    private void initItems() {
        System.out.println("Init. Items");
        lesBibelots = RegistresSF.genererBibelots();
        lesConsommables = RegistresSF.genererConsomable();
        lesEquipements = RegistresSF.genererEquipements();
    }

    private void initDonjon() {
        System.out.println("Init. Donjon");
    }

    private void initEnnemis() {
        System.out.println("Init. Ennemis");
        lesEnnemis = RegistresSF.genererEnnemis();
    }
}
