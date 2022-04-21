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
    public static Canal getById(int idCanal) throws SQLException {
        Canal result = null;
        Connection connexion = Database.getConnection();
        String sql = "SELECT * FROM Canal WHERE id_canal =?";
        PreparedStatement stmt = connexion.prepareCall(sql);
        stmt.setInt(1, idCanal);
        ResultSet rs = stmt.executeQuery();
        //Variabls pour construire l'Canak
        Canal canl = null; // membre courant (idéfini au début)
        int idCanaux = 0; // son id (idéfini au début, donc mis à 0)
        List<Canal> canaux = new ArrayList<Canal>();
        
        while (rs.next()) {
            if (rs.isFirst()) 
                Canaux  canal = new canal{
            rs.getInt("id_canal");
            rs.getString("nom");
            result = new Canal(idCanal, rs.getInt("id_canal"), mebmres,
                    rs.getString("nom"));
            }
                if (idCanaux != rs.getInt("id_canal")){
                    canal = new Canal (idCanal, rs.getString("id_canal"), rs.getString("nom"), new ArrayList<Canal>());
                    idCanal = rs.getInt("id_canal");
                    mebmres.add(canal);
                }
                Canal canal = new Canal(
                        rs.getInt("id_canal"),
                        rs.getString("nom"));
                canal.getCanal().add(canal);
        }
        return result;
    }
    
}