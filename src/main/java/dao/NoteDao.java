
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.Canal;
import modele.Note;


public class NoteDao {

    public static List<Note> getNotesByIdEvaluation(int idEvaluation) throws SQLException {
        ArrayList<Note> result = new ArrayList<>(); // 
        Connection connexion = Database.getConnection(); // 
        String sql = "SELECT * FROM v_note_etudiant WHERE id_evaluation=?"; //
        PreparedStatement stmt = connexion.prepareCall(sql); // 
        stmt.setInt(1, idEvaluation);
        ResultSet rs = stmt.executeQuery();// excecute requete sql
        // 
        while (rs.next()) {
            // Dans tous les cas, ajouter le membre au groupe courant
            result.add(new Note(
                    rs.getInt("id_evaluation"),
                    rs.getInt("id_personne"),
                    rs.getString("prenom"),
                    rs.getString("nom"),
                    rs.getString("note")));
            /*System.out.println(groupes);*/
        }
        return result;
    }
    /**
     * 
     * @param note
     * @param idEtudiant
     * @param idEvaluation
     * @return
     * @throws SQLException 
     */
    public static Note update(String note, int idEtudiant, int idEvaluation) throws SQLException {
       
        Connection connection = Database.getConnection();
        String sql = "INSERT INTO note_evaluation(id_etudiant, id_evaluation, note) VALUES(?,?,?) ON DUPLICATE KEY UPDATE note=?";
        PreparedStatement stmt = connection.prepareCall(sql);//
        stmt.setString(1, "note");
        stmt.setInt(2, idEtudiant);
        stmt.setInt(3, idEvaluation);
        stmt.executeUpdate();//excute la requete 
        stmt.execute();
        ResultSet rs = null;
        rs = stmt.getGeneratedKeys();
        rs = stmt.executeQuery();
        if(rs.next() ){ 
            Note notes = new Note( // instancier les notes 
                    
            rs.getInt("idEvaluation"),
            rs.getInt("idEtudiant"),
            rs.getString("prenom"),
            rs.getString("nom"),
            rs.getString("note")
            );
        };
        return null;
    
    }
}
