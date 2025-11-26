package dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.*;

import java.io.*;
import java.util.*;

/**
 * Repository pour gérer la persistance des véhicules en JSON avec Gson.
 * Utilise RuntimeTypeAdapterFactory pour gérer le polymorphisme (Moto, Camion, Velo, Bus).
 */
public class VehiculeGsonRepository implements VehiculeRepository {
    private final String cheminFichier;
    private final Gson gson;
    private final List<Vehicule> vehicules = new ArrayList<>();

    public VehiculeGsonRepository(String cheminFichier) {
        this.cheminFichier = cheminFichier;

        // Adapter polymorphique
        RuntimeTypeAdapterFactory<Vehicule> typeFactory = RuntimeTypeAdapterFactory
                .of(Vehicule.class, "type")
                .registerSubtype(Moto.class, "Moto")
                .registerSubtype(Camion.class, "Camion")
                .registerSubtype(Velo.class, "Velo")
                .registerSubtype(Bus.class, "Bus");

        this.gson = new GsonBuilder()
                .registerTypeAdapterFactory(typeFactory)
                .setPrettyPrinting()
                .create();
    }

    // ------------------- CRUD -------------------

    @Override
    public void ajouter(Vehicule v) {
        vehicules.add(v);
    }

    @Override
    public List<Vehicule> lister() {
        return new ArrayList<>(vehicules);
    }

    @Override
    public Optional<Vehicule> trouverParId(String id) {
        return vehicules.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean supprimer(String id) {
        return vehicules.removeIf(v -> v.getId().equals(id));
    }

    @Override
    public boolean modifier(String id, Vehicule maj) {
        for (int i = 0; i < vehicules.size(); i++) {
            if (vehicules.get(i).getId().equals(id)) {
                vehicules.set(i, maj);
                return true;
            }
        }
        return false;
    }

    // ------------------- Persistance -------------------

    @Override
    public void sauvegarder(List<Vehicule> vehicules) {
        try (Writer writer = new FileWriter(cheminFichier)) {
            gson.toJson(vehicules, writer);
            System.out.println("✅ Sauvegarde réussie dans " + cheminFichier);
        } catch (IOException e) {
            System.err.println("❌ Erreur de sauvegarde : " + e.getMessage());
        }
    }

    @Override
    public List<Vehicule> charger() {
        File fichier = new File(cheminFichier);
        if (!fichier.exists()) {
            System.out.println("⚠️ Aucun fichier trouvé, retour d'une liste vide.");
            return new ArrayList<>();
        }

        try (Reader reader = new FileReader(fichier)) {
            Vehicule[] tableau = gson.fromJson(reader, Vehicule[].class);
            vehicules.clear();
            vehicules.addAll(Arrays.asList(tableau));
            return lister();
        } catch (IOException e) {
            System.err.println("❌ Erreur de chargement : " + e.getMessage());
            return new ArrayList<>();
        }
    }

}
