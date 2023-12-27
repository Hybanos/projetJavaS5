package Modele.Theme.SF;

import Modele.Theme.MF.RegistresMF;
import Modele.Theme.Theme;

public class ScienceFiction extends Theme {

    public ScienceFiction() {
        super("sf");
    }
    @Override
    protected void initialiser() {
    }

    private void initItems() {
        System.out.println("Init. Items");
        lesConsommables = RegistresSF.genererConsomable();
    }
}