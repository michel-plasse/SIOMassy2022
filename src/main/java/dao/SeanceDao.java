/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Personne;

/**
 *
 * @author SALL Mouhamadou
 */
public class SeanceDao {

    public static void setPresent(int idSeance, int idPersonne,boolean estPresent) throws SQLException {
        Connection connection = Database.getConnection();
        String sql = "Insert Into presence_seance(id_seance, id_personne,niveau_participation)\n"
                + "VALUES(?, ?, ?)\n"
                + "ON duplicate key update niveau_participation=? ";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, idSeance);
        stmt.setInt(2, idPersonne);
        stmt.setInt(3, (estPresent) ? 1 : 0);
        stmt.setInt(4, (estPresent) ? 1 : 0);
        stmt.execute();
    }
}
