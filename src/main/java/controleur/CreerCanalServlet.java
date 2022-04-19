import dao.CanalDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author https://github.com/ilyessehamcherif
 */
@WebServlet(name = "CreerCanalServlet", urlPatterns = {"/creerCanal"})
public class CreerCanalServlet extends HttpServlet {
    private static final String VUE = "WEB-INF/creerCanal.jsp";
    private static final String VUE_ERREUR= "WEB-INF/message.jsp";

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
        /**
        // Passer directement à la vue
        int idCanal = 1;
        String vue = VUE;
        // Appeler la DAO
        Canal canal = null;
        try {
            canal = CanalDao.insert(idCanal);
            // Ajouter les données à la requête
            request.setAttribute("canal", canal);
            request.setAttribute("idCanal", idCanal);
        } 
        catch (SQLException ex) {
            Logger.getLogger(CreerCanalServlet.class.getName()).log(Level.SEVERE, null, ex);
            vue = VUE_ERREUR;
            request.setAttribute("message", "Problème avec la base de données !");
        }
        // Passer la main à la vue
        request.getRequestDispatcher(vue).forward(request, response);
        */
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
        /**
        // Mettre en post-it message
        request.setAttribute("message", "Pas encore implémenté");
        // Passer la main à la vue
        request.getRequestDispatcher(VUE_ERREUR).forward(request, response);
        */
        request.setAttribute("message", "pas encore implémenté");
        // Passer la main à la vue
        request.getRequestDispatcher(VUE_ERREUR).forward(request, response);
    }

}