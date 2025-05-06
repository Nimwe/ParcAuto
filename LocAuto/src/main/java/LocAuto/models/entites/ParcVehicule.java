package LocAuto.models.entites;

import LocAuto.exceptions.PanneEssenceException;
import javax.swing.*;
import java.util.Random;

public class ParcVehicule {

    // Tu n'as pas instancié de Scooter ?
    private static final int nbVehicules = 7; // 4 voitures et 3 scooters
    private Vehicule[] vehicules; // tableau des véhicules

    // Constructor
    public ParcVehicule() {

        vehicules = new Vehicule[nbVehicules];

        // Voitures
        vehicules[0] = new Voiture("Opel", "Corsa", 46.0f);
        vehicules[1] = new Voiture("Ford", "Mustang", 61.0f);
        vehicules[2] = new Voiture("Subaru", "Impreza", 48.0f);
        vehicules[3] = new Voiture("Chevrolet", "Camaro", 72.0f);

        // Scooters qui deviennent des motos parce que j'y connais rien en scooters :)
        vehicules[4] = new Voiture("Honda", "CBR 1000", 16.1f);
        vehicules[5] = new Voiture("Yamaha", "1000 GSXR", 17.5f);
        vehicules[6] = new Voiture("Triumph ", "RS 765", 15.0f);
    }

    // Méthode pour contrôler les véhicules
    public void controlerVehicules() {
        Random rand = new Random();

        for (Vehicule vehicule : vehicules) {
            try {
                // Démarrer le véhicule
                vehicule.demarrer();
                // Faire tourner le moteur pour un trajet aléatoire entre 1 et 5 km
                float distance = rand.nextInt(5) + 1;
                JOptionPane.showMessageDialog(null,
                        "Le véhicule " + vehicule + " a parcouru " + distance + " km.");

                // Simuler une panne d'essence avec une probabilité de 50%
                if (rand.nextBoolean()) {
                    throw new PanneEssenceException("Panne d'essence simulée.");
                }
            } catch (PanneEssenceException e) {
                // En cas de panne, faire le plein avec un volume aléatoire entre 1 et 10 litres
                float litres = rand.nextInt(10) + 1;
                vehicule.faireLePlein(litres);
                JOptionPane.showMessageDialog(null, "Panne d'essence : " + e.getMessage() + "\n" +
                        "Ajout de " + litres + " litres de carburant.");
                // Redémarrer le véhicule
                vehicule.demarrer();
            } finally {
                // Afficher l'état final du véhicule
                JOptionPane.showMessageDialog(null,
                        "Etat final du véhicule " + vehicule.getClass().getSimpleName() + " : " + vehicule);
            }

        }
    }
}
