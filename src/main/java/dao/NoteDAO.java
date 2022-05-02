/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Canal;
import modele.Note;

/**
 *
 * @author utilisateur
 */
public class NoteDAO {
    
//    public static Note insert(int idEvaluation) throws SQLException {
//        Canal result = null;
//        Connection connection = Database.getConnection();
//        String sql = "INSERT INTO evaluation VALUES(?,?)";
//        PreparedStatement stmt = connection.prepareCall(sql);
//        stmt.setInt(1, idEvaluation);
//        stmt.executeUpdate();
//        stmt.execute();
//        ResultSet rs = null;
//        rs = stmt.getGeneratedKeys();
//        rs.next();
//        result = new Note(
//        idEvaluation,
//        // rs.getInt("id_canal"),
//        rs.getInt("note"));
//        return result;
//    }
    
    /*
    public static void update(Canal canal) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM canal WHERE id_canal = ?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, canal.getId());
        stmt.setString(2, canal.getNom());
        connection.close();
    }
        
    public static void delete(Canal canal) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "DELETE FROM canal WHERE id_canal = ?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, canal.getId());
        stmt.setString(2, canal.getNom());
        connection.close();
    }
    */

}
