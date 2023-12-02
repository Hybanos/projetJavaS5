package Modele.Personnage;

public class Joueur extends Personnage{

    public Joueur(String nom, ClassePersonnage classe, Inventaire inventaire, int force, int constitution, int dexterite, int intelligence, int capacite) {
        super(nom, classe, inventaire, force, constitution, dexterite, intelligence, capacite);
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
                "Équipement :\n" +
                "Arme : " + getArme() + "\n" +
                "Tête : " + getTete() + "\n" +
                "Torse : " + getTorse() + "\n" +
                "Jambes : " + getJambes() + "\n" +
                "Pieds : " + getPieds() + "\n" +
                "Probabilité de toucher : " + (int) (((((double) this.getDexterite() / 10) + this.getArme().getPrecision()) / 2) * 100) + "%" +
                "\nInventaire :\n" + getInventaire();
    }
}
