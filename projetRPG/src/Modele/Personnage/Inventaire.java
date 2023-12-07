package Modele.Personnage;

import Controleur.Controleur;
import Modele.Item.Equipement;
import Modele.Item.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Inventaire {

    private Controleur c = Controleur.getInstance();
    private List<Item> sac;

    //emplacements
    private Map<String, Equipement> equipements;

    private final int tailleMax = 20;

    public Inventaire() {
        this.sac = new ArrayList<>();
        this.equipements = new HashMap<>();
        equipements.put("arme", c.getTheme().getLesArmes().get(100));
        equipements.put("tete", c.getTheme().getLesArmes().get(200));
        equipements.put("torse", c.getTheme().getLesArmes().get(200));
        equipements.put("jambes", c.getTheme().getLesArmes().get(200));
        equipements.put("pieds", c.getTheme().getLesArmes().get(200));
    }

    public void trierInventaire() {
        //méthode de comparation + il faut redéfinir compareTo dans Item enfin c'est perdu quoi
    }
    public Equipement getArme() {
        return equipements.get("arme");
    }

    public void setArme(Equipement arme) {
        equipements.put("arme", arme);
    }

    public Equipement getTete() {
        return equipements.get("tete");
    }

    public void setTete(Equipement tete) {
        equipements.put("tete", tete);
    }

    public Equipement getTorse() {
        return equipements.get("torse");
    }

    public void setTorse(Equipement torse) {
        equipements.put("torse", torse);
    }

    public Equipement getJambes() {
        return equipements.get("jambes");
    }

    public void setJambes(Equipement jambes) {
        equipements.put("jambes", jambes);
    }

    public Equipement getPieds() {
        return equipements.get("pieds");
    }

    public void setPieds(Equipement pieds) {
        equipements.put("pieds", pieds);
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
