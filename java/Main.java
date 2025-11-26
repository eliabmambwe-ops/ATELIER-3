import dao.VehiculeRepository;
import dao.VehiculeGsonRepository;
import entity.*;

import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    // On utilise l’interface pour rester indépendant du type de stockage
    private static final VehiculeRepository repo = new VehiculeGsonRepository("vehicules.json");

    public static void main(String[] args) {
        // Charger les véhicules existants depuis le fichier JSON
        List<Vehicule> vehiculesCharges = repo.charger();
        vehiculesCharges.forEach(repo::ajouter);

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Gestion Parc de Véhicules ---");
            System.out.println("1. Ajouter véhicule");
            System.out.println("2. Lister véhicules");
            System.out.println("3. Chercher par ID");
            System.out.println("4. Modifier véhicule (couleur)");
            System.out.println("5. Supprimer véhicule");
            System.out.println("6. Action polymorphique (démarrer/accélérer)");
            System.out.println("7. Sauvegarder dans JSON");
            System.out.println("0. Quitter");
            System.out.print("Choix: ");
            String choix = sc.nextLine();

            switch (choix) {
                case "1" -> ajouterVehicule(sc);
                case "2" -> repo.lister().forEach(v ->
                        System.out.printf("%s [%s] %s %s (%d) immat:%s couleur:%s%n",
                                v.getClass().getSimpleName(), v.getId(), v.getMarque(), v.getModele(),
                                v.getAnnee(), v.getImmatriculation(), v.getCouleur()));
                case "3" -> {
                    System.out.print("ID: "); String id = sc.nextLine();
                    var v = repo.trouverParId(id);
                    System.out.println(v.map(val -> val.getClass().getSimpleName() + " trouvé").orElse("Introuvable"));
                }
                case "4" -> {
                    System.out.print("ID: "); String id = sc.nextLine();
                    var opt = repo.trouverParId(id);
                    if (opt.isPresent()) {
                        Vehicule maj = opt.get();
                        System.out.print("Nouvelle couleur: "); String c = sc.nextLine();
                        maj.setCouleur(c);
                        System.out.println(repo.modifier(id, maj) ? "Modifié" : "Échec modification");
                    } else System.out.println("Introuvable");
                }
                case "5" -> {
                    System.out.print("ID: "); String id = sc.nextLine();
                    System.out.println(repo.supprimer(id) ? "Supprimé" : "Introuvable");
                }
                case "6" -> {
                    System.out.print("ID: "); String id = sc.nextLine();
                    var opt = repo.trouverParId(id);
                    if (opt.isPresent() && opt.get() instanceof Motorise m) {
                        m.demarrer(); m.accelerer(); m.freiner(); m.klaxonner(); m.arreter();
                    } else System.out.println("Ce véhicule n'est pas motorisé ou introuvable.");
                }
                case "7" -> repo.sauvegarder(repo.lister());
                case "0" -> {
                    // Sauvegarde automatique avant de quitter
                    repo.sauvegarder(repo.lister());
                    running = false;
                }
                default -> System.out.println("Choix invalide.");
            }
        }
        sc.close();
    }

    private static void ajouterVehicule(Scanner sc) {
        System.out.println("Type (moto, velo, camion, bus): ");
        String type = sc.nextLine().trim().toLowerCase();
        String id = UUID.randomUUID().toString();

        switch (type) {
            case "moto" -> {
                System.out.print("Couleur: "); String couleur = sc.nextLine();
                System.out.print("Marque: "); String marque = sc.nextLine();
                System.out.print("Modèle: "); String modele = sc.nextLine();
                System.out.print("Année: "); int annee = Integer.parseInt(sc.nextLine());
                System.out.print("Immatriculation: "); String imm = sc.nextLine();
                System.out.print("Cylindrée: "); int cyl = Integer.parseInt(sc.nextLine());
                System.out.print("Type: "); String tm = sc.nextLine();
                System.out.print("Poids: "); float p = Float.parseFloat(sc.nextLine());
                System.out.print("Kilométrage: "); int km = Integer.parseInt(sc.nextLine());
                System.out.print("Nombre de pneus: "); int np = Integer.parseInt(sc.nextLine());
                repo.ajouter(new Moto(id, couleur, marque, modele, annee, imm, cyl, tm, p, km, np));
            }
            case "velo" -> {
                System.out.print("Couleur: "); String couleur = sc.nextLine();
                System.out.print("Marque: "); String marque = sc.nextLine();
                System.out.print("Modèle: "); String modele = sc.nextLine();
                System.out.print("Année: "); int annee = Integer.parseInt(sc.nextLine());
                System.out.print("Type: "); String tv = sc.nextLine();
                repo.ajouter(new Velo(id, couleur, marque, modele, annee, tv));
            }
            case "camion" -> {
                System.out.print("Couleur: "); String couleur = sc.nextLine();
                System.out.print("Marque: "); String marque = sc.nextLine();
                System.out.print("Modèle: "); String modele = sc.nextLine();
                System.out.print("Année: "); int annee = Integer.parseInt(sc.nextLine());
                System.out.print("Immatriculation: "); String imm = sc.nextLine();
                System.out.print("Capacité charge (t): "); double cap = Double.parseDouble(sc.nextLine());
                repo.ajouter(new Camion(id, couleur, marque, modele, annee, imm, cap));
            }
            case "bus" -> {
                System.out.print("Couleur: "); String couleur = sc.nextLine();
                System.out.print("Marque: "); String marque = sc.nextLine();
                System.out.print("Modèle: "); String modele = sc.nextLine();
                System.out.print("Année: "); int annee = Integer.parseInt(sc.nextLine());
                System.out.print("Immatriculation: "); String imm = sc.nextLine();
                System.out.print("Vitesse max: "); int vmax = Integer.parseInt(sc.nextLine());
                System.out.print("État carrosserie: "); String etat = sc.nextLine();
                System.out.print("Carburant: "); String carb = sc.nextLine();
                System.out.print("Nombre portes: "); int portes = Integer.parseInt(sc.nextLine());
                System.out.print("Nombre places: "); int places = Integer.parseInt(sc.nextLine());
                repo.ajouter(new Bus(id, couleur, marque, modele, annee, imm, vmax, etat, carb, portes, places));
            }
            default -> System.out.println("Type inconnu.");
        }
    }
}
