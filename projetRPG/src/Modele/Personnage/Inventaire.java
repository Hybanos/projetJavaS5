package Modele.Personnage;

import Controleur.Controleur;
import Modele.Item.Equipement;
import Modele.Item.Item;

import java.util.*;

public class Inventaire {

    private final Controleur c = Controleur.getInstance();
    private List<Item> sac;
    private final int tailleMax = 30;

    //emplacements
    private Map<String, Equipement> equipements;

    public Inventaire() {
        this.sac = new ArrayList<>();
        this.equipements = new HashMap<>();
        equipements.put("arme", c.getTheme().getLesArmes().get(100));
        equipements.put("tete", c.getTheme().getLesArmures().get(200));
        equipements.put("torse", c.getTheme().getLesArmures().get(200));
        equipements.put("jambes", c.getTheme().getLesArmures().get(200));
        equipements.put("pieds", c.getTheme().getLesArmures().get(200));
    }

    public Inventaire(Inventaire i) {
        this.sac = new ArrayList<>(i.getSac());
        this.equipements = new HashMap<>(i.getLesEquipements());
    }

    public List<Item> getSac() {
        return sac;
    }

    public Map<String, Equipement> getLesEquipements() {
        return equipements;
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
        if (sac.size() <= tailleMax - 1) {
            this.sac.add(item);
            effectue = true;
        }
        return effectue;
    }

    public Item getItem(int index) {
        return this.sac.get(index);
    }

    public Item supprItem(int index) {
        return this.sac.remove(index);
    }

    public int getNbItems() {
        return sac.size();
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
            equipements.put("arme", c.getTheme().getLesArmures().get(100));
        } else {
            equipements.put(emplacement, c.getTheme().getLesArmures().get(200));
        }
    }

    /**
     * Permet de supprimer les consommables de la liste (lorsque le joueur meurt et retourne au menu principal notamment)
     */
    public void supprConsommables() {
        for (int i = 0; i < sac.size(); i++) {
            if (sac.get(i).getType() == 2) {
                sac.remove(i);
                i = i == 0 ? i - 1 : 0;
            }
        }
    }

    @Override
    public String toString() {
        String inv = "";
        if (this.sac.isEmpty()) {
            inv = "\u001B[31mIl n'y a pas d'objets\n\u001B[0m";
        } else {
            for (int i = 0; i < this.sac.size(); i++) {
                inv += "\u001B[34m[" + i + "]\u001B[0m " + this.sac.get(i) + "\n";
            }
        }
        return inv;
    }
}
