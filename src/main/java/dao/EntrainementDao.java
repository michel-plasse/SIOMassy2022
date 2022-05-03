/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.Canal;
import modele.Entrainement;
import modele.Questionnaire;

/**
 *
 * @author ak
 */
public class EntrainementDao {

    public static Entrainement insert(int id, int idQuestionnaire, int idCanal ) throws SQLException {
    //public static Entrainement insertEntrainement(int idQuestionnaire, int idCanal) throws SQLException {

        Entrainement result = null;
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO entrainement (id_entrainement,id_questionnaire,id_canal) VALUE(?,?,?)";
        
        PreparedStatement stmt = connection.prepareCall(sql);

        //stmt.setObject(1, entrainement);
        stmt.setInt(1, idQuestionnaire);
        //stmt.setInt(2, idCanal);
        stmt.executeUpdate();

        stmt.execute();
        ResultSet rs = null;
        rs = stmt.getGeneratedKeys();

        

        while (rs.next()) {
            // Récupérer les infos de l'EFG (une seule fois)
            if (rs.isFirst()) {
                Questionnaire questionnaire = new Questionnaire(
                        rs.getInt("id"),
                        rs.getString("libelle"),
                        rs.getInt("nbMinute"),
                        null,
                        rs.getInt("nbQuestion"),
                        rs.getInt("id_createur")
                );
                result = new Entrainement(id, idQuestionnaire, idCanal);
            }
            // Créer un nouveau groupe si le id_groupe change dans le result set
            if (idQuestionnaire != rs.getInt("id")) {
                Entrainement entrainement2 = new Entrainement(
                        rs.getInt("id"),
                        rs.getInt("idQuestionnaire"),
                        rs.getInt("idCanal"));
                entrainement2.setIdQuestionnaire(idQuestionnaire);
            }

        }
        return result;

    }


 public static void update(Entrainement entrainement) throws SQLException {
        Connection connection = Database.getConnection();
//        String sql = "SELECT * FROM entrainement WHERE id_questionnaire=?";
        String sql = "INSERT INTO entrainement (id_entrainement,id_questionnaire,id_canal) VALUE(?,?,?)";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, entrainement.getId());
        //stmt.setString(2, entrainement.get());
        connection.close();
    }
}