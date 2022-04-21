package controleur;


import dao.CanalDao;
import java.io.IOException;
import java.sql.SQLException;
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
        String vue = VUE; // soyons pessimistes :-)
        boolean isValid = true;
        String nom = request.getParameter("nom");
        if (nom == null || nom.trim().equals("")) {
            isValid = false;
            request.setAttribute("nomMsg", "Un nom est obligatoire pour la création d'un canal !");
        }
        System.out.println("Valide : " + isValid);
        if (isValid) {
            try {
                System.out.println("Valide !");
                Canal canal = new Canal(0, nom);
                CanalDao.insert(canal);
                request.setAttribute("canalMsg", "Le canal a bien été crée !");
            }
            catch (SQLException ex) {
                Logger.getLogger(ConnexionServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("canalMsg", ex.getMessage());
            }
        } else {
            System.out.println("Invalide !");
        }
        request.getRequestDispatcher(VUE).forward(request, response);
    }

}