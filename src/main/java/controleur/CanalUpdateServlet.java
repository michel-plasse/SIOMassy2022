package controleur;

import dao.CanalDao;
import modele.Canal;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hamcherif.ilyesse@gmail.com
 */
@WebServlet(name = "CanalUpdateServlet", urlPatterns = {"/modifier-canal"})
public class CanalUpdateServlet extends HttpServlet {
    private String VUE_SCANAL = "WEB-INF/modifierCanal.jsp";

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
        Canal canal = null;
        int idCanal = 0;
        try {
            idCanal = Integer.parseInt(request.getParameter("idCanal"));
            canal = CanalDao.getById(idCanal);
        }
        catch (SQLException ex) {
            Logger.getLogger(CanauxServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("canal", canal);
        request.getRequestDispatcher(VUE_SCANAL).forward(request, response);
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
        int memberId = 1;
        List<Canal> canaux = null;
        try {
            canaux = CanalDao.getAll();
        }
        catch (SQLException ex) {
            Logger.getLogger(CanauxServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("canaux", canaux);
        request.getRequestDispatcher(VUE_SCANAL).forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private int ParseInt(String parameter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}