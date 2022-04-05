/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.time.LocalDate;

/**
 *
 * @author adem romdhane
 * 
 */
public class EFG {
    private int id_efg;
    private int id_createur;
    private int id_canal;
    
    private String intitule;
    private LocalDate cree_a; 
    

    public int getId_efg() {
        return id_efg;
    }

    public void setId_efg(int id_efg) {
        this.id_efg = id_efg;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public LocalDate getCree_a() {
        return cree_a;
    }

    public void setCree_a(LocalDate cree_a) {
        this.cree_a = cree_a;
    }
}
