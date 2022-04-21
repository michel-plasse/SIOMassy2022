package modele;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author Formateur
 */
public class Seance {
  private int id, idCanal;
  private LocalDateTime debuteA, finitA;

  public Seance() {
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
