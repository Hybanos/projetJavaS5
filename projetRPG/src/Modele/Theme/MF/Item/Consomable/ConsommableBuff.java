package Modele.Theme.MF.Item.Consomable;

import Modele.Item.Consommable;

public class ConsommableBuff extends Consommable {

    int force;
    int constitution;
    int dexterite;
    int intelligence;
    int endurence;
    int tours; // durée du buff


    public ConsommableBuff(String nom, String description, int vie, int mana) {
        super(nom, description, vie, mana);
    }

    public ConsommableBuff(String nom, String description, int vie, int mana, int force, int constitution, int dexterite, int intelligence, int endurence, int tours) {
        this(nom, description, vie, mana);
        this.force = force;
        this.constitution = constitution;
        this.dexterite = dexterite;
        this.intelligence = intelligence;
        this.endurence = endurence;
        this.tours = tours;
    }
}
