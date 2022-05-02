/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Personne;
import modele.Reponse;
import modele.Sondage;

/**
 *
 * @author Stagiaire
 */
@WebServlet(name = "SondagesServlet", urlPatterns = {"/sondages"})
public class SondagesServlet extends HttpServlet {
    private static final String VUE = "WEB-INF/sondages.jsp";
    
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
        // Données d'abord en dur
        List<Sondage> sondages = new ArrayList<Sondage>();
        Personne createur = new Personne(1, "Dieynaba", "Kante");
        sondages.add(new Sondage(1, 1, 1, "Do you follow me ?", createur));
        sondages.add(new Sondage(2, 1, 1, "On fait la pause maintenant ?", createur));
        // Les fournir a la vue
        request.setAttribute("sondages", sondages);
        // Passer la main à la vue
        request.getRequestDispatcher(VUE).forward(request, response);
    }
      
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        // Données d'abord en dur
       int idQuestion=1;
       int idOption=1;
       String libelle;
       
        
        // Les fournir a la vue
//        request.setAttribute("sondages", sondages);
        // Passer la main à la vue
        request.getRequestDispatcher(VUE).forward(request, response);
    }
}
