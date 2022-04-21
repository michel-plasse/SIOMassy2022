package controleur;

import dao.Database;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Formateur
 */
@WebServlet(name = "ResetDbServlet", urlPatterns = {"/resetDb"})
public class ResetDbServlet extends HttpServlet {
  private final static String VUE = "/WEB-INF/message.jsp";
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
      try {
        Database.reset(LocalDateTime.now());
        response.sendRedirect(request.getContextPath());
      } catch (SQLException ex) {
        Logger.getLogger(ResetDbServlet.class.getName()).log(Level.SEVERE, null, ex);
        request.setAttribute("message", ex.getMessage());
        request.getRequestDispatcher(VUE).forward(request, response);
      }

    }


}
