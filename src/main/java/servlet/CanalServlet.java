
package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CanalServlet.java")
public class CanalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con=null;
	public CanalServlet() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ouvrir la connection à la base de données
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siomassy2022?serverTimezone=UTC", "siomassy2022_user@localhost", "siomassy2022_pwd");
			//ouvrir un canal de communication pour lancer les requetes
		}catch (Exception e) {
			System.out.println("ça ne marche pas");
			System.out.println(e.getMessage());
		}

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session=request.getSession();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			// ouvrir la connection à la base de données
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/siomassy20222?serverTimezone=UTC", "siomassy2022_user@localhost", "siomassy2022_pwd");
			//ouvrir un canal de communication pour lancer les requetes
			Statement canal = con.createStatement();
			canal.executeUpdate("SELECT * FROM canal");

		}
		catch (Exception e) {
			System.out.println("ça ne marche pas");
			System.out.println(e.getMessage());
		}

		getServletContext().getRequestDispatcher("/Canaljsp.jsp").forward(request, response);
	}

}
