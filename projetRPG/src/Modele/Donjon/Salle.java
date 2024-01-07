package Modele.Donjon;


import Modele.Item.Item;
import Modele.Personnage.Ennemi;
import Modele.Personnage.Inventaire;

import java.util.ArrayList;

public class Salle {
    private ArrayList<Ennemi> lesEnnemis = new ArrayList<>();
    private Inventaire lesItems = new Inventaire();
    private Salle salleSuivante = null;


    public Salle(ArrayList<Ennemi> lesEnnemis, Inventaire lesItems) {
        this.lesEnnemis = lesEnnemis;
        this.lesItems = lesItems;
    }

    public Salle(Salle salle) {
        lesEnnemis = new ArrayList<>(salle.getCopieEnnemis());
        lesItems = new Inventaire(salle.getLesItems());
        salleSuivante = null;
    }

    public ArrayList<Ennemi> getCopieEnnemis() {
        ArrayList<Ennemi> liste = new ArrayList<>();
        for (Ennemi lesEnnemi : lesEnnemis) {
            liste.add(lesEnnemi.copy());
        }
        return liste;
    }

    public ArrayList<Ennemi> getLesEnnemis() {
        return lesEnnemis;
    }

    public Inventaire getLesItems() {
        return lesItems;
    }

    public Salle getSalleSuivante() {
        return salleSuivante;
    }

    public void ajouterItem(Item i) {
        lesItems.ajouterItem(i);
    }

    public void ajouterSalleFin(Salle salle) {
        if (salleSuivante == null) {
            salleSuivante = salle;
        } else {
            salleSuivante.ajouterSalleFin(salle);
        }
    }

    public boolean estVide() {
        return lesEnnemis.isEmpty();
    }

    /**
     * Permet d'afficher les ennemis et leur vie
     * @return un affichage contenant tous les ennemis dans une salle
     */
    public String affichertLesEnnemis() {
        String affichage = "";
        if (this.lesEnnemis.isEmpty()) {
            affichage = "Il n'y a pas d'ennemis.";
        } else {
            for (int i = 0; i < this.lesEnnemis.size(); i++) {
                affichage += "[" + i + "] " + this.lesEnnemis.get(i) + "\n";
            }
        }
        return affichage;
    }
}
