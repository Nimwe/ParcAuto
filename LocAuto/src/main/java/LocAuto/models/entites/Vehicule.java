package LocAuto.models.entites;

public abstract class Vehicule {
    protected String marque;
    protected String modele;

    public Vehicule(String marque, String modele) {
        this.marque = marque;
        this.modele = modele;
    }

    public abstract boolean demarrer();

    public abstract void arreter();

    public abstract void faireLePlein(float carburant);

    @Override
    public String toString() {
        return marque + " " + modele;
    }

}
