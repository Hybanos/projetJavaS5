package Vue;

import Controleur.Controleur;
import Modele.Donjon.Salle;
import Modele.Personnage.Inventaire;
import Modele.Personnage.Joueur;

import java.util.Scanner;

public class Ihm {

    private Controleur c = Controleur.getInstance();

    // Demander

    /**
     * Demande à l'utilisateur via un objet de type scanner de saisir son nom.
     *
     * @return le nom du joueur.
     */
    public String demanderNomJoueur() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Veuillez saisir le nom du joueur :");

            if (sc.hasNextLine()) {
                return sc.nextLine();
            }
        }
    }

    public String demanderClasse() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            break;
        }
        return "";
    }

    public boolean demanderValidation() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Validez vous votre choix ?");

            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                if ("o".equalsIgnoreCase(rep) || "oui".equalsIgnoreCase(rep) || "y".equalsIgnoreCase(rep) || "yes".equalsIgnoreCase(rep)) {
                    return true;
                }
                if ("n".equalsIgnoreCase(rep) || "non".equalsIgnoreCase(rep) || "no".equalsIgnoreCase(rep)){
                    return false;
                }
            }
        }
    }

    public int interractionMenu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            if (sc.hasNextLine()) {
                String rep = sc.nextLine();
                String mot = "";
                if (c.getTheme().getNom().equals("mf"))
                    mot = "dongeon";
                if (c.getTheme().getNom().equals("sf"))
                    mot = "vaisseau";
                System.out.println("Menu du jeu :\n[A] Accéder à l'inventaire\n[B]Entrer dans le " + mot + ".\n");
                if ("a".equalsIgnoreCase(rep)) {
                    return 1;
                }
                if ("b".equalsIgnoreCase(rep)) {
                    return 2;
                }
            }
        }
    }

    // Afficher

    public void afficherJoueur(Joueur j) {
        System.out.println(j);
    }

    public void afficherEssentiel(Joueur j) {
        System.out.println(j.getNom() + "\n" +
                "Vie : " + j.getVie() + "/" + j.getMAX_VIE() + "\n" +
                "Mana : " + j.getMana() + "/" + j.getMAX_MANA() + "\n");
    }

    public void afficherSalle(){

    }

    public void afficherInventaire(Joueur j) {
        System.out.println(j.getNom() + "\n" +
                "Équipement :\n" +
                "Arme : " + j.getInventaire().getEquipement("arme") + "\n" +
                "Tête : " + j.getInventaire().getEquipement("tete") + "\n" +
                "Torse : " + j.getInventaire().getEquipement("torse") + "\n" +
                "Jambes : " + j.getInventaire().getEquipement("jambes") + "\n" +
                "Pieds : " + j.getInventaire().getEquipement("pieds") + "\n" +
                "\nInventaire :\n" + j.getInventaire());
    }

    public void afficherInventaire(Salle s) {
        System.out.println(s.getLesItems());
    }

    public void afficherStatistiques(Joueur j) {
        System.out.println(j.getNom() + "\n" +
                "\nStatistiques :\n" +
                "Force : " + j.getForce() + "\n" +
                "Constitution : " + j.getConstitution() + "\n" +
                "Dextérité : " + j.getDexterite() + "\n" +
                "Intelligence : " + j.getIntelligence() + "\n" +
                "Capacité Magique : " + j.getCapacite() + "\n" +
                "Probabilité de toucher : " + (int) (((((double) j.getDexterite() / 10) + j.getInventaire().getEquipement("arme").getPrecision()) / 2) * 100) + "%");
    }
}
