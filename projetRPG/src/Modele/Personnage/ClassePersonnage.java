package Modele.Personnage;

import Controleur.Controleur;

public class ClassePersonnage {

    private static ClassePersonnage instance;
    private String type;

    public ClassePersonnage(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Classe : " + type + "\n";
    }
}
