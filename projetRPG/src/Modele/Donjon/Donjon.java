package Modele.Donjon;

import Controleur.Controleur;
import Modele.Item.Item;
import Modele.Personnage.Ennemi;
import Modele.Personnage.Inventaire;

import java.util.ArrayList;
import java.util.HashMap;

public class Donjon {
    private Salle premiereSalle;
    private Salle salleActuelle;
    private Salle premiereSalleBackUp;
    private Salle salleActuelleBackUp;
    private Controleur c = Controleur.getInstance();


    public Donjon() {
        ArrayList<Ennemi> enemis = new ArrayList<>();
        enemis.add(c.getTheme().getLesEnnemis().get(1).copy());
        Inventaire items = new Inventaire();
        items.ajouterItem(c.getTheme().getLesConsommables().get(3));
        premiereSalle = new Salle(enemis, items);
        premiereSalleBackUp = premiereSalle;
        salleActuelle = premiereSalle;
        salleActuelleBackUp = premiereSalleBackUp;
    }

    public Salle getPremiereSalle() {
        return premiereSalle;
    }

    public void setPremiereSalle(Salle premiereSalle) {
        this.premiereSalle = premiereSalle;
    }

    public Salle getSalleActuelle() {
        return salleActuelle;
    }

    public void setSalleActuelle(Salle salleActuelle) {
        this.salleActuelle = salleActuelle;
    }

    public Salle getPremiereSalleBackUp() {
        return premiereSalleBackUp;
    }

    public void setPremiereSalleBackUp(Salle premiereSalleBackUp) {
        this.premiereSalleBackUp = premiereSalleBackUp;
    }


    public void ajouterSalleFin(Salle salle) {
        premiereSalle.ajouterSalleFin(salle);
        premiereSalleBackUp.ajouterSalleFin(new Salle(salle));
    }

    public void resetSalleActuelle() {
        Salle salleSuivante = salleActuelle.getSalleSuivante();
        Salle sallePrecedente = salleActuelle.getSallePrecedente();
        Salle salle = new Salle(salleActuelleBackUp);
        salle.setSallePrecedente(sallePrecedente);
        salle.setSalleSuivante(salleSuivante);
        salleSuivante.setSallePrecedente(salle);
        sallePrecedente.setSalleSuivante(salle);
    }

    public Salle salleSuivante() {
        salleActuelle = salleActuelle.getSalleSuivante();
        salleActuelleBackUp = salleActuelleBackUp.getSalleSuivante();
        return salleActuelle;
    }

    public void sallePrecedente() {
        salleActuelle = salleActuelle.getSallePrecedente();
        salleActuelleBackUp = salleActuelleBackUp.getSallePrecedente();
    }

    public void resetDonjon() {
        premiereSalle = new Salle(premiereSalleBackUp);
        salleActuelle = premiereSalle;
        salleActuelleBackUp = premiereSalleBackUp;
        while (salleActuelleBackUp != null) {
            resetSalleActuelle();
            salleActuelle = salleActuelle.getSalleSuivante();
            salleActuelleBackUp = salleActuelleBackUp.getSalleSuivante();
        }
    }

    public String toString() {
        return "Le Donjon :\n";
    }


}
