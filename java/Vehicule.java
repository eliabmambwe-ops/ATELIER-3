public class Vehicule {
    protected String couleur;
    protected String marque;
    protected String modele;
    protected int annee;
    protected String immatriculation;

    public Vehicule(String couleur, String marque, String modele, int annee, String immatriculation) {
        this.couleur = couleur;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.immatriculation = immatriculation;
    }

    public Vehicule(){}

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
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
