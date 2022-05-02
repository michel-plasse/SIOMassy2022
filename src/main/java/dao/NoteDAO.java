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
import java.util.ArrayList;
import java.util.List;
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
    
    public List<Note> getNotesByIdEvaluation(int idEvaluation) throws SQLException {
        ArrayList<Note> result = new ArrayList<>();
        Connection connexion = Database.getConnection();
        String sql = "SELECT * FROM v_note_evaluation WHERE id_evaluation=?";
        return result;
    }
    
}
