package Modele.Personnage;

public abstract class Personnage {
    private String nom;
    private ClassePersonnage classe;
    private Inventaire inventaire;

    //statistiques mouvantes
    private int vie;
    private int mana;

    //caractéristiques
    private int force;
    private int constitution;
    private int dexterite;
    private int intelligence;
    private int endurance;
    


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
