/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.util.List;
import java.util.Objects;

/**
 *
 * @author ak
 *  /**
     * Constructeur
     *
     * @param idGroupe
     * @param idEFG
 */
public class Groupe {
      private int idEFG, idGroupe;
      private  Personne createur;
      private List<Personne> membres;

    public Groupe(int idEFG, int idGroupe, Personne createur, List<Personne> membres) {
        this.idEFG = idEFG;
        this.idGroupe = idGroupe;
        this.createur = createur;
        this.membres = membres;
    }

    public Personne getCreateur() {
        return createur;
    }

    public void setCreateur(Personne createur) {
        this.createur = createur;
    }

    public List<Personne> getMembres() {
        return membres;
    }

    public void setMembres(List<Personne> membres) {
        this.membres = membres;
    }
 
    

    public int getIdEFG() {
        return idEFG;
    }

    public void setIdEFG(int idEFG) {
        this.idEFG = idEFG;
    }

    public int getIdGroupe() {
        return idGroupe;
    }

    public void setIdGroupe(int idGroupe) {
        this.idGroupe = idGroupe;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idEFG;
        hash = 37 * hash + this.idGroupe;
        hash = 37 * hash + Objects.hashCode(this.createur);
        hash = 37 * hash + Objects.hashCode(this.membres);
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
        final Groupe other = (Groupe) obj;
        if (this.idEFG != other.idEFG) {
            return false;
        }
        if (this.idGroupe != other.idGroupe) {
            return false;
        }
        if (!Objects.equals(this.createur, other.createur)) {
            return false;
        }
        return Objects.equals(this.membres, other.membres);
    }

  
    }
   
     

