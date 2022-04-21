package dao;

import modele.Canal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
        stmt.executeUpdate();
        stmt.execute();
        ResultSet rs = null;
        rs = stmt.getGeneratedKeys();
        rs.next();
        result = new Canal(
        idCanal,
        // rs.getInt("id_canal"),
        rs.getString("nom"));
        return result;
    }
    
        public static Canal update(int idCanal) throws SQLException {
        Canal result = null;
        Connection connection = Database.getConnection();
        String sql = "UPDATE canal SET nom = ? WHERE id_canal = ?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idCanal);
        stmt.executeUpdate();
        stmt.execute();
        ResultSet rs = null;
        rs = stmt.getGeneratedKeys();
        rs.next();
        result = new Canal(
        idCanal,
        // rs.getInt("id_canal"),
        rs.getString("nom"));
        return result;
    }
        
    public static Canal delete(int idCanal) throws SQLException {
        Canal result = null;
        Connection connection = Database.getConnection();
        String sql = "DELETE FROM canal WHERE id_canal = ?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idCanal);
        stmt.executeUpdate();
        stmt.execute();
        ResultSet rs = null;
        rs = stmt.getGeneratedKeys();
        rs.next();
        result = new Canal(
        idCanal,
        // rs.getInt("id_canal"),
        rs.getString("nom"));
        return result;
    }
    
}