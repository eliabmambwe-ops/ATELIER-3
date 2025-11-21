public class Moto {
    private int cylindree;
    private String type;
    private float poids;
    private int kilometrage;
    private int nbrepneu;

    public Moto(int cylindree, String type, float poids, int kilometrage, int nbrepneu) {
        this.cylindree = cylindree;
        this.type = type;
        this.poids = poids;
        this.kilometrage = kilometrage;
        this.nbrepneu = nbrepneu;
    }

    public int getCylindree() {
        return cylindree;
    }

    public void setCylindree(int cylindree) {
        this.cylindree = cylindree;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public int getNbrepneu() {
        return nbrepneu;
    }

    public void setNbrepneu(int nbrepneu) {
        this.nbrepneu = nbrepneu;
    }
}
