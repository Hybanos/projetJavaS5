package Modele.Personnage;

public abstract class Personnage {
    private String nom;
    private ClasseJoueur classeJoueur;
    private Caracteristique caracteristique;

    public Personnage(String nom, ClasseJoueur classeJoueur, Caracteristique caracteristique){
        this.nom = nom;
        this.classeJoueur = classeJoueur;
        this.caracteristique = caracteristique;
    }
}
