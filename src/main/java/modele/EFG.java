
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adem romdhane
 *
 */
public class EFG {

  private int idEfg;
  Personne createur;
  private int idCanal;
  private List<Groupe> groupes;
  private String intitule;
  private LocalDateTime creeA;

  public EFG() {
    groupes = new ArrayList<Groupe>();
  }

  public List<Groupe> getGroupes() {
    return groupes;
  }

  public void setGroupes(List<Groupe> groupes) {
    this.groupes = groupes;
  }

  public EFG(int idEfg, Personne createur, int idCanal, List<Groupe> groupes, String intitule, LocalDateTime creeA) {
    this.idEfg = idEfg;
    this.createur = createur;
    this.idCanal = idCanal;
    this.groupes = groupes;
    this.intitule = intitule;
    this.creeA = creeA;
  }

  public EFG(int idEfg, Personne createur, int idCanal, String intitule, LocalDateTime creeA) {
    this.idEfg = idEfg;
    this.createur = createur;
    this.idCanal = idCanal;
    groupes = new ArrayList<Groupe>();
    this.intitule = intitule;
    this.creeA = creeA;
  }

  public EFG(int idEfg, int idCanal, String intitule) {
    this.idEfg = idEfg;
    this.createur = createur;
    this.idCanal = idCanal;
    this.intitule = intitule;
    groupes = new ArrayList<Groupe>();
  }

  public int getIdEfg() {
    return idEfg;
  }

  public void setIdEfg(int idEfg) {
    this.idEfg = idEfg;
  }

  public Personne getCreateur() {
    return createur;
  }

  public void setCreateur(Personne createur) {
    this.createur = createur;
  }

  public int getIdCanal() {
    return idCanal;
  }

  public void setIdCanal(int idCanal) {
    this.idCanal = idCanal;
  }

  public String getIntitule() {
    return intitule;
  }

  public void setIntitule(String intitule) {
    this.intitule = intitule;
  }

  public LocalDateTime getCreeA() {
    return creeA;
  }

  public void setCreeA(LocalDateTime creeA) {
    this.creeA = creeA;
  }

}
