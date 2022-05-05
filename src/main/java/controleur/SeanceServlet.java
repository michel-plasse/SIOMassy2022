/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.SeanceDao;
import modele.Seance;
import modele.Personne;
import java.io.IOException;
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
 * @author hamcherif.ilyesse@gmail.com
 */
@WebServlet(name = "SeanceServlet", urlPatterns = {"/seance"})
public class SeanceServlet extends HttpServlet {

    private static final String VUE_SEANCE = "WEB-INF/seance.jsp";

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
        
        // Données en dur pour l'instant
        Seance seance = new Seance(1, 1, LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(2));
        Personne personne = new Personne(1, "Ilyesse", "Hamcherif");
        request.setAttribute("seance", seance);
        request.setAttribute("personne", personne);
        request.getRequestDispatcher(VUE_SEANCE).forward(request, response);
    }

}