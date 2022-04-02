/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

/**
 *
 * @author Abdillahi
 */
public class Inscription {
   private int id, id_groupe;
   private String nom, prenom, psw, email, tel;
   
   public Inscription (int id, String nom, String prenom, String psw, String email, String tel){
       this.nom = nom;
       this.prenom = prenom;
       this.email = email;
       this.psw = psw;
       this.tel = tel;
   }
}
