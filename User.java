package models;


public class User {
    private String nom;
    private String prenom;
    private String idBadge;
    private Categorie categorie;

    public User(String nom, String prenom, String idBadge, Categorie categorie) {
        this.nom = nom;
        this.prenom = prenom;
        this.idBadge = idBadge;
        this.categorie = categorie;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIdBadge() {
        return idBadge;
    }

    public void setIdBadge(String idBadge) {
        this.idBadge = idBadge;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", idBadge='" + idBadge + '\'' +
                ", categorie=" + categorie +
                '}';
    }
}
