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
import modele.Evaluation;
import modele.Personne;

/**
 *
 * @author utilisateur
 */
public class EvaluationDao {

    public static List<Evaluation> getById(int idCreateur) throws SQLException {
        ArrayList<Evaluation> result = new ArrayList<>();
        //Evaluation result = null;
        Connection connection = Database.getConnection();
        String sql = "SELECT id_evaluation, intitule, id_createur FROM evaluation"
                + " WHERE id_createur=?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idCreateur);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            result.add(new Evaluation(
                    rs.getString("intitule"),
                    rs.getInt("id_createur")
            ));
        }
        return result;
    }
}
