package LocAuto.models.entites;

public abstract class VehiculeAMoteur extends Vehicule {

    protected Moteur moteur;

    // Constructor
    public VehiculeAMoteur(String marque, String modele, float carburantInitial) {
        super(marque, modele);
        this.moteur = new Moteur(carburantInitial);
    }

    // Getter
    public Moteur getMoteur() {
        return moteur;
    }

    // Fonctions
    @Override
    public boolean demarrer() {
        return moteur.demarrer();
    }

    @Override
    public void arreter() {
        moteur.arreter();
    }

    @Override
    public void faireLePlein(float carburant) {
        arreter();
        moteur.faireLePlein(carburant);
        demarrer();
    }

    @Override
    public String toString() {
        return super.toString() + " " + moteur.toString();
    }

}
