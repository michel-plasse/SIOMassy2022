package dao;

import modele.Canal;   
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CanalDao {

    /**
    *
    * @author hamcherif.ilyesse@gmail.com
    */
    private static final String insert_canal = "INSERT INTO canal (nom) VALUES (?);";
    private static final String select_canal_by_id = "SELECT id_canal, nom FROM canal WHERE id_canal=?;";
    private static final String select_all_canal = "SELECT * FROM canal;";
    private static final String update_canal = "UPDATE canal SET name=?;";
    private static final String delete_canal = "DELETE FROM canal WHERE nom = ?;";

    
    public static List<Canal> getAll() throws SQLException {
        List<Canal> result = new ArrayList<Canal>();
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM canal";
        PreparedStatement stmt = connection.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()) {
            result.add(new Canal(rs.getInt("id_canal"), rs.getString("nom")));
        }
        return result;
    }
    
    public static Canal getById(int idCanal) throws SQLException {
        Canal canal = null;
        Connection connection = Database.getConnection();
        String sql = "SELECT id_canal, nom FROM canal WHERE id_canal=?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idCanal);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            canal = new Canal(
                rs.getInt("id_canal"),
                rs.getString("nom")
            );
        }
        return canal;
    }



    public static void insert(Canal canal) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(insert_canal, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, canal.getNom());
        stmt.execute();
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()) {
            canal.setId(rs.getInt(1));
        }
    }

    public static void delete(Canal canal) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(delete_canal, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, canal.getNom());
        stmt.execute();
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()) {
            canal.setId(rs.getInt(1));
        }
    }

    public static void update(Canal canal) throws SQLException {
        Connection connection = Database.getConnection();
        PreparedStatement stmt = connection.prepareStatement(update_canal, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, canal.getNom());
        stmt.execute();
        ResultSet rs = stmt.getGeneratedKeys();
        if(rs.next()) {
            canal.setId(rs.getInt(1));
        }
    }
}