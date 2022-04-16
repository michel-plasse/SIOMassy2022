/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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

/**
 *
 * @author Abdillahi
 */
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/inscription"})
public class InscriptionServlet extends HttpServlet {

    private final static String VUE = "WEB-INF/inscription.jsp";
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
         Personne personne= new Personne(8, "Abdillahi", "Hassan","abdihassan@gmail.com","0612345678","Abdi20158,");
        List<Personne> membres = new ArrayList<Personne>();
        membres.add(personne);
        personne= new Personne(9, "Cheik", "Lanick","mohamedcheikhlanick@gmail.com","0712345678","Cheik258");
        membres.add(personne);
        request.setAttribute("membres" , membres);
        request.getRequestDispatcher(VUE).forward(request, response);
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
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
