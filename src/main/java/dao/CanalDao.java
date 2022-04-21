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

    public static void insert(Canal canal) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "INSERT into canal values(?,?)";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, canal.getId());
        stmt.setString(2, canal.getNom());
        connection.close();
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