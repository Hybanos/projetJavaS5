package Modele.Donjon;


import Modele.Item.Item;
import Modele.Personnage.Ennemi;
import Modele.Personnage.Inventaire;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Salle {
    private ArrayList<Ennemi> lesEnnemis = new ArrayList<>();
    private Inventaire lesItems = new Inventaire();
    private Salle salleSuivante = null;
    private Salle sallePrecedente = null;


    public Salle(ArrayList<Ennemi> lesEnnemis, Inventaire lesItems) {
        this.lesEnnemis = lesEnnemis;
        this.lesItems = lesItems;
    }

    public Salle(Salle salle) {
        lesEnnemis = salle.getLesEnnemis();
        lesItems = salle.getLesItems();
    }

    public ArrayList<Ennemi> getLesEnnemis() {
        return lesEnnemis;
    }

    public void setLesEnnemis(ArrayList<Ennemi> lesEnnemis) {
        this.lesEnnemis = lesEnnemis;
    }

    public Inventaire getLesItems() {
        return lesItems;
    }

    public void setLesItems(Inventaire lesItems) {
        this.lesItems = lesItems;
    }

    public Salle getSalleSuivante() {
        return salleSuivante;
    }

    public void setSalleSuivante(Salle salleSuivante) {
        this.salleSuivante = salleSuivante;
    }

    public Salle getSallePrecedente() {
        return sallePrecedente;
    }

    public void setSallePrecedente(Salle sallePrecedente) {
        this.sallePrecedente = sallePrecedente;
    }

    public void ajouterItem(Item i) {
        lesItems.ajouterItem(i);
    }

    public void ajouterSalleFin(Salle salle) {
        if (salleSuivante == null) {
            salleSuivante = salle;
            salle.setSallePrecedente(this);
        } else {
            salleSuivante.ajouterSalleFin(salle);
        }
    }

    public boolean estVide() {
        return lesEnnemis.size() == 0;
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
