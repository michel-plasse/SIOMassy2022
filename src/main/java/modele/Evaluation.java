
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
/**
 *
 * @author utilisateur
 */
public class Evaluation {
    
    private String intitule;
    private LocalDateTime passeA;
    private Duration duree;
    private int id, idCanal, idCreateur;
    private boolean estCorrige;

    public Evaluation() {
    }

    public Evaluation(String intitule, int idCreateur) {
        this.intitule = intitule;
        this.idCreateur = idCreateur;
    }
    
    

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public LocalDateTime getPasseA() {
        return passeA;
    }

    public void setPasseA(LocalDateTime passeA) {
        this.passeA = passeA;
    }

    public Duration getDuree() {
        return duree;
    }

    public void setDuree(Duration duree) {
        this.duree = duree;
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

    public int getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(int idCreateur) {
        this.idCreateur = idCreateur;
    }

    public boolean isEstCorrige() {
        return estCorrige;
    }

    public void setEstCorrige(boolean estCorrige) {
        this.estCorrige = estCorrige;
    }
    
}