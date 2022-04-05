/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

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
public class Groupe extends Personne{
      private int idEFG, idGroupe, idPersonne;
      private String prenom, nom, email;

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

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + this.idEFG;
        hash = 31 * hash + this.idGroupe;
        hash = 31 * hash + this.idPersonne;
        hash = 31 * hash + Objects.hashCode(this.prenom);
        hash = 31 * hash + Objects.hashCode(this.nom);
        hash = 31 * hash + Objects.hashCode(this.email);
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
        return true;
    }

      
    
}
   
     

