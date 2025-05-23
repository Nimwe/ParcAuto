package LocAuto.models.entites;

import LocAuto.exceptions.PanneEssenceException;

public class Scooter extends VehiculeAMoteur {

    public Scooter(String marque, String modele, float carburantInitial) {
        super(marque, modele, carburantInitial);
    }

    public void rouler(float consommation) throws PanneEssenceException {
        // Vérifie si le moteur est démarré. Si pas démarré, essaie de le démarré. Si
        // pas assez de carburant il ne se passe rien
        if (!moteur.isDemarre()) {
            if (!demarrer()) {
                throw new PanneEssenceException("Il n'y a pas assez de carburant pour démarrer");
            }
        }
        // Utilisation du carburant
        float carburantConsomme = moteur.utiliser(consommation);
        if (carburantConsomme == 0) {
            throw new PanneEssenceException(" Panne de carburant pendantle trajet");
        }
    }
}
