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
import modele.Questionnaire;

/**
 *
 * @author Stagiaire
 */
public class QuestionnaireDao {

  public static List<Questionnaire> getByIdFormateur(int idFormateur) throws SQLException {
    ArrayList<Questionnaire> result = new ArrayList<>();
    Connection connexion = Database.getConnection();
    String sql = "SELECT qs.id_questionnaire, qs.libelle, qs.nb_minutes, qs.cree_a,"
            + "COUNT(qcm.id_qcm) AS nb_questions, qs.id_createur\n"
            + "FROM \n"
            + "	questionnaire qs\n"
            + "		LEFT OUTER JOIN\n"
            + "	qcm ON qs.id_questionnaire = qcm.id_questionnaire\n"
            + "WHERE id_createur=?\n"
            + "GROUP BY qs.id_questionnaire, qs.libelle, qs.nb_minutes, qs.cree_a, qs.id_createur\n";
    PreparedStatement stmt = connexion.prepareCall(sql);
    stmt.setInt(1, idFormateur);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      result.add(new Questionnaire(
              rs.getInt("id_questionnaire"),
              rs.getString("libelle"),
              rs.getInt("nb_minutes"),
              rs.getTimestamp("cree_a").toLocalDateTime(),
              rs.getInt("nb_questions"),
              rs.getInt("id_createur")));
    }
    return result;
  }

}
