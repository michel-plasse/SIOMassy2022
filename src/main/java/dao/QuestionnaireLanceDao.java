/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Questionnaire;

/**
 *
 * @author ak
 */
public class QuestionnaireLanceDao {

    public static Questionnaire getById(int idQUESTIONNAIRE, int IDSEANCE) throws SQLException {
        Questionnaire result = null;
        Connection connexion = Database.getConnection();
        String sql = "SELECT * FROM v_questionnaire_seance WHERE id_questionnaire = ? AND id_seance = ?";

        PreparedStatement stmt = connexion.prepareCall(sql);
        stmt.setInt(1, idQUESTIONNAIRE);
        stmt.setInt(2, IDSEANCE);
        ResultSet rs = stmt.executeQuery();
        // Variables pour construire l'Entrainement
        if (rs.next()) {
            result = new Questionnaire(//Besoin pour fonctionnalité lancerQuestionnaire

                    rs.getInt("id_seance"),
                    rs.getInt("id_canal"),
                    rs.getInt("id_questionnaire"),
                    rs.getString("libelle"),
                    null,
                    null,
                    null
                    /*rs.getTime("nbMinute"),
                    rs.getTimestamp("debute_a").toLocalDateTime(),
                    rs.getTimestamp("finit_a").toLocalDateTime()*/
            );
        }
        return result;
    }

}
