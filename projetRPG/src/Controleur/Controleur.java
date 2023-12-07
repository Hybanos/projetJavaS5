package Controleur;

import Modele.Theme.MF.MedievalFantastique;
import Modele.Theme.Theme;

public class Controleur {
    //A voir si on fait pas un contrôleur pas thème
        // apparement pas clair

    private static Controleur instance;
    private Theme theme;

    public static Controleur getInstance() {
        return instance == null ? new Controleur() : instance;
    }

    public Controleur() {
        this.theme = new MedievalFantastique();
    }

    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

}
