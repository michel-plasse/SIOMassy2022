package modele;



public class AfficheNote {
    /* Je créer mes variables*/
    private String note;
    private int idEvaluation;
    private int idEtudiant;
    private String prenom, nom;

    /* Constructeur*/
    public AfficheNote(int idEvaluation, int idEtudiant, String prenom, String nom, String note) {
        this.note = note;
        this.idEvaluation = idEvaluation;
        this.idEtudiant = idEtudiant;
        this.prenom = prenom;
        this.nom = nom;
    }

    
    /** Getters et Setters */
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getIdEvaluation() {
        return idEvaluation;
    }

    public void setIdEvaluation(int idEvaluation) {
        this.idEvaluation = idEvaluation;
    }

    public int getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(int idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

  
    
    
}
