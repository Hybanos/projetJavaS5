import Modele.Item.Equipement;
import Modele.Personnage.ClassePersonnage;
import Modele.Personnage.Inventaire;
import Modele.Personnage.Joueur;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello ladies!");
        ClassePersonnage barbare = new ClassePersonnage("barbare");
        Joueur j1 = new Joueur("Joueur 1", barbare, new Inventaire(), 5, 5, 8, 1, 1);
        Joueur j2 = new Joueur("Joueur 2", barbare, new Inventaire(), 5, 5, 2, 1, 1);
        Equipement e1 = new Equipement("Espadon du Forgeron", "Un espadon forgé de la main d'un grand forgeron", "arme", 5, 0.5, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == barbare && j.getForce() > 4);
        Equipement e2 = new Equipement("Manteau en cuir", "Un grand manteau en cuir, il est classe mais pas très utile", "torse", 0, 0, 0, 2, 0, 0, 0);
        System.out.println(j1.equiper(e1));
        System.out.println(j2.equiper(e2));
        System.out.println(j1);
        System.out.println(j2);
        System.out.println(j1.attaquerArme(j2));
        System.out.println(j1);
        System.out.println(j2);
    }
}