public class Camion {
    private double capacitecharge;
    private  String marque;
    private String model;
    private int annee;
    private String immatriculation;

    public Camion(double capacitecharge, String marque, String model, int annee, String immatriculation) {
        this.capacitecharge = capacitecharge;
        this.marque = marque;
        this.model = model;
        this.annee = annee;
        this.immatriculation = immatriculation;
    }

    public double getCapacitecharge() {
        return capacitecharge;
    }

    public void setCapacitecharge(double capacitecharge) {
        this.capacitecharge = capacitecharge;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }
}