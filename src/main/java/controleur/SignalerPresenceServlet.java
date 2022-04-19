/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controleur;

import dao.SeanceDao;
import java.io.IOException;
import java.io.PrintWriter;
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
 * @author SALL Mouhamadou
 */
@WebServlet(name = "SignalerPresenceServlet", urlPatterns = {"/signalerPresence"})
public class SignalerPresenceServlet extends HttpServlet {

    private static final String VUE = "WEB-INF/signalerPresence.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Passer directement à la vue
        request.getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //int idSeance = Integer.parseInt(request.getParameter("idSeance"));
        int idSeance = 1;
        int idPersonne = 1;
        boolean estPresent = true;
        int niveauParticipation = 1;
        try {
            SeanceDao.setPresent(idSeance, idPersonne, estPresent);
        } catch (SQLException ex) {
            Logger.getLogger(SignalerPresenceServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("idSeance", idSeance);
        request.setAttribute("idPersonne", idPersonne);
        request.getRequestDispatcher(VUE).forward(request, response);

    }

}
