// entity/Camion.java
package entity;

public class Camion extends Vehicule implements Motorise {
    private final double capaciteCharge;

    public Camion(String id, String couleur, String marque, String modele, int annee,
                  String immatriculation, double capaciteCharge) {
        super(id, couleur, marque, modele, annee, immatriculation);
        this.capaciteCharge = capaciteCharge;
    }

    public void clignoter() { System.out.println("Camion clignote."); }
    public void verrouillerPorte() { System.out.println("Portes verrouillées."); }
    public void allumerPhare() { System.out.println("Phares allumés."); }
    public void charger() { System.out.println("Chargement en cours."); }
    public void allumerClimatisation() { System.out.println("Climatisation activée."); }

    @Override public void demarrer() { System.out.println("Camion démarre."); }
    @Override public void accelerer() { System.out.println("Camion accélère."); }
    @Override public void freiner() { System.out.println("Camion freine."); }
    @Override public void klaxonner() { System.out.println("Camion klaxonne."); }
    @Override public void arreter() { super.arreter(); }
}
