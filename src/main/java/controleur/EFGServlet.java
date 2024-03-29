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
import javax.servlet.http.HttpSession;
import modele.EFG;
import modele.Groupe;

/**
 *
 * @author Formateur
 */
@WebServlet(name = "EFGServlet", urlPatterns = {"/EFG"})
public class EFGServlet extends HttpServlet {

    private static final String VUE = "WEB-INF/EFG.jsp";
    private static final String VUE_ERREUR = "WEB-INF/message.jsp";

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

        //pour tester en attendant l'intégration de choix dans la jsp canal:
        int idEFG;
        String vue = VUE_ERREUR;
        try {
            idEFG = Integer.parseInt(request.getParameter("idEFG"));
            HttpSession session = request.getSession();
            request.setAttribute("idEFG", idEFG);
            // Appeler la DAO
            EFG efg = EFGDao.getById(idEFG);
            // Ajouter les données à la requête
            request.setAttribute("efg", efg);
            vue = VUE;
        }
        catch (NumberFormatException ex) {
            request.setAttribute("message", "idefg doit être un entier");

        } catch (SQLException ex) {
            Logger.getLogger(EFGServlet.class.getName()).log(Level.SEVERE, null, ex);
            
            request.setAttribute("message", "Pb avec la base de données");
            
        }
        // Passer la main à la vue
        request.getRequestDispatcher(vue).forward(request, response);
    }
     /**
     *Le controleur permet d'afficher les EFG en les triant par ordre  croissant de leur id EFG et par membres au sein de chaque groupe
     *
     * @return Controleur d'affichage d'un EFG, des groupes et des membres.
     */
}


