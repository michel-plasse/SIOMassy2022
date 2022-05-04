package dao;

import modele.Sondage;
import modele.Personne;
import java.sql.*;
import modele.Reponse;

/**
* Author Cheick Lanikpekoun
* SondageDao recupere la avec la requette sql select.... les reponse au sondage depuis la bdd
*/

public class SondageDao {

  public static Sondage getByIdSondage(int idSondage) throws SQLException {
    Sondage result = null;
    Connection connection = Database.getConnection();
    String sql = "SELECT * FROM v_reponse_sondage WHERE id_question = ?";

    PreparedStatement stmt = connection.prepareCall(sql);
    stmt.setInt(1, idSondage);
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
      if (rs.isFirst()) {
        Personne createur = new Personne(rs.getInt("id_createur"),
                rs.getString("prenom_createur"),
                rs.getString("nom_createur"));
        result = new Sondage(
                rs.getInt("id_question"),
                rs.getInt("id_canal"),
                rs.getInt("id_type_question"),
                rs.getString("libelle_question"),
                createur);
      }

/**
* Instancie le contenu des reponse à uin sondage avec id_personne, prenom, nom, libelle_reponse .....
*/
      Reponse reponse = new Reponse(idSondage, 
              rs.getInt("id_personne"), 
              rs.getString("prenom"), 
              rs.getString("nom"),
              rs.getString("libelle_reponse"),
              rs.getInt("id_option_question"));
      System.out.println(reponse.toString());
      result.getReponses().add(reponse);
    }
    return result;
  }
}
