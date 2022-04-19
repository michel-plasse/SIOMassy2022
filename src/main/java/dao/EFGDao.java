/** Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import modele.EFG;
import modele.Groupe;
import modele.Membre;
import modele.Personne;

/**
 *
 * @author ak
 *
 */
public class EFGDao {

    public static EFG getById(int idEFG) throws SQLException {
        EFG result = null;
        Connection connexion = Database.getConnection();
        String sql = "SELECT * FROM v_efg_groupes_membres WHERE id_efg = ?";
        PreparedStatement stmt = connexion.prepareCall(sql);
        stmt.setInt(1, idEFG);
        ResultSet rs = stmt.executeQuery();
        boolean createurCree = false;
        int idGroupe = 0;
        Groupe groupe = null;
        List<Groupe> groupes = new ArrayList<Groupe>();
        while (rs.next()) {
            Personne personne = new Personne(
                    rs.getInt("id_personne"),
                    rs.getString("prenom"),
                    rs.getString("nom")
            );
            if (idGroupe != rs.getInt("id_groupe")) {
                groupe = new Groupe(idEFG, rs.getInt("id_groupe"), null, new ArrayList<Personne>());
                idGroupe = rs.getInt("id_groupe");
                groupes.add(groupe);
            }
            groupe.getMembres().add(personne);
        }
        if (groupes.size() != 0) {
            result = new EFG(
                    idEFG,
                    /*rs.getInt("id"), */
                    null,
                    1, //rs.getInt("id_canal"),
                    groupes,
                    "in titulé", //rs.getString("intitule"),
                    LocalDateTime.now()); //rs.getTimestamp("cree_a").toLocalDateTime());
        }
        return result;
    }

}
