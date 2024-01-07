package Modele.Donjon;

import Controleur.Controleur;
import Modele.Item.Item;
import Modele.Personnage.Ennemi;
import Modele.Personnage.Inventaire;

import java.util.ArrayList;
import java.util.HashMap;

public class Donjon {
    private Salle salleActuelle;
    private Salle saveSalle;
    private Controleur c = Controleur.getInstance();


    public Donjon() { // Crétaion du donjon avec la première salle
        ArrayList<Ennemi> enemis = new ArrayList<>();
        enemis.add(c.getTheme().getLesPetitsEnnemis().get(1).copy());
        Inventaire items = new Inventaire();
        items.ajouterItem(c.getTheme().getLesConsommables().get(5));
        salleActuelle = new Salle(enemis, items);
    }

    public Salle getSalleActuelle() {
        return salleActuelle;
    }

    public void setSalleActuelle(Salle salleActuelle) {
        this.salleActuelle = salleActuelle;
    }

    public Salle getSaveSalle() {
        return new Salle(saveSalle);
    }

    public void saveSalle(Salle s) {
        saveSalle = new Salle(s);
    }

    public Salle salleSuivante() {
        salleActuelle = salleActuelle.getSalleSuivante();
        return salleActuelle;
    }

    public String toString() {
        return "Le Donjon :\n";
    }
}
