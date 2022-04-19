/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


/**
 *
 * @author ak
 */

package controleur;

import dao.EFGDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.EFG;

/**
 *
 * @author Formateur
 */
@WebServlet(name = "EFGAfficheServlet", urlPatterns = {"/afficheEFG"})
public class EFGAfficheServlet extends HttpServlet {
    private static final String VUE = "WEB-INF/afficheEFG.jsp";
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
        // Passer directement à la vue
       
        request.getRequestDispatcher(VUE).forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Mettre en post-it message
        request.setAttribute("message", "pas encore implémenté");
        // Passer la main à la vue
        request.getRequestDispatcher(VUE_ERREUR).forward(request, response);
        
    }

}
    

   

