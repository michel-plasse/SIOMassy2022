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

  public static Canal getById(int idCanal) throws SQLException {
    Canal result = null;
    Connection connection = Database.getConnection();
    String sql = "SELECT * FROM canal WHERE id_canal = ?";
    PreparedStatement stmt = connection.prepareCall(sql);
    stmt.setInt(1, idCanal);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
      Canal administrateur = new Canal(23, "testavril");
      result = new Canal(
              rs.getInt("id_canal"),
              rs.getString("nom"));
    }
    return result;
  }

}