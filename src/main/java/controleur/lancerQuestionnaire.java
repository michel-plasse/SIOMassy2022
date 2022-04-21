/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controleur;

import dao.QuestionnaireDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.QuestionnaireEntrainement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ak
 */
@WebServlet(name = "Question", urlPatterns = {"/Question"})
public class lancerQuestionnaire extends HttpServlet {

    private final static String VUE = "WEB-INF/Question.jsp";
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
        request.getRequestDispatcher(VUE).forward(request, response);
        /*QuestionnaireEntrainement questionnaire=new QuestionnaireEntrainement();
        questionnaire=null;*/
     String idquestionnaire = request.getParameter("idQuestionnaire");
    int idQuestionnaire = Integer.parseInt(idquestionnaire);
String vue = VUE;
    QuestionnaireEntrainement questionnaire = null;
    try {
      questionnaire = QuestionnaireDao.getById(idQuestionnaire);
      // Ajouter les données à la requête
      request.setAttribute("questionnaire", questionnaire);
    } catch (SQLException ex) {
      Logger.getLogger(EFGServlet.class.getName()).log(Level.SEVERE, null, ex);
      vue = VUE_ERREUR;
      request.setAttribute("message", "Pb avec la base de données");
    }
    // Passer la main à la vue
    request.getRequestDispatcher(vue).forward(request, response);
  }

}


