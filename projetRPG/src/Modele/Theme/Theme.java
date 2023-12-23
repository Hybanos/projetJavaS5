package Modele.Theme;

import Modele.Item.Bibelot;
import Modele.Item.Consommable;
import Modele.Item.Equipement;

import java.util.HashMap;
import java.util.Map;

public abstract class Theme {

    private String nom;
    protected Map<Integer, Equipement> lesEquipements = new HashMap<>();
    protected Map<Integer, Consommable> lesConsommables = new HashMap<>();
    protected Map<Integer, Bibelot> lesBibelots = new HashMap<>();

    //Ajouter un attribut pour le Donjon


    public Theme(String nom) {
        initialiser();
        this.nom = nom;
    }

    protected abstract void initialiser();

    public String getNom() {
        return nom;
    }

    public Map<Integer, Equipement> getLesEquipements() {
        return lesEquipements;
    }

    public Map<Integer, Consommable> getLesConsommables() {
        return lesConsommables;
    }

    public Map<Integer, Bibelot> getLesBibelots() {
        return lesBibelots;
    }
}
