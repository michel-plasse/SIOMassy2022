package dao;

import modele.Canal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hamcherif.ilyesse@gmail.com
 */
public class CanalDao {

    public static Canal insert(int idCanal) throws SQLException {
      Canal result = null;
      Connection connection = Database.getConnection();
      String sql = "INSERT INTO canal(id, nom) VALUES (?,?)";
      PreparedStatement stmt = connection.prepareCall(sql);
      stmt.setInt(1, idCanal);
      ResultSet rs = stmt.executeQuery();
      if (rs.next()) {
          Canal createur = new Canal(4, "Test");
          result = new Canal(
              rs.getInt("id_canal"),
              rs.getString("nom")
          );
      }
      return result;
    }

}