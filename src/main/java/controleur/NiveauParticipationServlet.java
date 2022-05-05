/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Stagiaire
 */
@WebServlet(name = "NiveauServlet", urlPatterns = {"/modifierParticipations"})
public class NiveauParticipationServlet extends HttpServlet {

  private static final String VUE = "WEB-INF/niveauParticipation.jsp";
  private static final String VUE_ERREUR = "WEB-INF/message.jsp";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.getRequestDispatcher(VUE).forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String vue = VUE;
    HttpSession session = request.getSession(true);
    if (session.getAttribute("user") == null) {
      response.sendRedirect("connexion");
    } else {
      try {
        int idPersonne = Integer.parseInt(request.getParameter("idPersonne"));
        int idSeance = Integer.parseInt(request.getParameter("idSeance"));
        int niveauParticipation = Integer.parseInt(request.getParameter("niveau"));
        SeanceDao.setParticipation(idSeance, idPersonne, niveauParticipation);
        response.sendRedirect("canaux");
      } catch (SQLException ex) {
        Logger.getLogger(NiveauParticipationServlet.class.getName()).log(Level.SEVERE, null, ex);
        request.setAttribute("message", "Pb avec la BD. Voir journal");
        request.getRequestDispatcher(VUE_ERREUR).forward(request, response);
      }
    }
  }
}
