/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Canal;
import modele.Entrainement;
import modele.Questionnaire;

/**
 *
 * @author ak
 */
public class EntrainementDao {
    

    public static void insertEntrainement(Entrainement entrainement) throws SQLException {
//        Entrainement result = null;
//        Connection connection = Database.getConnection();
//        String sql = "INSERT INTO seance VALUE(";
//        PreparedStatement stmt = connection.prepareCall(sql);
//        stmt.setInt(1, idEntrainement);
//        stmt.executeUpdate();
//        stmt.execute();
//        ResultSet rs = null;
//        rs = stmt.getGeneratedKeys();
//        rs.next();
//        result = new Entrainement(
//      
//        // rs.getInt("id_canal"),
//        
//        rs.getInt("id"),        
//        rs.getInt("idQuestionnaire"),
//        rs.getInt("idCanal"),
//        
//           
//    
//        return result;
    }
    
    public static void update(Canal canal) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM canal WHERE id_canal = ?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, canal.getId());
        stmt.setString(2, canal.getNom());
        connection.close();
    }
}