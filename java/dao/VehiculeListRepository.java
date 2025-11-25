// dao/FichierListRepository.java
package dao;

import entity.Identifiable;
import java.util.*;

public class VehiculeListRepository<T extends Identifiable> implements VehiculeRepository<T> {
    private final List<T> elements = new ArrayList<>();

    @Override public void ajouter(T element) { elements.add(element); }
    @Override public List<T> lister() { return Collections.unmodifiableList(elements); }

    @Override public Optional<T> trouverParId(String id) {
        return elements.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    @Override public boolean modifier(String id, T nouveau) {
        Optional<T> existant = trouverParId(id);
        if (existant.isPresent()) {
            elements.remove(existant.get());
            elements.add(nouveau);
            return true;
        }
        return false;
    }

    @Override public boolean supprimer(String id) {
        return elements.removeIf(e -> e.getId().equals(id));
    }
}
