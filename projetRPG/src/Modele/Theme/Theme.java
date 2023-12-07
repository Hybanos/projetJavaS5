package Modele.Theme;

import Modele.Item.Consommable;
import Modele.Item.Equipements.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class Theme {
    protected Map<Integer, CorpsACorps> lesArmesCorpsACorps = new HashMap<>();
    protected Map<Integer, Projectile> lesProjectiles = new HashMap<>();
    protected Map<Integer, Magie> lesMagies = new HashMap<>();
    protected Map<Integer, Bouclier> lesBoucliers = new HashMap<>();
    protected Map<Integer, Armure> lesArmures = new HashMap<>();
    protected Map<Integer, Buff> lesBuffs = new HashMap<>();
    protected Map<Integer, Debuff> lesDebuffs = new HashMap<>();
    protected Map<Integer, Energie> lesEnergies = new HashMap<>();
    protected Map<Integer, Consommable> lesConsommables = new HashMap<>();
    protected Map<Integer, Soin> lesSoins = new HashMap<>();

    //Ajouter un attribut pour le Donjon


    public Theme() {
        initialiser();
    }

    protected abstract void initialiser();


    public Map<Integer, CorpsACorps> getLesArmesCorpsACorps() {
        return lesArmesCorpsACorps;
    }

    public void setLesArmesCorpsACorps(Map<Integer, CorpsACorps> lesArmesCorpsACorps) {
        this.lesArmesCorpsACorps = lesArmesCorpsACorps;
    }

    public Map<Integer, Projectile> getLesProjectiles() {
        return lesProjectiles;
    }

    public void setLesProjectiles(Map<Integer, Projectile> lesProjectiles) {
        this.lesProjectiles = lesProjectiles;
    }

    public Map<Integer,Bouclier> getLesBoucliers() {
        return lesBoucliers;
    }

    public void setLesBoucliers(Map<Integer,Bouclier> lesBoucliers) {
        this.lesBoucliers = lesBoucliers;
    }

    public Map<Integer,Armure> getLesArmures() {
        return lesArmures;
    }

    public void setLesArmures(Map<Integer,Armure> lesArmures) {
        this.lesArmures = lesArmures;
    }

    public Map<Integer,Buff> getLesBuffs() {
        return lesBuffs;
    }

    public void setLesBuffs(Map<Integer,Buff> lesBuffs) {
        this.lesBuffs = lesBuffs;
    }

    public Map<Integer,Debuff> getLesDebuffs() {
        return lesDebuffs;
    }

    public void setLesDebuffs(Map<Integer,Debuff> lesDebuffs) {
        this.lesDebuffs = lesDebuffs;
    }

    public Map<Integer,Energie> getLesEnergies() {
        return lesEnergies;
    }

    public void setLesEnergies(Map<Integer,Energie> lesEnergies) {
        this.lesEnergies = lesEnergies;
    }

    public Map<Integer,Soin> getLesSoins() {
        return lesSoins;
    }

    public void setLesSoins(Map<Integer,Soin> lesSoins) {
        this.lesSoins = lesSoins;
    }
}
