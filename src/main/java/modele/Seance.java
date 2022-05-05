package modele;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Formateur
 */
public class Seance {
    private int id, idCanal, idPersonne, niveauParticipation;
    private LocalDateTime debuteA, finitA;
      private int idQuestionnaire;//Besoin pour fonctionnalité lancerQuestionnaire
      private String libelle;//Besoin pour fonctionnalité lancerQuestionnaire
      private Time nbMinute;//Besoin pour fonctionnalité lancerQuestionnaire
      
  public Seance(int id, int idCanal, int idPersonne, int niveauParticipation, int idQuestionnaire, String libelle, Time nbMinute) {//Besoin pour fonctionnalité lancerQuestionnaire
          this.id = id;
          this.idCanal = idCanal;
          this.idPersonne = idPersonne;
          this.niveauParticipation = niveauParticipation;
          this.idQuestionnaire = idQuestionnaire;
          this.libelle = libelle;
          this.nbMinute = nbMinute;
      }


  public Seance() {
  }
  
    public Seance(int id, int idPersonne, int niveauParticipation) {//Besoin pour fonctionnalité Participations étudiants
        this.id = id;
        this.idPersonne = idPersonne;
        this.niveauParticipation = niveauParticipation;
    }
    
    public Seance(int id) {//Besoin pour fonctionnalité Participations étudiants
        this.id = id;
    }
    
    public Seance(int id, int niveauParticipation) {//Besoin pour fonctionnalité Participations étudiants
        this.id = id;
        this.niveauParticipation = niveauParticipation;
    }

  public Seance(int id, int idCanal, LocalDateTime debuteA, LocalDateTime finitA) {
    this.id = id;
    this.idCanal = idCanal;
    this.debuteA = debuteA;
    this.finitA = finitA;
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
  
  public int getIdPersonne() {
    return idPersonne;
  }

  public void setIdPersonne(int idPersonne) {
    this.idPersonne = idPersonne;
  }
  
  public int getNiveauParticipation() {
    return niveauParticipation;
  }

  public void setNiveauParticipation(int niveauParticipation) {
    this.niveauParticipation = niveauParticipation;
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

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + this.id;
    hash = 67 * hash + this.idCanal;
    hash = 67 * hash + Objects.hashCode(this.debuteA);
    hash = 67 * hash + Objects.hashCode(this.finitA);
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
    final Seance other = (Seance) obj;
    if (this.id != other.id) {
      return false;
    }
    if (this.idCanal != other.idCanal) {
      return false;
    }
    if (!Objects.equals(this.debuteA, other.debuteA)) {
      return false;
    }
    if (!Objects.equals(this.finitA, other.finitA)) {
      return false;
    }
    return true;
  }
  
}
