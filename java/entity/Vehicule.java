// entity/Vehicule.java
package entity;

public abstract class Vehicule implements Roulant, Identifiable {
    protected final String id;
    protected String couleur;
    protected String marque;
    protected String modele;
    protected int annee;
    protected String immatriculation;

    protected Vehicule(String id, String couleur, String marque, String modele,
                       int annee, String immatriculation) {
        this.id = id;
        this.couleur = couleur;
        this.marque = marque;
        this.modele = modele;
        this.annee = annee;
        this.immatriculation = immatriculation;
    }

    @Override public String getId() { return id; }

    @Override public void rouler() { System.out.println(modele + " roule."); }
    @Override public void arreter() { System.out.println(modele + " s'arrête."); }

    public String getImmatriculation() { return immatriculation; }
    public String getModele() { return modele; }
    public String getMarque() { return marque; }
    public String getCouleur() { return couleur; }
    public int getAnnee() { return annee; }
}
