package Modele.Theme;

import Modele.Item.Bibelot;
import Modele.Item.Consommable;
import Modele.Item.Equipement;
import Modele.Personnage.ClassePersonnage;
import Modele.Personnage.Ennemi;

import java.util.HashMap;
import java.util.Map;

public abstract class Theme {

    private String nom;
    protected Map<Integer, ClassePersonnage> lesClasses = new HashMap<>();
    protected Map<Integer, Equipement> lesArmes = new HashMap<>();
    protected Map<Integer, Equipement> lesArmures = new HashMap<>();
    protected Map<Integer, Consommable> lesConsommables = new HashMap<>();
    protected Map<Integer, Bibelot> lesBibelots = new HashMap<>();
    protected Map<Integer, Ennemi> lesPetitsEnnemis = new HashMap<>();
    protected Map<Integer, Ennemi> lesGrosEnnemis = new HashMap<>();
    protected Map<Integer, Ennemi> lesBoss = new HashMap<>();

    //Ajouter un attribut pour le Donjon


    public Theme(String nom) {
        initialiser();
        this.nom = nom;
    }

    protected abstract void initialiser();

    public String getNom() {
        return nom;
    }

    public Map<Integer, ClassePersonnage> getLesClasses() {
        return lesClasses;
    }

    public Map<Integer, Equipement> getLesArmes() {
        return lesArmes;
    }

    public Map<Integer, Equipement> getLesArmures() {
        return lesArmures;
    }

    public Map<Integer, Consommable> getLesConsommables() {
        return lesConsommables;
    }

    public Map<Integer, Bibelot> getLesBibelots() {
        return lesBibelots;
    }

    public Map<Integer, Ennemi> getLesPetitsEnnemis() {
        return lesPetitsEnnemis;
    }

    public Map<Integer, Ennemi> getLesGrosEnnemis() {
        return lesGrosEnnemis;
    }

    public Map<Integer, Ennemi> getLesBoss() {
        return lesBoss;
    }
}
