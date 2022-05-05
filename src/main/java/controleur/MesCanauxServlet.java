package controleur;

import dao.CanalDao;
import modele.Canal;
import modele.Personne;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Sert à récupérer l'id de l'utilisateur connecté
 * @author hamcherif.ilyesse@gmail.com
 */
@WebServlet(name = "MesCanauxServlet", urlPatterns = {"/mes-canaux"})
public class MesCanauxServlet extends HttpServlet {

    private String VUE_MESCANAUX = "WEB-INF/mesCanaux.jsp";

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
        
        // Recupérer le id de l'utilisateur connecte
        HttpSession session = request.getSession(true);
        Personne user = (Personne) session.getAttribute("user");
        if (user == null) {
            
            // Stocker la page demandée pour rediriger l'utilisateur vers elle après la connextion
            session.setAttribute("askedUrlBeforeConnection", request.getRequestURI());
            
            // Rediriger vers la connexion
            response.sendRedirect("connexion");
        } 
        else {
            
            // On récuperer les canaux grâce à l'id de l'utilisateur
            List<Canal> canaux = CanalDao.getByUserId(user.getId());
            
            // On met les données des canaux en post-it de la requête avec le nom "canaux"
            request.setAttribute("canaux", canaux);
            
            // Affiche la VUE
            request.getRequestDispatcher(VUE_MESCANAUX).forward(request, response);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}