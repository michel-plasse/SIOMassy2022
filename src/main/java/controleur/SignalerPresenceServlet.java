/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controleur;

import dao.SeanceDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Personne;



@WebServlet(name = "SignalerPresenceServlet", urlPatterns = {"/signalerPresence"})
public class SignalerPresenceServlet extends HttpServlet {

    private static final String VUE = "WEB-INF/signalerPresence.jsp";
    private static final String VUE_ERREUR = "WEB-INF/message.jsp";

  @Override   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      // Passer directement à la vue
      request.getRequestDispatcher(VUE).forward(request, response);
   }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        Personne user = (Personne) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("connexion");
        } else {
            int idPersonne = user.getId();
            boolean estPresent = true;
            try {
                int idCanal = Integer.parseInt(request.getParameter("idCanal"));
                int idSeance = Integer.parseInt(request.getParameter("idSeance"));
                request.setAttribute("idSeance", idSeance);
                //int niveauParticipation = 1;
                SeanceDao.setPresent(idSeance, idPersonne, estPresent);
                response.sendRedirect("canal?idCanal=" + idCanal);
            } catch (SQLException ex) {
                Logger.getLogger(SignalerPresenceServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("message", "Pb avec la base de données");
                request.getRequestDispatcher(VUE_ERREUR).forward(request, response);
            }
        }
    }

}
