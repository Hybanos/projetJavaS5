package Modele.Donjon;

public class Donjon {
    private Salle premiereSalle;
    private Salle salleActuelle;
    private Salle premiereSalleBackUp;

    public Donjon(Salle premiereSalle){
        this.premiereSalle = premiereSalle;
        this.salleActuelle = premiereSalle;
        premiereSalleBackUp = new Salle(premiereSalle);
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
}
