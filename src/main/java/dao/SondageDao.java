
package dao;
import modele.Sondage;
import modele.Personne;
import java.sql.*;

public class SondageDao {

    public static Sondage getByIdSondage(int idSondage) throws SQLException {
      Sondage result = null;
      Connection connection = Database.getConnection();
      String sql = "SELECT *\n" +
          "FROM\n" +
          "    question q\n" +
          "        INNER JOIN\n" +
          "    personne p ON q.id_createur = p.id_personne" +
          "WHERE id_question = ?";

      PreparedStatement stmt = connection.prepareCall(sql);
      stmt.setInt(1, idSondage);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
          Personne createur = new Personne(rs.getInt("id_createur"),
                rs.getString("prenom"),
                rs.getString("nom"));
          result = new Sondage(
                rs.getInt("id_question"),
                rs.getInt("id_canal"),
                rs.getInt("id_type_question"),
                rs.getString("libelle"),
                createur);
      }
      return result;
    }
}

