/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.util.Objects;

/**
 *
 * @author Abdillahi
 */
public class Inscription {
   private int id, id_groupe;
   private String nom, prenom, mdp, email, tel;
   
   public Inscription (int id, String nom, String prenom, String mdp, String email, String tel){
       this.nom = nom;
       this.prenom = prenom;
       this.email = email;
       this.mdp = mdp;
       this.tel = tel;
   }
   public Inscription(String prenom, String nom, String email, String tel, String mdp) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.tel = tel;
        this.mdp = mdp;
    }

    public Inscription(int id, String prenom, String nom) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
    }
    public Inscription (){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_groupe(int id_groupe) {
        this.id_groupe = id_groupe;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public int getId_groupe() {
        return id_groupe;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public String getEmail() {
        return email;
    }

    public String getTel() {
        return tel;
    }
    
    
}
