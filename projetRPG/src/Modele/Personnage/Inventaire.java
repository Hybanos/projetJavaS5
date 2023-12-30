package Modele.Personnage;

import Controleur.Controleur;
import Modele.Item.Equipement;
import Modele.Item.Item;

import java.util.*;

public class Inventaire {

    private final Controleur c = Controleur.getInstance();
    private List<Item> sac;

    //emplacements
    private Map<String, Equipement> equipements;

    private final int tailleMax = 20;

    public Inventaire() {
        this.sac = new ArrayList<>();
        this.equipements = new HashMap<>();
        equipements.put("arme", c.getTheme().getLesEquipements().get(100));
        equipements.put("tete", c.getTheme().getLesEquipements().get(200));
        equipements.put("torse", c.getTheme().getLesEquipements().get(200));
        equipements.put("jambes", c.getTheme().getLesEquipements().get(200));
        equipements.put("pieds", c.getTheme().getLesEquipements().get(200));
    }

    public Equipement getEquipement(String emplacement) {
        return equipements.get(emplacement);
    }

    public void setEquipement(Equipement arme) {
        equipements.put(arme.getEmplacement(), arme);
    }

    public void ajouterItem(Item item) {
        this.sac.add(item);
    }

    public Item getItem(int index) {
        return this.sac.get(index);
    }

    public Item supprItem(int index) {
        return this.sac.remove(index);
    }

    public void resetEquipement(String emplacement) {
        if (Objects.equals(emplacement, "arme")) {
            equipements.put("arme", c.getTheme().getLesEquipements().get(100));
        } else {
            equipements.put(emplacement, c.getTheme().getLesEquipements().get(200));
        }
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
