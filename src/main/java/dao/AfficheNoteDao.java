
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modele.Note;

public class AfficheNoteDao {
     
    //Création de la méthode 
    public static List<Note> getNotesByIdEvaluation(int idEvaluation) throws SQLException {
        //Je crée ma liste de note
        ArrayList<Note> result = new ArrayList<>();
        //Je connecte la BDD
        Connection connexion = Database.getConnection();
        //Requete SQL Qui me permet de récuperer toute les info de note evaluation dans la bdd en fonction de l'evaluation
        String sql = "SELECT * FROM v_note_etudiant WHERE id_evaluation=?";
        //
        PreparedStatement stmt = connexion.prepareCall(sql);
        //
        stmt.setInt(1, idEvaluation);
        //
        ResultSet rs = stmt.executeQuery();
        //
        while (rs.next()) {
            // J'ajoute les membres a ma liste
            result.add(new Note(
                    rs.getInt("id_evaluation"),
                    rs.getInt("id_personne"),
                    rs.getString("prenom"),
                    rs.getString("nom"),
                    rs.getString("note")));
            
        }
        return result; //Je renvoie le resultat
    }
    
}
