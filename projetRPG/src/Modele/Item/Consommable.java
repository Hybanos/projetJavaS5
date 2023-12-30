package Modele.Item;

public class Consommable extends Item {
    private int vie; //rajout de vie
    private int mana; //rajout de mana

    public Consommable(String nom, String description, int vie, int mana) {
        super(nom, description);
        this.vie = vie;
        this.mana = mana;
    }

    public int getType(){
        return 2;
    }

    public int getVie() {
        return vie;
    }

    public int getMana() {
        return mana;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
