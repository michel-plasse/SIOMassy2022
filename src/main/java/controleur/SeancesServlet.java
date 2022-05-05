package controleur;

import dao.SeanceDao;
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
import modele.Seance;

/**
 *
 * @author hamcherif.ilyesse@gmail.com
 */
@WebServlet(name = "SeancesServlet", urlPatterns = {"/seances"})
public class SeancesServlet extends HttpServlet {
  private String VUE_SEANCES = "WEB-INF/seances.jsp";

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
        int memberId = 1;
        List<Seance> seances = null;
        try {
            seances = SeanceDao.getAll();
        }
          catch (SQLException ex) {
            Logger.getLogger(SeancesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("seances", seances);
        request.getRequestDispatcher(VUE_SEANCES).forward(request, response);
    }
}