package Modele.Personnage;

public abstract class Personnage {
    public String nom;
    public ClassePersonnage classe;
    public Inventaire inventaire;

    //statistiques mouvantes
    public int vie;
    public int mana;

    //caractéristiques
    public int force;
    public int constitution;
    public int dexterite;
    public int intelligence;
    public int endurance;
    


    public Personnage(String nom, ClassePersonnage classe, Inventaire inventaire, int force, int constitution, int dexterite, int intelligence, int endurance){
        this.nom = nom;
        this.classe = classe;
        this.inventaire = inventaire;
        this.force = force;
        this.constitution = constitution;
        this.dexterite = dexterite;
        this.intelligence = intelligence;
        this.endurance = endurance;
    }

}
