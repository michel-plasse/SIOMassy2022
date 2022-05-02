package modele;

import java.util.Objects;

/**
 *
 */
public class Reponse {
  private int idQuestion, idPersonne, idOptionQuestion;
  private String prenom, nom, libelle;

  public Reponse(int idQuestion, int idPersonne, String prenom, String nom, String libelle, int idOptionQuestion) {
    this.idQuestion = idQuestion;
    this.idPersonne = idPersonne;
    this.idOptionQuestion = idOptionQuestion;
    this.prenom = prenom;
    this.nom = nom;
    this.libelle = libelle;
  }

  public int getIdQuestion() {
    return idQuestion;
  }

  public void setIdQuestion(int idQuestion) {
    this.idQuestion = idQuestion;
  }

  public int getIdPersonne() {
    return idPersonne;
  }

  public void setIdPersonne(int idPersonne) {
    this.idPersonne = idPersonne;
  }

  public int getIdOptionQuestion() {
    return idOptionQuestion;
  }

  public void setIdOptionQuestion(int idOptionQuestion) {
    this.idOptionQuestion = idOptionQuestion;
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

  public String getLibelle() {
    return libelle;
  }

  public void setLibelle(String libelle) {
    this.libelle = libelle;
  }

  @Override
  public int hashCode() {
    int hash = 3;
    hash = 97 * hash + this.idQuestion;
    hash = 97 * hash + this.idPersonne;
    hash = 97 * hash + this.idOptionQuestion;
    hash = 97 * hash + Objects.hashCode(this.prenom);
    hash = 97 * hash + Objects.hashCode(this.nom);
    hash = 97 * hash + Objects.hashCode(this.libelle);
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
    final Reponse other = (Reponse) obj;
    if (this.idQuestion != other.idQuestion) {
      return false;
    }
    if (this.idPersonne != other.idPersonne) {
      return false;
    }
    if (this.idOptionQuestion != other.idOptionQuestion) {
      return false;
    }
    if (!Objects.equals(this.prenom, other.prenom)) {
      return false;
    }
    if (!Objects.equals(this.nom, other.nom)) {
      return false;
    }
    if (!Objects.equals(this.libelle, other.libelle)) {
      return false;
    }
    return true;
  }
  
}
