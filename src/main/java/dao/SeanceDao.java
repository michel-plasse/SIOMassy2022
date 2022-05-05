/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.Canal;
import modele.Seance;

/**
 *
 * @author SALL Mouhamadou
 */
public class SeanceDao {

    public static void setPresent(int idSeance, int idPersonne,boolean estPresent) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "Insert Into presence_seance(id_seance, id_personne, est_present, niveau_participation)\n"
                + "VALUES(?, ?, ?, NULL)\n"
                + "ON duplicate key update est_present=?, niveau_participation=niveau_participation ";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idSeance);
        stmt.setInt(2, idPersonne);
        stmt.setInt(3, (estPresent) ? 1 : 0);
        stmt.setInt(4, (estPresent) ? 1 : 0);
        stmt.execute();
    }
    
    public static Seance getById(int idSeance) throws SQLException {
        Seance seance = null;
        Connection connection = Database.getConnection();
        String sql = "SELECT id_seance FROM seance WHERE id_canal=?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idSeance);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            seance = new Seance(
                rs.getInt("id_seance")
            );
        }
        return seance;
    }
    
    public static List<Seance> getAll() throws SQLException {
        List<Seance> result = new ArrayList<Seance>();
        Connection connection = Database.getConnection();
        String sql = "SELECT * FROM seance";
        PreparedStatement stmt = connection.prepareCall(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
          result.add(new Seance(rs.getInt("id_seance")));
        }
        return result;
    }
    
    public static Seance niveauParticipation(int niveauParticipation) throws SQLException {
        Seance seance = null;
        Connection connection = Database.getConnection();
        String sql = "SELECT id_seance, niveau_participation FROM presence_seance WHERE id_seance=?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, niveauParticipation);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            seance = new Seance(
                    rs.getInt("id_seance"),
                    rs.getInt("niveau_participation")
            );
        }
        return seance;
    }

    /*public static Seance getById(int idSeance) throws SQLException {
        Seance seance = null;
        Connection connection = Database.getConnection();
        String sql = "SELECT id_seance FROM seance WHERE id_seance=?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idSeance);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            seance = new Seance(
                rs.getInt("id_seance"),
            );
        }
        return seance;
    }*/
}
