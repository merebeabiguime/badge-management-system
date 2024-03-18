import java.sql.Date;

public class Scan {

    private int id;
    private Date date;
    private String heure;
    private int id_utilisateur;
    private boolean tentative_acces;

    public Scan(int id, Date date, String heure, int id_utilisateur, boolean tentative_acces) {
        this.id = id;
        this.date = date;
        this.heure = heure;
        this.id_utilisateur = id_utilisateur;
        this.tentative_acces = tentative_acces;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public boolean getTentative_acces() {
        return tentative_acces;
    }

    public void setTentative_acces(boolean tentative_acces) {
        this.tentative_acces = tentative_acces;
    }

}
