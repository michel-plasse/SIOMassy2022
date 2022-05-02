package modele;

import java.sql.Time;
import java.time.LocalDateTime;

/**
 *
 * @author ak
 */
public class Questionnaire {

    private LocalDateTime creeLe;
    private int idCreateur;
    private int idQuestionnaire;
    private String libelle;
    private Time nbMinute;

    private int id, idCanal;//Besoin pour fonctionnalité lancerQuestionnaire
    private LocalDateTime debuteA, finitA;//Besoin pour fonctionnalité lancerQuestionnaire

    public LocalDateTime getCreeLe() {
        return creeLe;
    }

    public void setCreeLe(LocalDateTime creeLe) {
        this.creeLe = creeLe;
    }

    public int getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(int idCreateur) {
        this.idCreateur = idCreateur;
    }

    public int getIdQuestionnaire() {
        return idQuestionnaire;
    }

    public void setIdQuestionnaire(int idQuestionnaire) {
        this.idQuestionnaire = idQuestionnaire;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Time getNbMinute() {
        return nbMinute;
    }

    public void setNbMinute(Time nbMinute) {
        this.nbMinute = nbMinute;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCanal() {
        return idCanal;
    }

    public void setIdCanal(int idCanal) {
        this.idCanal = idCanal;
    }

    public LocalDateTime getDebuteA() {
        return debuteA;
    }

    public void setDebuteA(LocalDateTime debuteA) {
        this.debuteA = debuteA;
    }

    public LocalDateTime getFinitA() {
        return finitA;
    }

    public void setFinitA(LocalDateTime finitA) {
        this.finitA = finitA;
    }

    public Questionnaire(int id, int idCanal, int idQuestionnaire, String libelle, Time nbMinute) {//Besoin pour fonctionnalité lancerQuestionnaire
        this.id = id;
        this.idCanal = idCanal;
        this.idQuestionnaire = idQuestionnaire;
        this.libelle = libelle;
        this.nbMinute = nbMinute;
    }

    public Questionnaire(int id, int idCanal, int idQuestionnaire, String libelle, Time nbMinute, LocalDateTime debuteA, LocalDateTime finitA) {//Besoin pour fonctionnalité lancerQuestionnaire
        this.id = id;
        this.idCanal = idCanal;
        this.idQuestionnaire = idQuestionnaire;
        this.libelle = libelle;
        this.nbMinute = nbMinute;
        this.debuteA = debuteA;
        this.finitA = finitA;
    }

    public Questionnaire(LocalDateTime creeLe, int idCreateur, int idQuestionnaire, String libelle, Time nbMinute) {
        this.creeLe = creeLe;
        this.idCreateur = idCreateur;
        this.idQuestionnaire = idQuestionnaire;
        this.libelle = libelle;
        this.nbMinute = nbMinute;
    }

    public Questionnaire(int idQuestionnaire, String libelle, Time nbMinute) {
        this.idQuestionnaire = idQuestionnaire;
        this.libelle = libelle;
        this.nbMinute = nbMinute;
    }

    public Questionnaire() {
    }

    public Questionnaire(LocalDateTime creeLe, int idCreateur, int idQuestionnaire, String libelle, Time nbMinute, int id, int idCanal, LocalDateTime debuteA, LocalDateTime finitA) {
        this.creeLe = creeLe;
        this.idCreateur = idCreateur;
        this.idQuestionnaire = idQuestionnaire;
        this.libelle = libelle;
        this.nbMinute = nbMinute;
        this.id = id;
        this.idCanal = idCanal;
        this.debuteA = debuteA;
        this.finitA = finitA;
    }

}
