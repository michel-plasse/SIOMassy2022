/*karim	
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Personne;
import modele.Seance;

/**
 *
 * @author SALL Mouhamadou
 */
public class SeanceDao {



public static Seance getByIdSeance(int idSeance) throws SQLException {
    Seance result = null;
    Connection connection = Database.getConnection();
    String sql = "SELECT * FROM seance WHERE id_seance = ?";

    PreparedStatement stmt = connection.prepareCall(sql);
    stmt.setInt(1, idSeance);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
      
        Seance seance = new Seance(
                rs.getInt("id_seance"), 
                rs.getInt("id_canal"),             
               rs.getTimestamp("debute_a").toLocalDateTime(),
                rs.getTimestamp("fini_a")
                
        )
    
    return result;
}
