
 /** Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
 
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
  public static EFG getById(int idEFG) throws SQLException {
    EFG result = null;
    Connection connexion = Database.getConnection();
    String sql = "SELECT * FROM efg WHERE id_efg = ?";
    PreparedStatement stmt = connexion.prepareCall(sql);
    stmt.setInt(1, idEFG);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
      // d'abord le créateur en dur
      Personne createur = new Personne(1, "Tryphon", "Tournesol");
      result = new EFG(
              idEFG, 
              createur, 
              rs.getInt("id_canal"),
              rs.getString("intitule"),
              rs.getTimestamp("cree_a").toLocalDateTime());
    }
    return result;
  }
    
}


