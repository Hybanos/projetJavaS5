package Modele.Item;

public class Bibelot extends Item {

    public Bibelot(String nom, String description) {
        super(nom, description);
    }

    public int getType() {
        return 1;
    }

    @Override
    public String toString() {
        return "\u001B[33m" + super.toString();
    }
}
