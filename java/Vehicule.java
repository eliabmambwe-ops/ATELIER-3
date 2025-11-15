public class Vehicule {
    private String couleur;
    private String marque;
    private String modele;
    private int annee;
    private String immatriculation;

    public Vehicule(String couleur, String marque,String modele,int annee, String immatriculation)  {
        this.couleur = couleur;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.immatriculation = immatriculation;

    }
    public Vehicule(){}

    public void setcouleur(String c) {
        this.couleur = c;
    }
    public void setmarque(String m) {
        this.marque = m;
    }
    public void setmodele(String m) {
        this.modele = m;
    }
    public void setannee(int a) {
        this.annee = a;
    }
    public void setimmatriculation(String im) {
        this.immatriculation = im;
    }
    public String getcouleur() {
        return couleur;
    }
    public String getmarque() {
        return marque;
    }
    public String getmodele() {
        return modele;
    }
    public int getannee() {
        return annee;
    }
    public String getimmatriculation() {
        return immatriculation;
    }

}
