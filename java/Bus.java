public class Bus {
    private int vitessemax ;
    private String etatcarroserie;
    private String carburant;
    private int nbreporte;
    private int nbreplace;

    public Bus(int vitessemax, String etatcarroserie, String carburant, int nbreporte, int nbreplace) {
        this.vitessemax = vitessemax;
        this.etatcarroserie = etatcarroserie;
        this.carburant = carburant;
        this.nbreporte = nbreporte;
        this.nbreplace = nbreplace;
    }

    public int getVitessemax() {
        return vitessemax;
    }

    public void setVitessemax(int vitessemax) {
        this.vitessemax = vitessemax;
    }

    public String getEtatcarroserie() {
        return etatcarroserie;
    }

    public void setEtatcarroserie(String etatcarroserie) {
        this.etatcarroserie = etatcarroserie;
    }

    public String getCarburant() {
        return carburant;
    }

    public void setCarburant(String carburant) {
        this.carburant = carburant;
    }

    public int getNbreporte() {
        return nbreporte;
    }

    public void setNbreporte(int nbreporte) {
        this.nbreporte = nbreporte;
    }

    public int getNbreplace() {
        return nbreplace;
    }

    public void setNbreplace(int nbreplace) {
        this.nbreplace = nbreplace;
    }
    

}
