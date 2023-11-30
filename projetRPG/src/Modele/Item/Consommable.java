package Modele.Item;

import Modele.Personnage.Personnage;

public class Consommable extends Item {
    private int vie; //rajout de vie
    private int mana; //rajout de mana
    private Personnage personnage;

    public Consommable(String nom, String description, int vie, int mana) {
        super(nom, description);
        this.vie = vie;
        this.mana = mana;
    }

    public int getVie() {
        return vie;
    }

    public int getMana() {
        return mana;
    }
    
    public void appliquer() {
        personnage.setVie(personnage.getVie()+vie);
        personnage.setMana(personnage.getMana()+mana);
    }
}
