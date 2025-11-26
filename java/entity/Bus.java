// entity/Bus.java
package entity;

public class Bus extends Vehicule implements Motorise, TransportPassagers {
    private static long serialVersionUID = 1L;
    private final int vitesseMax;
    private final String etatCarrosserie;
    private final String carburant;
    private final int nombrePorte;
    private final int nbrePlace;

    public Bus(String id, String couleur, String marque, String modele, int annee, String immatriculation,
               int vitesseMax, String etatCarrosserie, String carburant, int nombrePorte, int nbrePlace) {
        super(id, couleur, marque, modele, annee, immatriculation);
        this.vitesseMax = vitesseMax;
        this.etatCarrosserie = etatCarrosserie;
        this.carburant = carburant;
        this.nombrePorte = nombrePorte;
        this.nbrePlace = nbrePlace;
    }

    public void ouvrirPorte() {
        System.out.println("Porte ouverte.");
    }

    public void ouvrirCoffre() {
        System.out.println("Coffre ouvert.");
    }

    public void eteindrePhare() {
        System.out.println("Phares éteints.");
    }

    @Override
    public void demarrer() {
        System.out.println("Bus démarre.");
    }

    @Override
    public void accelerer() {
        System.out.println("Bus accélère.");
    }

    @Override
    public void freiner() {
        System.out.println("Bus freine.");
    }

    @Override
    public void klaxonner() {
        System.out.println("Bus klaxonne.");
    }

    @Override
    public void arreter() {
        super.arreter();
    }

    @Override
    public int getNombrePlaces() {
        return nbrePlace;
    }

    @Override
    public void embarquerPassagers(int nombre) {
        System.out.printf("Embarquement de %d passagers.%n", nombre);
    }
}
