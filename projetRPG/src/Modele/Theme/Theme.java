package Modele.Theme;

import Modele.Item.Consommable;
import Modele.Item.Equipements.CorpsACorps;
import Modele.Item.Equipements.Magie;
import Modele.Item.Equipements.Projectile;

import java.util.HashSet;
import java.util.Set;

public abstract class Theme {
    protected Set<CorpsACorps> lesArmesCorpsACorps = new HashSet<>();
    protected Set<Projectile> lesProjectiles = new HashSet<>();
    protected Set<Magie> lesMagies = new HashSet<>();
    protected Set<Bouclier> lesBoucliers = new HashSet<>();
    protected Set<Armure> lesArmures = new HashSet<>();
    protected Set<Buff> lesBuffs = new HashSet<>();
    protected Set<Debuff> lesDebuffs = new HashSet<>();
    protected Set<Energie> lesEnergies = new HashSet<>();
    protected Set<Consommable> lesConsommables = new HashSet<>();

    //Ajouter un attribut pour le Donjon


    public Theme() {
        initialiser();
    }

    protected abstract void initialiser();


    public Set<CorpsACorps> getLesArmesCorpsACorps() {
        return lesArmesCorpsACorps;
    }

    public void setLesArmesCorpsACorps(Set<CorpsACorps> lesArmesCorpsACorps) {
        this.lesArmesCorpsACorps = lesArmesCorpsACorps;
    }

    public Set<Projectile> getLesProjectiles() {
        return lesProjectiles;
    }

    public void setLesProjectiles(Set<Projectile> lesProjectiles) {
        this.lesProjectiles = lesProjectiles;
    }

    public Set<Bouclier> getLesBoucliers() {
        return lesBoucliers;
    }

    public void setLesBoucliers(Set<Bouclier> lesBoucliers) {
        this.lesBoucliers = lesBoucliers;
    }

    public Set<Armure> getLesArmures() {
        return lesArmures;
    }

    public void setLesArmures(Set<Armure> lesArmures) {
        this.lesArmures = lesArmures;
    }

    public Set<Buff> getLesBuffs() {
        return lesBuffs;
    }

    public void setLesBuffs(Set<Buff> lesBuffs) {
        this.lesBuffs = lesBuffs;
    }

    public Set<Debuff> getLesDebuffs() {
        return lesDebuffs;
    }

    public void setLesDebuffs(Set<Debuff> lesDebuffs) {
        this.lesDebuffs = lesDebuffs;
    }

    public Set<Energie> getLesEnergies() {
        return lesEnergies;
    }

    public void setLesEnergies(Set<Energie> lesEnergies) {
        this.lesEnergies = lesEnergies;
    }

    public Set<Soin> getLesSoins() {
        return lesSoins;
    }

    public void setLesSoins(Set<Soin> lesSoins) {
        this.lesSoins = lesSoins;
    }
}
