/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ak
 */
public class Entrainement {
    
    int id;
    int idQuestionnaire;
    int idCanal;
    private List<Questionnaire> questionnaire;

    public Entrainement() {
    questionnaire = new ArrayList<Questionnaire>();
  }

    public List<Questionnaire> getQuestionnaire() {
        return questionnaire;
    }

    public void setQuestionnaire(List<Questionnaire> questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Entrainement(List<Questionnaire> questionnaire) {
        this.questionnaire = questionnaire;
    }

    public Entrainement(int id, int idQuestionnaire, int idCanal, List<Questionnaire> questionnaire) {
        this.id = id;
        this.idQuestionnaire = idQuestionnaire;
        this.idCanal = idCanal;
        this.questionnaire = questionnaire;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public int getIdCanal() {
        return idCanal;
    }

    public void setIdCanal(int idCanal) {
        this.idCanal = idCanal;
    }

    public Entrainement(int id, int idQuestionnaire, int idCanal) {
        this.id = id;
        this.idQuestionnaire = idQuestionnaire;
        this.idCanal = idCanal;
    }

    public void  getSize() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
  
    }
    
}
