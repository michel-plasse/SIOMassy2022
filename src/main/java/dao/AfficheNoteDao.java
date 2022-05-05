
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.Note;

public class AfficheNoteDao {
     
    public static List<Note> getNotesByIdEvaluation(int idEvaluation) throws SQLException {
        ArrayList<Note> result = new ArrayList<>();
        Connection connexion = Database.getConnection();
        String sql = "SELECT * FROM v_note_etudiant WHERE id_evaluation=?";
        PreparedStatement stmt = connexion.prepareCall(sql);
        stmt.setInt(1, idEvaluation);
        ResultSet rs = stmt.executeQuery();
        // Creation des groupes avec leurs membres
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
    
}
