package models;

public class Admin {
	
	    private String nom;
	    private String prenom;
	    private String identifiant;

	    public Admin(String nom, String prenom, String identifiant) {
	        this.nom = nom;
	        this.prenom = prenom;
	        this.identifiant = identifiant;
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

	    public String getIdentifiant() {
	        return identifiant;
	    }

	    public void setIdentifiant(String identifiant) {
	        this.identifiant = identifiant;
	    }

	    @Override
	    public String toString() {
	        return "Administrateur{" +
	                "nom='" + nom + '\'' +
	                ", prenom='" + prenom + '\'' +
	                ", identifiant='" + identifiant + '\'' +
	                '}';
	    }
	

}
