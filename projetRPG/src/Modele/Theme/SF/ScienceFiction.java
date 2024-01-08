package Modele.Theme.SF;

import Modele.Personnage.Joueur;
import Modele.Theme.MF.RegistresMF;
import Modele.Theme.Theme;

public class ScienceFiction extends Theme {

    public ScienceFiction() {
        super("sf");
    }

    @Override
    public void initialiser() {
        System.out.println("Init. Science Fiction");
        initClasses();
        initItems();
        initDonjon();
        initEnnemis();

    }

    @Override
    public void actionSpeciale(Joueur j) {

    }

    private void initClasses() {
        System.out.println("Init. Classes");
        lesClasses = RegistresSF.genererClasses();
    }

    private void initItems() {
        System.out.println("Init. Items");
        lesBibelots = RegistresSF.genererBibelots();
        lesConsommables = RegistresSF.genererConsomable();
        lesArmes = RegistresSF.genererArmes();
        lesArmures = RegistresSF.genererArmures();
    }

    private void initDonjon() {
        System.out.println("Init. Donjon");
    }

    private void initEnnemis() {
        System.out.println("Init. Ennemis");
        lesPetitsEnnemis = RegistresSF.genererPetitsEnnemis();
        lesGrosEnnemis = RegistresSF.genererGrosEnnemis();
        lesBoss = RegistresSF.genererBoss();
    }
}
