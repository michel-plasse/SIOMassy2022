package controleur;

import dao.CanalDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Canal;

/**
 *
 * @author ak
 */
@WebServlet(name = "CreerEntrainementServlet", urlPatterns = {"/creerEntrainement"})
public class CreerEntrainementServlet extends HttpServlet {

    private static final String VUE = "WEB-INF/creerEntrainement.jsp";
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
        String vue = VUE_ERREUR;
        try {
            int idQuestionnaire = Integer.parseInt(request.getParameter("idQuestionnaire"));
            List<Canal> canaux = CanalDao.getAll();
            request.setAttribute("canaux", canaux);
            vue = VUE;
        } catch (NumberFormatException ex) {
            request.setAttribute("message", "idQuestionnaire doit être un entier");
        } catch (SQLException ex) {
            Logger.getLogger(CreerEntrainementServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "PB base de données. Voir journal");
        }
        request.getRequestDispatcher(vue).forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
