// entity/Moto.java
package entity;

public class Moto extends Vehicule implements Motorise {
    private final int cylindree;
    private final String type;
    private final float poids;
    private final int kilometrage;
    private final int nbrePneu;

    public Moto(String id, String couleur, String marque, String modele, int annee, String immatriculation,
                int cylindree, String type, float poids, int kilometrage, int nbrePneu) {
        super(id, couleur, marque, modele, annee, immatriculation);
        this.cylindree = cylindree;
        this.type = type;
        this.poids = poids;
        this.kilometrage = kilometrage;
        this.nbrePneu = nbrePneu;
    }

    @Override public void demarrer() { System.out.println("Moto démarre."); }
    @Override public void accelerer() { System.out.println("Moto accélère."); }
    @Override public void freiner() { System.out.println("Moto freine."); }
    @Override public void klaxonner() { System.out.println("Moto klaxonne."); }
    @Override public void arreter() { super.arreter(); }
}
