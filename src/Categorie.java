
public class Categorie {
    private String nom;
    private String creneauHoraire;
    private String joursAutorises;

    public Categorie(String nom, String creneauHoraire, String joursAutorises) {
        this.nom = nom;
        this.creneauHoraire = creneauHoraire;
        this.joursAutorises = joursAutorises;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCreneauHoraire() {
        return creneauHoraire;
    }

    public void setCreneauHoraire(String creneauHoraire) {
        this.creneauHoraire = creneauHoraire;
    }

    public String getJoursAutorises() {
        return joursAutorises;
    }

    public void setJoursAutorises(String joursAutorises) {
        this.joursAutorises = joursAutorises;
    }

    @Override
    public String toString() {
        return "Categorie{" +
                "nom='" + nom + '\'' +
                ", creneauHoraire='" + creneauHoraire + '\'' +
                ", joursAutorises='" + joursAutorises + '\'' +
                '}';
    }
}
