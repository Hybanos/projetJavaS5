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
    private int nbItems = 0;
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

    /**
     * permet d'ajouter un item dans l'inventaire mais en vérifiant le nombre maximum autorisé
     *
     * @param item item à ajouter
     * @return true c'est effectué, false sinon
     */
    public boolean ajouterItem(Item item) {
        boolean effectue = false;
        if (nbItems <= tailleMax - 1) {
            this.sac.add(item);
            effectue = true;
            nbItems++;
        }
        return effectue;
    }

    public Item getItem(int index) {
        return this.sac.get(index);
    }

    public Item supprItem(int index) {
        nbItems--;
        return this.sac.remove(index);
    }

    public int getNbItems() {
        return nbItems;
    }

    public void setNbItems(int nbItems) {
        this.nbItems = nbItems;
    }

    public int getTailleMax() {
        return tailleMax;
    }

    public boolean isItem(int index) {
        return index < this.sac.size();
    }

    /**
     * Permet de réinitialiser un emplacement d'équipement
     *
     * @param emplacement emplacement de l'équipement
     */
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
            inv = "Il n'y a pas d'objets";
        } else {
            for (int i = 0; i < this.sac.size(); i++) {
                inv += "[" + i + "] " + this.sac.get(i) + "\n";
            }
        }
        return inv;
    }
}
