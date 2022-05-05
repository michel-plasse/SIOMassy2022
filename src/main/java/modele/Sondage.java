package modele;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Stagiaire
 */
public class Sondage {

  private int idSondage, idCanal, idTypeQuestion;
  private String libelle;
  private Personne createur;
  private ArrayList<Reponse> reponses;

  public Sondage(int idSondage, int idCanal, int idTypeQuestion, String libelle, Personne createur) {
    this.idSondage = idSondage;
    this.idCanal = idCanal;
    this.idTypeQuestion = idTypeQuestion;
    this.libelle = libelle;
    this.createur = createur;
    this.reponses = new ArrayList<>();
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

  public ArrayList<Reponse> getReponses() {
    return reponses;
  }

  public void setReponses(ArrayList<Reponse> reponses) {
    this.reponses = reponses;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 59 * hash + this.idSondage;
    hash = 59 * hash + this.idCanal;
    hash = 59 * hash + this.idTypeQuestion;
    hash = 59 * hash + Objects.hashCode(this.libelle);
    hash = 59 * hash + Objects.hashCode(this.createur);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Sondage other = (Sondage) obj;
    if (this.idSondage != other.idSondage) {
      return false;
    }
    if (this.idCanal != other.idCanal) {
      return false;
    }
    if (this.idTypeQuestion != other.idTypeQuestion) {
      return false;
    }
    if (!Objects.equals(this.libelle, other.libelle)) {
      return false;
    }
    if (!Objects.equals(this.createur.getId(), other.createur.getId())) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "Sondage{" + "idSondage=" + idSondage + ", idCanal=" + idCanal + ", idTypeQuestion=" + idTypeQuestion + ", libelle=" + libelle + ", createur=" + createur.getId() + '}';
  }

}
