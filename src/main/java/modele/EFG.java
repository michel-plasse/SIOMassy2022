/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author adem romdhane
 * 
 */
public class EFG {
    private int idEfg;
    private int idCreateur;
    private int idCanal;
    
    private String intitule;
    private LocalDateTime creeA; 

    public EFG() {
    }

    public EFG(int idEfg, int idCreateur, int idCanal, String intitule) {
        this.idEfg = idEfg;
        this.idCreateur = idCreateur;
        this.idCanal = idCanal;
        this.intitule = intitule;
        
    }

    public int getIdEfg() {
        return idEfg;
    }

    public void setIdEfg(int idEfg) {
        this.idEfg = idEfg;
    }

    public int getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(int idCreateur) {
        this.idCreateur = idCreateur;
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
