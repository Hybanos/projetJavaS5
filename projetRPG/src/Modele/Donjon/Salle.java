package Modele.Donjon;


import Modele.Item.Item;
import Modele.Personnage.Ennemi;
import Modele.Personnage.Inventaire;

import java.util.HashSet;
import java.util.Set;

public class Salle {
    private Set<Ennemi> lesEnnemis = new HashSet<>();
    private Inventaire lesItems = new Inventaire();
    private Salle salleSuivante = null;
    private Salle sallePrecedente = null;


    public Salle(Set<Ennemi> lesEnnemis, Set<Item> lesItems){
        this.lesEnnemis = lesEnnemis;
        for (Item i : lesItems) {
            this.lesItems.ajouterItem(i);
        }
    }
    public Salle(Salle salle){
        lesEnnemis = salle.getLesEnnemis();
        lesItems = salle.getLesItems();
    }

    public Set<Ennemi> getLesEnnemis(){
        return lesEnnemis;
    }
    public Inventaire getLesItems(){
        return lesItems;
    }
    public void setSallePrecedente(Salle sallePrecedente){
        this.sallePrecedente = sallePrecedente;
    }

    public void ajouterSalleFin(Salle salle){
        if (salleSuivante == null){
            salleSuivante = salle;
            salle.setSallePrecedente(this);
        } else {
            salleSuivante.ajouterSalleFin(salle);
        }
    }
}
