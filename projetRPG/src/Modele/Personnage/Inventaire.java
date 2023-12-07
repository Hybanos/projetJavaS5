package Modele.Personnage;

import Modele.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
    private List<Item> sac;

    //emplacements
    private Equipement arme = new Equipement("Main", "une main", "", 0, 0, 0, 0, 0, 0, 0);
    private Equipement tete = new Equipement("Tête nue", "tout nu", "", 0, 0, 0, 0, 0, 0, 0);
    private Equipement torse = new Equipement("Torse nu", "tout nu", "", 0, 0, 0, 0, 0, 0, 0);
    private Equipement jambes = new Equipement("Jambes nues", "tout nu", "", 0, 0, 0, 0, 0, 0, 0);
    private Equipement pieds = new Equipement("Pieds nus", "tout nu", "", 0, 0, 0, 0, 0, 0, 0);

    private final int tailleMax = 20;

    public Inventaire() {
        this.sac = new ArrayList<>();
    }

    public void trierInventaire() {
        //méthode de comparation + il faut redéfinir compareTo dans Item enfin c'est perdu quoi
    }

    public void ajouterItem(Item item) {
        this.sac.add(item);
    }

    public Item getItem(int index) {
        return this.sac.get(index);
    }

    public void supprItem(Item item) {
        this.sac.remove(item);
    }

    public void supprItem(int index) {
        this.sac.remove(index);
    }

    @Override
    public String toString() {
        String inv = "";
        if (this.sac.isEmpty()) {
            inv = "Le sac est vide";
        } else {
            for (int i = 0; i < this.sac.size(); i++) {
                inv += "[" + i + "] " + this.sac.get(i) + "\n";
            }
        }
        return inv;
    }
}
