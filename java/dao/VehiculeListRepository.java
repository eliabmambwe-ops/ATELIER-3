package dao;

import entity.Vehicule;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Repository en mémoire pour gérer les véhicules (sans persistance).
 */
public class VehiculeListRepository implements VehiculeRepository {
    private final List<Vehicule> vehicules = new ArrayList<>();

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
    public boolean modifier(String id, Vehicule nouveau) {
        for (int i = 0; i < vehicules.size(); i++) {
            if (vehicules.get(i).getId().equals(id)) {
                vehicules.set(i, nouveau);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean supprimer(String id) {
        return vehicules.removeIf(v -> v.getId().equals(id));
    }

    @Override
    public void sauvegarder(List<Vehicule> vehicules) {
        // Rien à faire ici : pas de persistance en mémoire
        System.out.println("⚠️ Sauvegarde ignorée (repository en mémoire).");
    }

    @Override
    public List<Vehicule> charger() {
        // Retourne simplement la liste actuelle
        return lister();
    }
}
