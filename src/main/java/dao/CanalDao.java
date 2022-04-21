package dao;

import modele.Canal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hamcherif.ilyesse@gmail.com
 */
public class CanalDao {

    /**public static void insert(Canal canal) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT into canal VALUES(?,?)";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, canal.getId());
        stmt.setString(2, canal.getNom());
        connection.close();
    }
    */
    public static Canal insert(int idCanal) throws SQLException {
        Canal result = null;
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO canal VALUES(?,?)";
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
    
    public static void update(Canal canal) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM canal WHERE id_canal = ?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, canal.getId());
        stmt.setString(2, canal.getNom());
        connection.close();
    }
        
    public static void delete(Canal canal) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "DELETE FROM canal WHERE id_canal = ?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, canal.getId());
        stmt.setString(2, canal.getNom());
        connection.close();
    }
    
}