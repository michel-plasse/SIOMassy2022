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
import modele.Entrainement;
import modele.Questionnaire;

/**
 *
 * @author ak
 */
public class EntrainementDao {

    public static Entrainement insert(int id, int idQuestionnaire, int idCanal) throws SQLException {
        //public static Entrainement insertEntrainement(int idQuestionnaire, int idCanal) throws SQLException {

        Entrainement result = null;
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO entrainement (id_entrainement,id_questionnaire,id_canal) VALUE(?,?,?)";

        PreparedStatement stmt = connection.prepareCall(sql);

        stmt.setInt(1, id);
        stmt.setInt(1, idQuestionnaire);
        stmt.setInt(2, idCanal);
        stmt.executeUpdate();

        stmt.execute();
        ResultSet rs = null;
        rs = stmt.getGeneratedKeys();

        Questionnaire questionR = null; // groupe courant (indéfini au début)
        int idEntrainement = 0;
       idQuestionnaire = 0; // son id (indéfini au début, donc mis à 0)
        List<Questionnaire> questionnaires = new ArrayList<Questionnaire>();
        Entrainement entrainement = new Entrainement();
        while (rs.next()) {
            // Récupérer les infos de l'EFG (une seule fois)
            if (rs.isFirst()) {
                result = new Entrainement(
                        rs.getInt("id_entrainement"),
                        rs.getInt("id_questionnaire"),
                        rs.getInt("id_canal"));

            }
            // Créer un nouveau groupe si le id_groupe change dans le result set
            if (idEntrainement != rs.getInt("id_entrainement")) {
                entrainement = new Entrainement(
                        rs.getInt("id_entrainement"),
                        rs.getInt("id_questionnaire"),
                        rs.getInt("id_canal"));
            }

            questionR = new Questionnaire(//Besoin pour fonctionnalité lancerQuestionnaire

                    rs.getInt("id"),
                    rs.getString("libelle"),
                    rs.getInt("nbMinute"),
                    null,
                    rs.getInt("nbQuestions"),
                    rs.getInt("idCreateur"));
            questionnaires.add(questionR);
            /*rs.getTime("nbMinute"),
                            rs.getTimestamp("debute_a").toLocalDateTime(),
                            rs.getTimestamp("finit_a").toLocalDateTime()*/
            questionnaires.size();

            result.setIdQuestionnaire(idQuestionnaire);
            result.setId(id);
            result.setIdCanal(idCanal);
        }
        stmt.setInt(1, result.getId());
        stmt.setInt(2, result.getIdQuestionnaire());
        stmt.setInt(2, result.getIdCanal());

    

    connection.close ();

    stmt.execute ();

    stmt.close ();


return result;
    }
    

    public static void Update(Entrainement entrainement) throws SQLException {
        Connection connection = Database.getConnection();
//        String sql = "SELECT * FROM entrainement WHERE id_questionnaire=?";
        //String sql = "INSERT INTO entrainement (id_entrainement,id_questionnaire,id_canal) VALUE(?,?,?)";
        String sql = "UPDATE entrainement SET id_entrainement,id_questionnaire,id_canal where id questionnaire =?";
        PreparedStatement stmt = connection.prepareCall(sql);
        stmt.setInt(1, entrainement.getId());
        //stmt.setString(2, entrainement.get());
       //stmt.setIdQuestionnaire("idQuestionnaire");
       //stmt.setId(id);
       //stmt.setIdCanal(idCanal);
            
        
        stmt.setInt(1, entrainement.getId());
        stmt.setInt(2, entrainement.getIdQuestionnaire());
        stmt.setInt(2, entrainement.getIdCanal());
        connection.close();
        
        
       stmt.execute();
      stmt.close();
    }





// on récupère les questionnaires

    public static Questionnaire getById(int idQuestionnaire, int IdCanal) throws SQLException {
        Questionnaire result = null;
        Connection connexion = Database.getConnection();
        String sql = "SELECT * FROM v_questionnaire_seance WHERE id_questionnaire = ? AND id_canal = ?";

        PreparedStatement stmt = connexion.prepareCall(sql);
        stmt.setInt(1, idQuestionnaire);
        stmt.setInt(2, IdCanal);
        ResultSet rs = stmt.executeQuery();
        // Variables pour construire l'Entrainement
        if (rs.next()) {
            result = new Questionnaire(//Besoin pour fonctionnalité lancerQuestionnaire

                    rs.getInt("id"),
                         rs.getString("libelle"),                         
                         rs.getInt("nbMinute"),
                         null,
                         rs.getInt("nbQuestions"),
                         rs.getInt("idCreateur")
                  
                    /*rs.getTime("nbMinute"),
                    rs.getTimestamp("debute_a").toLocalDateTime(),
                    rs.getTimestamp("finit_a").toLocalDateTime()*/
            );
        }
        return result;
    }

}
