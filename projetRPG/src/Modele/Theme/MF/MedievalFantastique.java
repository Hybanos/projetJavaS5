package Modele.Theme.MF;

import Modele.Personnage.Joueur;
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

    @Override
    public void actionSpeciale(Joueur j) {

    }

    private void initClasses() {
        System.out.println("Init. Classes");
        lesClasses = RegistresMF.genererClasses();
    }

    private void initItems() {
        System.out.println("Init. Items");
        lesBibelots = RegistresMF.genererBibelots();
        lesConsommables = RegistresMF.genererConsomable();
        lesArmes = RegistresMF.genererArmes();
        lesArmures = RegistresMF.genererArmures();
    }

    private void initDonjon() {
        System.out.println("Init. Donjon");
    }

    private void initEnnemis() {
        System.out.println("Init. Ennemis");
        lesPetitsEnnemis = RegistresMF.genererPetitsEnnemis();
        lesGrosEnnemis = RegistresMF.genererGrosEnnemis();
        lesBoss = RegistresMF.genererBoss();
    }
}
