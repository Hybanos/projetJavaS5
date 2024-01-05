package Modele.Personnage;

public class Ennemi extends Joueur {

    private int attaquePref;

    public Ennemi(String nom, ClassePersonnage classe, Inventaire inventaire, int force, int constitution, int dexterite, int intelligence, int capacite, int attaquePref) {
        super(nom, classe, inventaire, force, constitution, dexterite, intelligence, capacite);
        this.attaquePref = attaquePref;
    }

    public int attaquer(Joueur j){
        if (attaquePref == 1){
            return attaquerArme(j);
        }
        if (attaquePref == 2) {
            return attaquerSort(j);
        }
        return 0;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
