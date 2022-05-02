/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controleur;

import dao.EFGDao;
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
import modele.EFG;

/**
 *
 * @author adem romdhane
 */
@WebServlet(name = "EFGsServlet", urlPatterns = {"/EFGs"})
public class EFGsServlet extends HttpServlet {

    private final static String VUE = "/WEB-INF/EFGs.jsp";
    private final static String VUE_ERREUR = "/WEB-INF/message.jsp";

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
        int idCanal = 1;
        String vue = VUE;
        try {
            List<EFG> efgs = EFGDao.getAllByIdCanal(idCanal);
            // Ajouter les données à la requête
            request.setAttribute("exercices", efgs);
            System.out.println("nb efgs " + efgs.size());
        } catch (SQLException ex) {
            Logger.getLogger(EFGsServlet.class.getName()).log(Level.SEVERE, null, ex);
            vue = VUE_ERREUR;
            request.setAttribute("message", "Pb avec la base de données");
        }
        // Passer la main à la vue
        request.getRequestDispatcher(vue).forward(request, response);
    }

}
