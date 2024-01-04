package Modele.Donjon;

import Modele.Item.Item;
import Modele.Personnage.Ennemi;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Donjon {
    private Salle premiereSalle;
    private Salle salleActuelle;
    private Salle premiereSalleBackUp;
    private Salle salleActuelleBackUp;


    public Donjon(List<Set<Ennemi>> lesEnnemis, List<Set<Item>> lesItems){
        int taille = Math.min(lesEnnemis.size(), lesItems.size());
        premiereSalle = new Salle(lesEnnemis.get(0), lesItems.get(0));
        premiereSalleBackUp = new Salle(lesEnnemis.get(0), lesItems.get(0));
        salleActuelle = premiereSalle;
        salleActuelleBackUp = premiereSalleBackUp;
        for (int i = 1; i < taille; i++){
            salleActuelle.ajouterSalleFin(new Salle(lesEnnemis.get(i), lesItems.get(i)));
            salleActuelleBackUp.ajouterSalleFin(new Salle(lesEnnemis.get(i), lesItems.get(i)));
        }
    }

    public Donjon(Salle premiereSalle){
        this.premiereSalle = premiereSalle;
        this.salleActuelle = premiereSalle;
        premiereSalleBackUp = new Salle(premiereSalle);
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


    public void ajouterSalleFin(Salle salle){
        premiereSalle.ajouterSalleFin(salle);
        premiereSalleBackUp.ajouterSalleFin(new Salle(salle));
    }

    public void resetSalleActuelle(){
        Salle salleSuivante = salleActuelle.getSalleSuivante();
        Salle sallePrecedente = salleActuelle.getSallePrecedente();
        Salle salle = new Salle(salleActuelleBackUp);
        salle.setSallePrecedente(sallePrecedente);
        salle.setSalleSuivante(salleSuivante);
        salleSuivante.setSallePrecedente(salle);
        sallePrecedente.setSalleSuivante(salle);
    }

    public void salleSuivante(){
        salleActuelle = salleActuelle.getSalleSuivante();
        salleActuelleBackUp = salleActuelleBackUp.getSalleSuivante();
    }

    public void sallePrecedente(){
        salleActuelle = salleActuelle.getSallePrecedente();
        salleActuelleBackUp = salleActuelleBackUp.getSallePrecedente();
    }

    public void resetDonjon(){
        premiereSalle = new Salle(premiereSalleBackUp);
        salleActuelle = premiereSalle;
        salleActuelleBackUp = premiereSalleBackUp;
        while (salleActuelleBackUp != null){
            resetSalleActuelle();
            salleActuelle = salleActuelle.getSalleSuivante();
            salleActuelleBackUp = salleActuelleBackUp.getSalleSuivante();
        }
    }

    public String toString(){
        return "Le Donjon :\n";
    }


}
