/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import modele.Seance;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CanauxServlet", urlPatterns = {"/canaux"})
public class CanauxServlet extends HttpServlet {

  private static final String VUE = "WEB-INF/canaux.jsp";

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
    // D'abord en dur (il faudra chercher les données via la Dao)
    List<Canal> canaux = new ArrayList<>();
    canaux.add(new Canal(1, "SIO 2021 projet"));
    canaux.add(new Canal(2, "SIO 2021 java"));
    canaux.add(new Canal(3, "CDA 2021"));
    request.setAttribute("canaux", canaux);
    request.getRequestDispatcher(VUE).forward(request, response);
  }

}
