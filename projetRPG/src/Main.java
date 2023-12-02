import Modele.Item.Equipement;
import Modele.Personnage.ClassePersonnage;
import Modele.Personnage.Inventaire;
import Modele.Personnage.Joueur;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ClassePersonnage barbare = new ClassePersonnage("barbare");
        Joueur j1 = new Joueur("Joueur 1", barbare, new Inventaire(), 5, 5, 2, 1, 1);
        Joueur j2 = new Joueur("Joueur 2", barbare, new Inventaire(), 5, 5, 2, 1, 1);
        Equipement e1 = new Equipement("Espadon du Forgeron", "Un espadon forgé de la main d'un grand forgeron", "arme", 5, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == barbare && j.getForce() > 4);
        Equipement e2 = new Equipement("Pantalon en peau de sanglier", "Une petite fourrure au niveau de la ceinture, et un tissu bleu, rien d'incroyable mais ça rend bien", "jambes", 0, 0, 0, 3, 2, 0, 0);
        Equipement e3 = new Equipement("Claymore tueuse de Dragons", "On dit que cette claymore aurait permis de tuer un dragon", "arme", 7, 0.07, 0.7, 0, 0, 0, 0, (j) -> j.getClasse() == barbare && j.getForce() > 6);
        System.out.println(j1.equiper(e1));
        System.out.println(j1.equiper(e2));
        System.out.println(j2.equiper(e3));
        System.out.println(j2.equiper(e2));
        System.out.println(j2.equiper(e3));
        System.out.println(j2.desequiper("jambes"));
        System.out.println(j1);
        System.out.println(j2);
        while (j2.estEnVie() && j1.estEnVie()) {
            System.out.println(j1.attaquerArme(j2) > 0);
            System.out.println("J2 : " + j2.getVie());
            System.out.println(j2.attaquerArme(j1) > 0);
            System.out.println("J1 : " + j1.getVie());
        }
        if (j1.getVie() > j2.getVie()) {
            System.out.println("J1 a gagné");
        } else System.out.println("J2 a gagné");
    }
}