// entity/Velo.java
package entity;

public class Velo extends Vehicule {
    private final String type;

    public Velo(String id, String couleur, String marque, String modele, int annee, String type) {
        super(id, couleur, marque, modele, annee, "N/A");
        this.type = type;
    }

    public void pedaler() { System.out.println("Vélo pédale."); }
    public void changerVitesse() { System.out.println("Vélo change de vitesse."); }
    public void gonflerPneus() { System.out.println("Gonflage des pneus."); }
    public void graisserChaine() { System.out.println("Graissage de la chaîne."); }
}
