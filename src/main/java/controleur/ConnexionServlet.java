/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.PersonneDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modele.Personne;

/**
 *
 * @author plasse
 */
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/connexion"})
public class ConnexionServlet extends HttpServlet {

  private static final String VUE_FORM = "WEB-INF/connexion.jsp";
  private static final String VUE_OK = "index.jsp";

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
    request.getRequestDispatcher(VUE_FORM).forward(request, response);
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
  protected void doPost(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
    String vue = VUE_FORM; // soyons pessimistes :-)
    try {
      // Recuperer la session http
      HttpSession session = request.getSession();
      if ("deconnecter".equals(request.getParameter("action"))) {
        // Oublier le user
        session.setMaxInactiveInterval(1); // so it expires in 1 second
        session.invalidate();
        // Redirige vers la page d'accueil
        response.sendRedirect(request.getServletContext().getContextPath());
        return; // Pour eviter de continuer le traitement
      } else {
        boolean isValid = true;
        String login = request.getParameter("login");
        String pwd = request.getParameter("pwd");
        if (login == null || login.trim().equals("")) {
          isValid = false;
          request.setAttribute("loginMsg", "Login obligatoire");
        }
        if (pwd == null || pwd.trim().equals("")) {
          isValid = false;
          request.setAttribute("pwdMsg", "Mot de passe obligatoire");
        }
        if (isValid) {
          Personne user = PersonneDao.getByLoginPassword(login, pwd);
          if (user != null) {
            //Ajouter le user à la session
            session.setAttribute("user", user);
            // URL demandée avant de se connecter
            String askedUrl = (String) session.getAttribute("askedUrlBeforeConnection");
            if (askedUrl != null) {
              response.sendRedirect(askedUrl);
              return;
            } else {
              vue = VUE_OK;
            }
          } else {
            request.setAttribute("connexionMsg", "Utilisateur inconnu");
          }
        }
      }
    } catch (SQLException ex) {
      Logger.getLogger(ConnexionServlet.class.getName()).log(Level.SEVERE, null, ex);
      request.setAttribute("connexionMsg", ex.getMessage());
    }
    request.getRequestDispatcher(vue).forward(request, response);
  }

}
