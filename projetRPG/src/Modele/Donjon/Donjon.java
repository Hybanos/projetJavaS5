package Modele.Donjon;

public class Donjon {
    private Salle premiereSalle;
    private Salle premiereSalleBackUp;

    public Donjon(Salle premiereSalle){
        this.premiereSalle = premiereSalle;
        premiereSalleBackUp = new Salle(premiereSalle);
    }
}
