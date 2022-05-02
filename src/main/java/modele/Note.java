/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


/**
 *
 * @author utilisateur
 */
public class Note {
    private String note;
    private int idEvaluation;
    private int idEtudiant;
    private String prenom, nom;

    public Note(int idEvaluation, int idEtudiant, String prenom, String nom, String note) {
        this.note = note;
        this.idEvaluation = idEvaluation;
        this.idEtudiant = idEtudiant;
        this.prenom = prenom;
        this.nom = nom;
    }

    
    /** Note entre 0 et 20 */
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
