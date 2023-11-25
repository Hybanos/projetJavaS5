package Modele.Theme;

import Modele.Item.Consommable.Buff;
import Modele.Item.Consommable.Debuff;
import Modele.Item.Consommable.Energie;
import Modele.Item.Consommable.Soin;
import Modele.Item.NonConsommable.Attaque.CorpsACorps;
import Modele.Item.NonConsommable.Attaque.Projectile;
import Modele.Item.NonConsommable.Protection.Armure;
import Modele.Item.NonConsommable.Protection.Bouclier;

import java.util.HashSet;
import java.util.Set;

public abstract class Theme {
    private Set<CorpsACorps> lesArmesCorpsACorps = new HashSet<>();
    private Set<Projectile> lesProjectiles = new HashSet<>();
    private Set<Bouclier> lesBoucliers = new HashSet<>();
    private Set<Armure> lesArmures = new HashSet<>();
    private Set<Buff> lesBuffs = new HashSet<>();
    private Set<Debuff> lesDebuffs = new HashSet<>();
    private Set<Energie> lesEnergies = new HashSet<>();
    private Set<Soin> lesSoins = new HashSet<>();

    //Ajouter un attribut pour le Donjon


    public Theme() {
        initialiser();
    }

    abstract void initialiser();
    abstract void initItems();
    abstract void initDonjon();
    abstract void initJoueur();
    abstract void initEnnemis();

    abstract void initNonConsommable();
    abstract void initConsommable();
    abstract void initAttaque();
    abstract void initProtection();


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
