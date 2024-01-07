package Modele.Personnage;

public class Ennemi extends Personnage {

    private int attaquePref;

    public Ennemi(String nom, int force, int constitution, int dexterite, int intelligence, int capacite, int attaquePref) {
        super(nom, force, constitution, dexterite, intelligence, capacite);
        this.attaquePref = attaquePref;
    }

    public Ennemi(Ennemi e) {
        super(e.getNom(), e.getVie(), e.getMAX_VIE(), e.getMana(), e.getMAX_MANA(), e.getForce(), e.getConstitution(), e.getDexterite(), e.getIntelligence(), e.getCapacite());
        attaquePref = e.attaquePref;
    }

    /**
     * Méthode qui renvoie un booléen en fonction de si le coup touche
     *
     * @return true si le coup touche, false sinon
     */
    @Override
    public boolean coupTouche() {
        double probabilite = (((double) this.getDexterite() / 10)) / 2;
        //par exemple, le joueur a 7 de dextérité et une arme à 80% de précision, il a donc 0.70 * 0.80 = 0.56 -> 56% de chances de toucher (pas clair, à voir le calcul)
        double random = Math.random();
        return random <= probabilite;
    }

    /**
     * Méthode qui attaque avec l'arme sur l'adversaire
     *
     * @param adversaire adversaire à envoyer l'attaque
     * @return les dégats que le joueur adverse subit
     */
    @Override
    public int attaquerArme(Personnage adversaire) {
        int degats = 0;
        if (this.coupTouche()) {
            degats = this.getForce();
        }
        return adversaire.recevoirCoup(degats);
    }

    /**
     * Permet de choisir le type d'attaque d'un ennemi
     *
     * @param j personnage a attaquer
     * @return les dégâts reçus par le personnage
     */
    public int attaquer(Personnage j) {
        if (attaquePref == 1) {
            return attaquerArme(j);
        }
        if (attaquePref == 2) {
            return attaquerSort(j);
        }
        return 0;
    }

    /**
     * Permet de recevoir un coup
     *
     * @param degats les dégâts reçus
     * @return les dégâts réels (ici, les mêmes mais c'est différent dans le joueur)
     */
    @Override
    public int recevoirCoup(int degats) {
        if (degats > 0) {
            setVie(getVie() - degats);
        }
        return degats;
    }

    @Override
    public String toString() {
        return this.getNom() + " | " + this.getVie() + "/" + this.getMAX_VIE();
    }

    @Override
    public ClassePersonnage getClasse() {
        return null;
    }

    public Ennemi copy() {
        return new Ennemi(this);
    }
}
