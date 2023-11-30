package Modele.Personnage;

import Modele.Item.Item;

import java.util.ArrayList;
import java.util.List;

public class Inventaire {
    private List<Item> sac;
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

    public void supprItem(int index) {
        this.sac.remove(index);
    }

    @Override
    public String toString() {
        String inv = "";
        for(int i = 0; i < this.sac.size(); i++){
            inv += "[" + i + "] " + this.sac.get(i).getNom() + " | " + this.sac.get(i).getDescription() + "\n";
        }
        return inv;
    }
}
