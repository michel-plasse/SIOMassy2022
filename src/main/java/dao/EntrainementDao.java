/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.Canal;
import modele.Entrainement;
import modele.Questionnaire;

/**
 *
 * @author ak
 */
public class EntrainementDao {

    public static void insert(Entrainement entrainement) throws SQLException {
        //public static Entrainement insertEntrainement(int idQuestionnaire, int idCanal) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO entrainement(id_questionnaire, id_canal) VALUE(?,?)";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, entrainement.getIdQuestionnaire());
        stmt.setInt(2, entrainement.getIdCanal());
        stmt.executeUpdate();
     }
// on récupère les questionnaires

    public static Questionnaire getById(int idQuestionnaire, int IdCanal) throws SQLException {
        Questionnaire result = null;
        Connection connexion = Database.getConnection();
        String sql = "SELECT * FROM v_questionnaire_seance WHERE id_questionnaire = ? AND id_canal = ?";

        PreparedStatement stmt = connexion.prepareCall(sql);
        stmt.setInt(1, idQuestionnaire);
        stmt.setInt(2, IdCanal);
        ResultSet rs = stmt.executeQuery();
        // Variables pour construire l'Entrainement
        if (rs.next()) {
            result = new Questionnaire(//Besoin pour fonctionnalité lancerQuestionnaire

                    rs.getInt("id"),
                    rs.getString("libelle"),
                    rs.getInt("nbMinute"),
                    null,
                    rs.getInt("nbQuestions"),
                    rs.getInt("idCreateur")
            /*rs.getTime("nbMinute"),
                    rs.getTimestamp("debute_a").toLocalDateTime(),
                    rs.getTimestamp("finit_a").toLocalDateTime()*/
            );
        }
        return result;
    }

}
