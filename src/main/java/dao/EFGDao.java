
 /** Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
 
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modele.QuestionnaireEntrainement;

/**
 *
 * @author ak
 *
 */
public class EFGDao {
    
  public static QuestionnaireEntrainement getByLoginPassword(String login, String password) throws SQLException {
    QuestionnaireEntrainement result = null;
    Connection connection = Database.getConnection();
    String sql = "SELECT intitule,get.id_groupe, id_personne, id_canal FROM efg INNER JOIN groupe_efg ge on efg.id_efg=ge.id_efg INNER JOIN membre_groupe_efg mge on mge.id_efg=efg.id_efg WHERE email=? AND pwd=? GROUP BY id_efg" ;
    PreparedStatement stmt = connection.prepareCall(sql);
    stmt.setString(1, login);
    stmt.setString(2, password);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
      result = new QuestionnaireEntrainement(
              rs.getInt("idEfg"),
              rs.getInt("idCreateur"),
              rs.getInt("idCanal"),
              rs.getString("intitule")); // pas d'EFG en mémoire
      
    }
    return result;
  }

}





/*
public static void main(String[] args) {
     try {
           Class.forName("com.mysql.jdbc.Driver");
           // ouvrir la connection à la base de données
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/elevejava?serverTimezone=UTC", "root", "password");
           //ouvrir un canal de communication pour lancer les requetes
           Statement canal = con.createStatement();
         
           //parcourir le tableau de resultat
           Statement canal2 = con.createStatement();
           canal2.executeUpdate("insert into eleves values(5,'SOW','Ahmet',20)");
           ResultSet resultat=canal.executeQuery("Select * from eleves");
           while(resultat.next()) {
           
            String Nom=resultat.getString("nom");
            String Prenom=resultat.getString("prenom");
            int Age=resultat.getInt("age");
            System.out.println(Nom+" "+Prenom+" "+Age);
           }
       } catch (Exception e) {
           System.out.println("pas trouvé la base");
           // a mettre dans le syso e.getMessage()
       }

       System.out.println("tout va bien");
   }

}*/
