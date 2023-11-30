package Modele.Personnage;

public class Joueur extends Personnage{

    public Joueur(String nom, ClassePersonnage classe, Inventaire inventaire, int force, int constitution, int dexterite, int intelligence, int endurance) {
        super(nom, classe, inventaire, force, constitution, dexterite, intelligence, endurance);
    }

    @Override
    public String toString() {
        return super.toString() +
                "Mana : " + getMana() + "/" + getMAX_MANA() + "\n" +
                "Classe : " + getClasse() + "\n" +
                "\nStatistiques :\n" +
                "Force : " + getForce() + "\n" +
                "Constitution : " + getConstitution() + "\n" +
                "Dextérité : " + getDexterite() + "\n" +
                "Intelligence : " + getIntelligence() + "\n" +
                "Capacité Magique : " + getCapacite() + "\n" +
                "\nInventaire :\n" + getInventaire();
    }
}
