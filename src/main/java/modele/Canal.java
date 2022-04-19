package modele;

import java.util.Objects;

/**
 *
 * @author hamcherif.ilyesse@gmail.com
 */
public class Canal {

    private int id;
    private String nom;

    /**
     * Constructeur
     *
     * @param id
     * @param nom
     */
    public Canal(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Canal(String nom) {
        this.nom = nom;
    }
    
    public Canal(int id) {
        this.id = id;
    }

    public Canal() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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
        final Canal other = (Canal) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return true;
    }

}