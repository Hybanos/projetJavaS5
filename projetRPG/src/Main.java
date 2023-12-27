import Controleur.Controleur;
import Modele.Item.Equipement;
import Modele.Personnage.ClassePersonnage;
import Modele.Personnage.Inventaire;
import Modele.Personnage.Joueur;

public class Main {
    public static void main(String[] args) {
        Controleur c = new Controleur();
        c.lancerPartie();
    }
}