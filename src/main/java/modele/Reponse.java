/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author adem romdhane
 */
public class Reponse {
    private int idQuestion;
    private int id,idPersonne;
    private String libelle;
    private int idOptionQuestion;

    public Reponse() {
    }

    public Reponse(int idQuestion, int id, int idPersonne, String libelle, int idOptionQuestion) {
        this.idQuestion = idQuestion;
        this.id = id;
        this.idPersonne = idPersonne;
        this.libelle = libelle;
        this.idOptionQuestion = idOptionQuestion;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getIdOptionQuestion() {
        return idOptionQuestion;
    }

    public void setIdOptionQuestion(int idOptionQuestion) {
        this.idOptionQuestion = idOptionQuestion;
    }
    
    
}
