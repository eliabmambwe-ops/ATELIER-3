// dao/VehiculeRepository.java
package dao;

import entity.Vehicule;

import java.util.List;
import java.util.Optional;

/**
 * Interface générique pour gérer les opérations CRUD sur les véhicules,
 * ainsi que la persistance (sauvegarde/chargement).
 */
public interface VehiculeRepository {
    void ajouter(Vehicule v);
    List<Vehicule> lister();
    Optional<Vehicule> trouverParId(String id);
    boolean modifier(String id, Vehicule nouveau);
    boolean supprimer(String id);

    void sauvegarder(List<Vehicule> vehicules);
    List<Vehicule> charger();
}
