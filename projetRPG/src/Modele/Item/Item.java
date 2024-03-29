package Modele.Item;

public abstract class Item {
    private String nom;
    private String description;

    public Item(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public abstract int getType();

    @Override
    public String toString() {
        return nom + "\u001B[0m | " + description;
    }
}
