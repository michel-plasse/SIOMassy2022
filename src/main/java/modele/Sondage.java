package modele;

/**
 *
 * @author Stagiaire
 */
public class Sondage {
    private int idSondage, idCanal, idTypeQuestion;
    private String libelle;
    private Personne createur;

    public Sondage(int idSondage, int idCanal, int idTypeQuestion, String libelle, Personne createur) {
        this.idSondage = idSondage;
        this.idCanal = idCanal;
        this.idTypeQuestion = idTypeQuestion;
        this.libelle = libelle;
        this.createur = createur;
    }

    public int getIdSondage() {
        return idSondage;
    }

    public void setIdSondage(int idSondage) {
        this.idSondage = idSondage;
    }

    public int getIdCanal() {
        return idCanal;
    }

    public void setIdCanal(int idCanal) {
        this.idCanal = idCanal;
    }

    public int getIdTypeQuestion() {
        return idTypeQuestion;
    }

    public void setIdTypeQuestion(int idTypeQuestion) {
        this.idTypeQuestion = idTypeQuestion;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Personne getCreateur() {
        return createur;
    }

    public void setCreateur(Personne createur) {
        this.createur = createur;
    }
    
}
