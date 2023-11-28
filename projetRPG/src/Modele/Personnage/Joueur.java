package Modele.Personnage;

public class Joueur extends Personnage{

    public Joueur(String nom, ClassePersonnage classe, Inventaire inventaire, int force, int constitution, int dexterite, int intelligence, int endurance) {
        super(nom, classe, inventaire, force, constitution, dexterite, intelligence, endurance);
    }
}
