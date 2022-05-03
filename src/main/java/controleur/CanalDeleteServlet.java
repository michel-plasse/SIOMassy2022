package controleur;

import dao.CanalDao;
import modele.Canal;
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

/**
 *
 * @author hamcherif.ilyesse@gmail.com
 */
@WebServlet(name = "CanalDeleteServlet", urlPatterns = {"/supprimer-canal"})
public class CanalDeleteServlet extends HttpServlet {
    private String VUE_CANAL = "WEB-INF/supprimerCanal.jsp";

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
        request.getRequestDispatcher(VUE_CANAL).forward(request, response);
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
		String nom = request.getParameter("nom");
                try {
			CanalDao.delete(new Canal(1,  nom));
		} catch (SQLException ex) {

		}
           response.sendRedirect("canaux");
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