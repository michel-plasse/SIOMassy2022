
package controleur;

import dao.SeanceDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Seance;

@WebServlet(name = "SeanceServlet", urlPatterns = {"/SeanceServlet"})
public class SeanceServlet extends HttpServlet {

   private static final String VUE = "WEB-INF/demarrerSeance.jsp";
  private static final String VUE_ERREUR = "WEB-INF/message.jsp";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    String vue = VUE;
    Seance Seance;
       int idSeance = 0;
    
       try {
       Seance = SeanceDao.getByIdSeance(idSeance);
    // Mettre en post-it les données
    request.setAttribute("idSeance", Seance);
    Object seance = null;
    request.setAttribute("seance", seance);   
    
  
  
  } catch (SQLException exc) {
      Logger.getLogger(SeanceServlet.class.getName()).log(Level.SEVERE, null, exc);
      request.setAttribute("message", "Pb de base de données");
      vue = VUE_ERREUR;
    }   
    request.getRequestDispatcher(vue).forward(request, response);
  }
}

