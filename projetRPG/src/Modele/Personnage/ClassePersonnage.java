package Modele.Personnage;

public class ClassePersonnage {
    private String type;

    public ClassePersonnage(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return type;
    }
}
