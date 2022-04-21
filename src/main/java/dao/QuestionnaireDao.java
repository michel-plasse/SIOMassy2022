
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.QuestionnaireEntrainement;

/**
 *
 * @author ak
 */
public class QuestionnaireDao {
    public static QuestionnaireEntrainement getById(int idQuestionnaire) throws SQLException {
    QuestionnaireEntrainement result = null;
    Connection connexion = Database.getConnection();
    String sql = "SELECT id_questionnaire FROM questionnaire WHERE id_questionnaire= ?";
    PreparedStatement stmt = connexion.prepareCall(sql);
    stmt.setInt(1, idQuestionnaire);
    ResultSet rs = stmt.executeQuery();
   
    
    if (rs.next()) {
   
        QuestionnaireEntrainement questionnaire = new QuestionnaireEntrainement(
            rs.getInt("idQuestionnaire"),
            rs.getInt("idCreateur"),
            rs.getInt("nbMinutes"),
            rs.getString("libelle"));

    }
    return result;
  }
}

