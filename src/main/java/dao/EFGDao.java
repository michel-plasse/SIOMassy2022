
 /** Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
 
package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import modele.EFG;
import modele.Personne;

/**
 *
 * @author ak
 *
 */
public class EFGDao {
    
  public static EFG getById(int idEFG) {
    // D'abord en dur
    EFG result = null;
//    Connection connexion = Database.getConnection();
    Personne createur = new Personne(1, "Tryphon", "Tournesol");
    result = new EFG(idEFG, createur, idEFG, "TP définir objectif", LocalDateTime.now());
    return result;
  }
    
}


