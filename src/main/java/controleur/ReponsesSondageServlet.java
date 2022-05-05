package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Sondage;
import dao.SondageDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
* Affiche la jsp reponsesSondage.jsp si tou se passe bien
* Au cas contraire ça redirige vers message.jsp qui indique qu'il y a une erreur 
*/

@WebServlet(name = "ReponsesSondageServlet", urlPatterns = {"/reponsesSondage"})
public class ReponsesSondageServlet extends HttpServlet {

  private static final String VUE = "WEB-INF/reponsesSondage.jsp";
  private static final String VUE_ERREUR = "WEB-INF/message.jsp";

/**
* Dans le doGet on instancie idSondage et on fait appel à la Dao pour recuperer idSondage et la liste de Sondage
* Si tout se passe bien ça affiche reponsesSondage.jsp sinon ça affichera un msg d'erreur qui indiquera un probleme avec la base de donnée
*/

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    int idSondage = 1;
    String vue = VUE;
    try {
      Sondage sondage = SondageDao.getByIdSondage(idSondage);

      // Mettre en post-it les données
      request.setAttribute("idSondage", idSondage);
      request.setAttribute("sondage", sondage);
    } catch (SQLException exc) {
      Logger.getLogger(SignalerPresenceServlet.class.getName()).log(Level.SEVERE, null, exc);
      request.setAttribute("message", "Pb de base de données");
      vue = VUE_ERREUR;
    }   
    request.getRequestDispatcher(vue).forward(request, response);
  }
  
  

}
