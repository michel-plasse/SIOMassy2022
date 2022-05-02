/** Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import modele.EFG;
import modele.Groupe;

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
        // Variables pour construire l'EFG
        Groupe groupe = null; // groupe courant (indéfini au début)
        int idGroupe = 0; // son id (indéfini au début, donc mis à 0)
        List<Groupe> groupes = new ArrayList<Groupe>();
        // Creation des groupes avec leurs membres
        while (rs.next()) {
            // Récupérer les infos de l'EFG (une seule fois)
            if (rs.isFirst()) {
                Personne createur = new Personne(
                        rs.getInt("id_createur"),
                        rs.getString("prenom_createur"),
                        rs.getString("nom_createur"));
                result = new EFG(idEFG, createur, rs.getInt("id_canal"), groupes,
                        rs.getString("intitule"), rs.getTimestamp("cree_a").toLocalDateTime());
            }
            // Créer un nouveau groupe si le id_groupe change dans le result set
            if (idGroupe != rs.getInt("id_groupe")) {
                groupe = new Groupe(
                        idEFG, rs.getInt("id_groupe"),
                        null,
                        new ArrayList<Personne>());
                idGroupe = rs.getInt("id_groupe");
                groupes.add(groupe);
            }
            // Dans tous les cas, ajouter le membre au groupe courant
            Personne personne = new Personne(
                    rs.getInt("id_personne"),
                    rs.getString("prenom"),
                    rs.getString("nom"));
            groupe.getMembres().add(personne);
            /*System.out.println(groupes);*/
        }
        return result;
    }

    public static List<EFG> getAllByIdCanal(int idCanal) throws SQLException {
        List<EFG> resultat = new ArrayList<>();
        Connection connexion = Database.getConnection();
        String sql = "SELECT * FROM efg WHERE id_canal = ?";
        PreparedStatement stmt = connexion.prepareCall(sql);
        stmt.setInt(1, idCanal);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            resultat.add(new EFG(
                    rs.getInt("id_efg"),
                    rs.getInt("id_canal"),
                    rs.getString("intitule")
            ));
        }
        return resultat;
    }
}
