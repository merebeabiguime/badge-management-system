import java.util.ArrayList;
import java.util.List;



public class Admin {

	    private String nom;
	    private String prenom;
	    private String identifiant;
	    private ArrayList<User> users;

	    public Admin(String nom, String prenom, String identifiant) {
	        this.nom = nom;
	        this.prenom = prenom;
	        this.identifiant = identifiant;
	        this.users=new ArrayList<>();
	    }
	    public void creerUtilisateur(String nom, String prenom, String idBadge, Categorie categorie) {
	        User nouvelUtilisateur = new User(nom, prenom, idBadge, categorie);
	        users.add(nouvelUtilisateur);
	        System.out.println("Nouvel utilisateur créé : " + nouvelUtilisateur);
	    }

	    public void modifierUtilisateur(User utilisateur, String nouveauNom, String nouveauPrenom, String nouvelIdBadge, Categorie nouvelleCategorie) {
	        utilisateur.setNom(nouveauNom);
	        utilisateur.setPrenom(nouveauPrenom);
	        utilisateur.setIdBadge(nouvelIdBadge);
	        utilisateur.setCategorie(nouvelleCategorie);
	        System.out.println("Utilisateur modifié : " + utilisateur);
	    }

	    // Méthode pour afficher tous les utilisateurs
	    public void afficherUtilisateurs() {
	        System.out.println("Liste des utilisateurs :");
	        for (User user : users) {
	            System.out.println(user);
	        }
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

	 
	        public static void main(String[] args) {
	            // Création d'un administrateur
	            Admin admin1 = new Admin("Admin", "Super", "admin001");

	            // Création de catégories
	            Categorie categorie1 = new Categorie("Employé", "8h00 - 17h00", "Lundi-Vendredi");
	            Categorie categorie2 = new Categorie("Visiteur", "10h00 - 16h00", "Lundi-Mercredi");

	            // Création d'utilisateurs
	            admin1.creerUtilisateur("Jean", "Dupont", "1234", categorie1);
	            admin1.creerUtilisateur("Alice", "Martin", "5678", categorie2);

	            // Affichage des utilisateurs
	            admin1.afficherUtilisateurs();

	            

	            // Affichage des utilisateurs après modification
	            admin1.afficherUtilisateurs();
	        }
	    }

	



