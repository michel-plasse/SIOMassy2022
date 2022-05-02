/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.QuestionnaireDao;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Personne;
import modele.Questionnaire;

/**
 *
 * @author Stagiaire
 */
@WebServlet(name = "QuestionnairesServelet", urlPatterns = {"/questionnaires"})
public class QuestionnairesServlet extends HttpServlet {

  private static final String VUE = "WEB-INF/questionnairesFormateur.jsp";
  private static final String VUE_ERREUR = "WEB-INF/message.jsp";

  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    Personne user = (Personne) request.getSession(true).getAttribute("user");
    // Verifier que user !=null, sinon renvoyer vers connexion
    List<Questionnaire> questionnaires;
    String vue = VUE;
    try {
      questionnaires = QuestionnaireDao.getByIdFormateur(user.getId());
      request.setAttribute("questionnaires", questionnaires);
    } catch (SQLException ex) {
      Logger.getLogger(QuestionnairesServlet.class.getName()).log(Level.SEVERE, null, ex);
      request.setAttribute("message", "Pb avec la base de données. Voir le journal");
      vue = VUE_ERREUR;
    }
    request.getRequestDispatcher(vue).forward(request, response);
  }

}
