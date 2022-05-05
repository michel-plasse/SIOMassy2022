/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controleur;

import dao.PersonneDao;
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
import modele.Personne;

/**
 *
 * @author Abdillahi
 */
@WebServlet(name = "InscriptionServlet", urlPatterns = {"/inscription"})
public class InscriptionServlet extends HttpServlet {

    private final static String VUE = "WEB-INF/inscription.jsp";
    private final static String VUE_OK = "WEB-INF/index.jsp";

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
        String vue = VUE; // soyons pessimistes :-)
        boolean isValid = true;
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String pwd = request.getParameter("pwd");
        String confPwd = request.getParameter("confPwd");
        String email = request.getParameter("email");
        String confEmail = request.getParameter("confEmail");
        String tel = request.getParameter("tel");
        if (nom == null || nom.trim().equals("")) {
            isValid = false;
            request.setAttribute("nomMsg", "Nom obligatoire");
        }
        if (prenom == null || prenom.trim().equals("")) {
            isValid = false;
            request.setAttribute("prenomMsg", "prenom obligatoire");
        }
        if (pwd == null || pwd.trim().equals("")) {
            isValid = false;
            request.setAttribute("pwdMsg", "Mot de passe obligatoire");
        }
        if (confPwd == null || !confPwd.equals(pwd)) {
            isValid = false;
            System.out.println("pwd = '" + pwd + "' conf='" +confPwd + "'");
            request.setAttribute("confPwdMsg", "Doit être identique au mot de passe");
        }
        if (email == null || email.trim().equals("")) {
            isValid = false;
            request.setAttribute("emailMsg", "email obligatoire");
        }
        if (confEmail == null || !confEmail.equals(email)) {
            isValid = false;
                System.out.println("email = '" + email + "' conf='" +confEmail + "'");
        request.setAttribute("confEmailMsg", "Doit être identique au email");
        }
        if (tel == null || nom.trim().equals("")) {
            isValid = false;
            request.setAttribute("telMsg", "Tel obligatoire");
        }
        System.out.println("valide : " + isValid);
        if (isValid) {
            try {
                System.out.println("valide");
                Personne user = new Personne(0, prenom, nom, email, tel, pwd);
                PersonneDao.insert(user);
                request.setAttribute("inscriptionMsg", "Vous êtes inscrit");
            }
            catch (SQLException ex) {
                Logger.getLogger(ConnexionServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("inscriptionMsg", ex.getMessage());
            }
        } else {
            System.out.println("invalide");
        }
        request.getRequestDispatcher(VUE).forward(request, response);
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
