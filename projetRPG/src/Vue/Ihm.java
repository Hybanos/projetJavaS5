package Vue;

import Controleur.Controleur;

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
}
