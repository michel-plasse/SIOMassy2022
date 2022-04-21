/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controleur;


import java.io.IOException;
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
 * @author SALL Mouhamadou
 */
@WebServlet(name = "MembresServlet", urlPatterns = {"/membres"})
public class MembresCanalServlet extends HttpServlet {
    
  private static final String VUE = "WEB-INF/membresCanal.jsp";
  
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Personne membre= new Personne(1, "Mouhamadou", "SALL","sallmouha10@gmail.com",null,null);
        List<Personne> membres = new ArrayList<Personne>();
        membres.add(membre);
        membre= new Personne(2, "Cheik", "Lanick","mohamedcheikhlanick@gmail.com",null,null);
        membres.add(membre);
        membre= new Personne(3, "Karim", "Amhri", "karim@yohoo.fr", null, null);
        membres.add(membre);
        request.setAttribute("membres" , membres);
        request.getRequestDispatcher(VUE).forward(request, response);
      
    }
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher(VUE).forward(request, response);
    }
}