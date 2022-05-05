/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import modele.Seance;
import java.io.IOException;
import java.time.LocalDateTime;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Canal;

/**
 *
 * @author Formateur
 */
@WebServlet(name = "CanalServlet", urlPatterns = {"/canal"})
public class CanalServlet extends HttpServlet {

    private static final String VUE = "WEB-INF/canal.jsp";

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        Canal canal = new Canal(1, "Canal 1");
        Seance seance = new Seance(1, 1, LocalDateTime.now().minusHours(1), LocalDateTime.now().plusHours(2));
        request.setAttribute("canal", canal);
        request.setAttribute("seance", seance);
        request.getRequestDispatcher(VUE).forward(request, response);
    }

}
