// dao/FichierRepository.java
package dao;

import java.util.List;
import java.util.Optional;

public interface VehiculeRepository<T> {
    void ajouter(T element);
    List<T> lister();
    Optional<T> trouverParId(String id);
    boolean modifier(String id, T nouveau);
    boolean supprimer(String id);
}
