
 /** Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template*/
 
package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.EFG;

/**
 *
 * @author ak
 *
 */
public class EFGDao {
    
  public static EFG getByLoginPassword(String login, String password) throws SQLException {
    EFG result = null;
    Connection connection = Database.getConnection();
    String sql = "SELECT intitule,get.id_groupe, id_personne, id_canal FROM efg INNER JOIN groupe_efg ge on efg.id_efg=ge.id_efg INNER JOIN membre_groupe_efg mge on mge.id_efg=efg.id_efg WHERE email=? AND pwd=? GROUP BY id_efg" ;
    PreparedStatement stmt = connection.prepareCall(sql);
    stmt.setString(1, login);
    stmt.setString(2, password);
    ResultSet rs = stmt.executeQuery();
    if (rs.next()) {
      result = new EFG(
              rs.getInt("idEfg"),
              rs.getInt("idCanal"),
              rs.getString("intitule")); // pas d'EFG en mémoire
      
    }
    return result;
  }



 /*
public static void main(String[] args) {
    try {
           Class.forName("com.mysql.jdbc.Driver");
           // ouvrir la connection à la base de données
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost/SIOMassy2022?serverTimezone=UTC", "siomassy2022_user", "siomassy2022_pwd");
           //ouvrir un canal de communication pour lancer les requetes
           Statement canal = con.createStatement();
         
           //parcourir le tableau de resultat
           Statement canal2 = con.createStatement();
           canal2.executeUpdate("insert into efg values(5,'SHOW','2022-04-18 15:00:00',1, 1)");
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
   }*/

    /*Connection con=null;
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EFG efgs= new EFG();*/
		/*efgs.setIdEfg(request.getParameter("idEfg"));		
		efgs.setIdCanal(request.getParameter("idCanal"));*/
		/*efgs.setIntitule(request.getParameter("Intitule"));
		
		String idEfg=request.getParameter("IdEFG");
		String idCanal=request.getParameter("IdCanal");
                String intitule=request.getParameter("Intitulé");
		
		HttpSession session = request.getSession();
		EFG efg2 = (EFG) session.getAttribute("efg");
		if( efg2 == null ) { 
			efg2 = new EFG();
			session.setAttribute("efg", efg2);
		}
		int idefg = Integer.parseInt(idEfg);
                int Idcanal = Integer.parseInt(idCanal);
	
		efg2.afficheListe(efgs);
		
		try {
	           Class.forName("com.mysql.jdbc.Driver");
	           // ouvrir la connection à la base de données
	        con = DriverManager.getConnection("jdbc:mysql://localhost/banque?serverTimezone=UTC", "root", "");
	           //ouvrir un canal de communication pour lancer les requetes
	          Statement canal2 = con.createStatement();
  String query = "insert into efg values(5,'SHOW','2022-04-18 15:00:00',1, 1)";
int result = canal2.executeUpdate(query) ;
	            canal2.executeUpdate(query);
	            
	       } 
		catch (Exception e) {
	           System.out.println("pas trouvé la base");
	          System.out.println(e.getMessage()); 
	       }
		System.out.println(efgs);
		request.getRequestDispatcher("/afficheEFG.jsp").forward(request, response);
	}
/* apporté par testafficheefgdao*/
   /* public boolean find(long i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
*/
   
}


