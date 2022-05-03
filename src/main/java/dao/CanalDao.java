package dao;

import modele.Canal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modele.Personne;

/**
 *
 * @author hamcherif.ilyesse@gmail.com
 */
public class CanalDao {

    /**
     * public static void insert(Canal canal) throws SQLException { Connection
     * connection = Database.getConnection(); String sql = "INSERT into canal
     * VALUES(?,?)"; PreparedStatement stmt = connection.prepareCall(sql);
     * stmt.setInt(1, canal.getId()); stmt.setString(2, canal.getNom());
     * connection.close(); }
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

    public static List<Canal> getAll() throws SQLException {
        List<Canal> result = new ArrayList<>();
        Connection connexion = Database.getConnection();
        String sql = "SELECT * FROM canal";
        PreparedStatement stmt = connexion.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            result.add(new Canal(rs.getInt("id_canal"), rs.getString("nom")));
        }
        return result;
    }
/**
 * 
 */
    public static List<Personne> getMembresByIdCanal(int idCanal) throws SQLException {
        ArrayList<Personne> result = new ArrayList<>();
        Connection connection = Database.getConnection();
        String sql = "SELECT mc.id_canal, p.nom, p.prenom, p.email\n"
                + "FROM \n"
                + "membre_canal mc\n"
                + "INNER JOIN \n"
                + "personne p ON mc.id_personne = p.id_personne\n"
                + "WHERE id_canal=?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idCanal);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            // Dans tous les cas lister les membres du canal;
            result.add(new Personne(idCanal,
                    rs.getString("prenom"),
                    rs.getString("nom"),
                    rs.getString("email")
            ));
        }
        return result;
    }

}
