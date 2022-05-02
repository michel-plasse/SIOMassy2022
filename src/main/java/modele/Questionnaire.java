/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.time.LocalDateTime;

/**
 *
 * @author Stagiaire
 */
public class Questionnaire {
    private int id, idCreateur, nbMinutes, nbQuestions;
    private String libelle;
    private LocalDateTime creeA;

  public Questionnaire(int id, String libelle, int nbMinutes, LocalDateTime creeA, int nbQuestions, int idCreateur) {
    this.id = id;
    this.idCreateur = idCreateur;
    this.nbMinutes = nbMinutes;
    this.nbQuestions = nbQuestions;
    this.libelle = libelle;
    this.creeA = creeA;
  }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(int idCreateur) {
        this.idCreateur = idCreateur;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNbMinutes() {
        return nbMinutes;
    }

    public void setNbMinutes(int nbMinutes) {
        this.nbMinutes = nbMinutes;
    }

    public LocalDateTime getCreeA() {
        return creeA;
    }

    public void setCreeA(LocalDateTime creeA) {
        this.creeA = creeA;
    }

  public int getNbQuestions() {
    return nbQuestions;
  }

  public void setNbQuestions(int nbQuestions) {
    this.nbQuestions = nbQuestions;
  }
    
}
