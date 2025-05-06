package LocAuto.models.entites;

public class Moteur {

    private float volumeReservoir;
    private float volumeTotal;
    private boolean demarre;

    // Construtor 1
    public Moteur(float volumeReservoir, float volumeTotal, boolean demarre) {
        this.volumeReservoir = volumeReservoir;
        this.volumeTotal = volumeTotal;
        this.demarre = demarre;
    }

    // Constructor 2
    public Moteur(float volumeInitial) {
        this.volumeReservoir = volumeInitial;
        this.volumeTotal = volumeInitial;
        this.demarre = false;
    }

    // Getter - Pas de Setter à cause de l'encapsulation, pour éviter que d'autres
    // class puisse modifier ces variables
    public float getVolumeReservoir() {
        return volumeReservoir;
    }

    public float getVolumeTotal() {
        return volumeTotal;
    }

    public boolean isDemarre() {
        return demarre;
    }

    // Fonctions

    /**
     * Vérifie si il y a assez de carburant pour démarrer
     * 
     * @return True si il y en a assez et false si il n'y en a pas assez et que le
     *         véhicule ne peut pas démarrer
     * 
     */
    public boolean demarrer() {
        if (volumeReservoir >= 0.1f) {
            volumeReservoir -= 0.1f;
            demarre = true;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Détermine la consommation de carburant pour un trajet
     * 
     * @param consommation et volumeReservoir pour évaluer si le trajet pourra être
     *                     fait entierement ou si on va tomber en panne d'essence
     * @return le vrai volume de carburant utilisé
     */
    public float utiliser(float consommation) {
        float carburantConsomme = Math.min(consommation, volumeReservoir); // Math.min => Permet d'obtenir le plus petit
                                                                           // entre 2 nombres
        volumeReservoir -= carburantConsomme;
        return carburantConsomme;
    }

    /**
     * Simule un plein de carburant
     * 
     * @param carburant
     *                  Renvoie le carburant ajouté lors de ce plein + le total de
     *                  litres de carburant ajoutés depuis le début cumulé sur toute
     *                  la vie du moteur
     */
    public void faireLePlein(float carburant) {
        volumeReservoir += carburant;
        volumeTotal += carburant;
    }

    // Arreter la voiture
    public void arreter() {
        demarre = false;
    }

    @Override
    public String toString() {
        return "Carburant restant : " + volumeReservoir + "L. Carburant total mis dans ce véhicule :" + volumeTotal
                + "L. Demarre=" + demarre
                + ".";
    }

}
