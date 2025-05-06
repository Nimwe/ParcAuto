package LocAuto;

import LocAuto.models.entites.Voiture;
import LocAuto.models.entites.Scooter;
// import LocAuto.models.entites.VehiculeAMoteur;
import LocAuto.exceptions.PanneEssenceException;
import javax.swing.JOptionPane;
import LocAuto.models.entites.ParcVehicule;

public class App {

    // ✅ 👍 Good Job
    public static void main(String[] args) {

        // Création du parc de véhicules
        ParcVehicule parc = new ParcVehicule();
        // Contrôler les véhicules du parc
        parc.controlerVehicules();

        // Création d'une Citroën C5 avec 40L de carburant
        Voiture C5 = new Voiture("Citroën", "C5", 40.0f);

        // Initialisation du compteur de carburant total versé
        float totalCarburantVerse = 0.0f;

        for (int i = 1; i <= 6; i++) {
            try {
                // Tentative de rouler pendant 10L
                C5.rouler(10.0f);
                JOptionPane.showMessageDialog(null, "Trajet " + i + " effectué avec succès.");
            } catch (PanneEssenceException e) {
                // Gestion de la panne d'essence
                JOptionPane.showMessageDialog(null, "Panne d'essence lors du trajet " + i + ": " + e.getMessage());

                // Demande du nombre de litres à ajouter
                String input = JOptionPane.showInputDialog(null, "Combien de litres souhaitez-vous ajouter ?",
                        "Faire le plein", JOptionPane.QUESTION_MESSAGE);
                if (input != null && !input.isEmpty()) {
                    try {
                        // Conversion de la chaîne en float
                        float litres = Float.parseFloat(input);
                        // Ajout du carburant
                        C5.faireLePlein(litres);
                        // Mise à jour du compteur
                        totalCarburantVerse += litres;
                        // Redémarrage du moteur
                        C5.demarrer();
                        JOptionPane.showMessageDialog(null, "Plein effectué. Le moteur a redémarré.");
                        // Reprise du trajet
                        C5.rouler(10.0f);
                        JOptionPane.showMessageDialog(null, "Le trajet " + i + " a été repris avec succès.");
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Entrée invalide. Veuillez entrer un nombre valide.");
                    } catch (PanneEssenceException ex) {
                        JOptionPane.showMessageDialog(null, "Impossible de redémarrer : " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Aucun carburant ajouté. Le trajet ne peut pas être repris.");
                }
            }

        }

        // Affichage du total de carburant versé
        JOptionPane.showMessageDialog(null, "Total de carburant : " + totalCarburantVerse + " litres.");

        /************************************************************************************************************************************************ */
        // Création d'un scooter Yamaha X-MAX avec 20L de carburant
        Scooter XMax = new Scooter("Yamaha", "X-Max", 20.0f);

        // Affichage de l'état initial
        JOptionPane.showMessageDialog(null, "Etat initial du scooter : " + XMax);

        // Tentative de démarrage du scooter
        JOptionPane.showMessageDialog(null, "\nTentative de démarrage du scooter : ");
        if (XMax.demarrer()) {
            JOptionPane.showMessageDialog(null, "Le scooter a démarré " + XMax);
        } else {
            JOptionPane.showMessageDialog(null, "Le scooter n'a pas démarré " + XMax);
        }

        // Tentative de rouler
        try {
            XMax.rouler(20.0f);
            JOptionPane.showMessageDialog(null, "Le scooter a roulé pour 20 L " + XMax);
        } catch (PanneEssenceException e) {
            JOptionPane.showMessageDialog(null, "Panne de carburant : " + e.getMessage());

            String input = JOptionPane.showInputDialog(null, "Combien de litres souhaitez-vous ajouter ?",
                    "Faire le plein ?", JOptionPane.QUESTION_MESSAGE);
            if (input != null && !input.isEmpty()) {
                try {
                    float litres = Float.parseFloat(input); // Conversion en float
                    XMax.faireLePlein(litres); // Faire le plein
                    XMax.demarrer(); // Redémarrer le scooter
                    JOptionPane.showMessageDialog(null, "Le plein est effectué. Le moteur a redémarré.");
                    XMax.rouler(20.0f);
                    JOptionPane.showMessageDialog(null, "Le trajet a été effectué avec succès " + XMax);
                } catch (NumberFormatException nbEx) {
                    JOptionPane.showMessageDialog(null, "Entrée invalide, veuillez saisir un chiffre valide.");
                } catch (PanneEssenceException essEx) {
                    JOptionPane.showMessageDialog(null, "Impossible de redémarrer : " + essEx.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Aucun carburant ajouté. Le trajet ne peut pas reprendre.");
            }
            main(args);
        }

        // Affichage de l'état final après le trajet
        JOptionPane.showMessageDialog(null, "Etat après trajet : " + XMax);
    }
}

/*
 * // Avec boites de dialogue
 * // Création d'une voiture avec un volume de carburant initial de 40 Litre
 * Voiture laguna = new Voiture("Renault", "Laguna \n", 30.0f);
 * 
 * // Etat initial de la voiture
 * JOptionPane.showMessageDialog(null, "Etat initial de la voiture : \n" +
 * laguna);
 * 
 * // Démarrer la voiture
 * if (laguna.demarrer()) {
 * JOptionPane.showMessageDialog(null, "La voiture a démarré.");
 * } else {
 * JOptionPane.showMessageDialog(null, "La voiture n'a pas démarré.");
 * }
 * 
 * // Etat après démarrage
 * JOptionPane.showMessageDialog(null, "\n Etat après démarrage : " + laguna);
 * 
 * // Rouler
 * try {
 * laguna.rouler(20.0f);
 * JOptionPane.showMessageDialog(null, "La voiture a roulé pour 20 L" + laguna);
 * } catch (PanneEssenceException e) {
 * JOptionPane.showMessageDialog(null, "Panne de carburant : " +
 * e.getMessage());
 * 
 * String input = JOptionPane.showInputDialog(null,
 * "Combien de litres souhaitez-vous ajouter ?",
 * "Faire le plein ?", JOptionPane.QUESTION_MESSAGE);
 * if (input != null && input.isEmpty()) {
 * try {
 * float litres = Float.parseFloat(input); // Conversion de la string en float
 * laguna.faireLePlein(litres);
 * laguna.demarrer();
 * JOptionPane.showMessageDialog(null,
 * "Le plein est effectué. Le moteur a redémarré");
 * laguna.rouler(20.0f);
 * JOptionPane.showMessageDialog(null, "Le trajet a été effectué avec succés");
 * } catch (NumberFormatException nbEx) {
 * JOptionPane.showMessageDialog(null,
 * "Entrée invalide, veuillez saisir un chiffre valide.");
 * } catch (PanneEssenceException essEx) {
 * JOptionPane.showMessageDialog(null, "Impossible de redémarrer" +
 * essEx.getMessage());
 * }
 * } else {
 * JOptionPane.showMessageDialog(null,
 * "Aucun carburant ajouté. Le trajet ne peut pas reprendre");
 * }
 * }
 * 
 * // Etat après le trajet
 * JOptionPane.showMessageDialog(null, "Etat après le trajet \n" + laguna);
 * 
 * // Faire le plein
 * laguna.faireLePlein(20.0f); // AJout de 20L de carburant
 * JOptionPane.showMessageDialog(null, "Plein effectué avec 20 L");
 * 
 * // Afficher état après le plein
 * JOptionPane.showMessageDialog(null, " Niveau de carburant après le plein : "
 * + laguna);
 */
/*************************************************************************************************************************************************************** */
/*
 * // Création d'un scooter avec 20 L de carburant initial
 * Scooter XMax = new Scooter("Yamaha", "X-Max", 20.0f);
 * 
 * JOptionPane.showMessageDialog(null, "Etat initial du scooter : " + XMax);
 * 
 * JOptionPane.showMessageDialog(null,
 * "\n Tentative de démarrage du scooter : ");
 * if (XMax.demarrer()) {
 * JOptionPane.showMessageDialog(null, "Le scooter a démarré" + XMax);
 * } else {
 * JOptionPane.showMessageDialog(null, "Le scooter n'a pas démarré" + XMax);
 * }
 * 
 * try {
 * XMax.rouler(20.0f);
 * JOptionPane.showMessageDialog(null, "Le scouter a roulé pour 10 L" + XMax);
 * } catch (PanneEssenceException e) {
 * JOptionPane.showMessageDialog(null, "Panne de carburant : " +
 * e.getMessage());
 * 
 * String input = JOptionPane.showInputDialog(null,
 * "Combien de litres souhaitez-vous ajouter ?",
 * "Faire le plein ?", JOptionPane.QUESTION_MESSAGE);
 * if (input != null && input.isEmpty()) {
 * try {
 * float litres = Float.parseFloat(input); // Conversion de la string en float
 * XMax.faireLePlein(litres);
 * XMax.demarrer();
 * JOptionPane.showMessageDialog(null,
 * "Le plein est effectué. Le moteur a redémarré");
 * XMax.rouler(20.0f);
 * JOptionPane.showMessageDialog(null, "Le trajet a été effectué avec succés");
 * } catch (NumberFormatException nbEx) {
 * JOptionPane.showMessageDialog(null,
 * "Entrée invalide, veuillez saisir un chiffre valide.");
 * } catch (PanneEssenceException essEx) {
 * JOptionPane.showMessageDialog(null, "Impossible de redémarrer" +
 * essEx.getMessage());
 * }
 * } else {
 * JOptionPane.showMessageDialog(null,
 * "Aucun carburant ajouté. Le trajet ne peut pas reprendre");
 * }
 * }
 * JOptionPane.showMessageDialog(null, "Etat après trajet" + XMax);
 */
/*************************************************************************************************************************************************************** */
/*
 * Sans boites de dialogues
 * 
 * System.out.println("Laguna \n");
 * // Création d'une voiture avec un volume de carburant initial de 40 Litre
 * Voiture laguna = new Voiture("Renault", "Laguna \n", 30.0f);
 * 
 * // Etat initial de la voiture
 * System.out.println("Etat initial de la voiture : ");
 * System.out.println(laguna);
 * 
 * // Démarrer la voiture
 * System.out.println("Esssayer de démarrer la voiture");
 * if (laguna.demarrer()) {
 * System.out.println("La voiture a démarré.");
 * } else {
 * System.out.println("La voiture n'a pas démarré.");
 * }
 * 
 * // Etat après démarrage
 * System.out.println("\n Etat après démarrage : ");
 * System.out.println(laguna);
 * 
 * // Rouler
 * System.out.println("\n Essayer de rouler avec la voiture ");
 * laguna.rouler(25.0f);
 * 
 * // Etat après le trajet
 * System.out.println("\n Etat après le trajet : ");
 * System.out.println((laguna));
 * 
 * // Faire le plein
 * System.out.println("\n Faire le plein de carburant");
 * laguna.faireLePlein(20.0f); // AJout de 20L de carburant
 * 
 * // Afficher état après le plein
 * System.out.println("\n Niveau de carburant après le plein");
 * System.out.println(laguna);
 * 
 * System.out.println("\n X-Max \n");
 * // Création d'un scooter avec 20 L de carburant initial
 * Scooter XMax = new Scooter("Yamaha", "X-Max", 20.0f);
 * 
 * System.out.println("Etat initial du scooter : ");
 * System.out.println(XMax);
 * 
 * System.out.println("\n Tentative de démarrage du scooter : ");
 * if (XMax.demarrer()) {
 * System.out.println("Le scooter a démarré");
 * } else {
 * System.out.println("Le scooter n'a pas démarré");
 * }
 * 
 * System.out.println("\n Faire un trajet de 5L");
 * XMax.rouler(5.0f);
 * 
 * System.out.println("Etat après trajet");
 * System.out.println(XMax);
 * 
 */
