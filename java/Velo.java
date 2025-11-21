public class Velo {
    private String type;
    private String couleur;
    private String marque;
    private String modele;
    private int annee;

    public Velo(String type, String couleur, String marque, String modele, int annee) {
        this.type = type;
        this.couleur = couleur;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

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
}
