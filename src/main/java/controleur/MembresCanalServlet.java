package controleur;

import dao.CanalDao;
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
import javax.servlet.http.HttpSession;
import modele.Personne;

/**
 *
 * @author SALL Mouhamadou
 */
@WebServlet(name = "MembresServlet", urlPatterns = {"/membres"})
public class MembresCanalServlet extends HttpServlet {

    private static final String VUE = "WEB-INF/membresCanal.jsp";
    private static final String VUE_ERREUR = "WEB-INF/message.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*Personne membre= new Personne(1, "Mouhamadou", "SALL","sallmouha10@gmail.com",null,null);
        List<Personne> membres = new ArrayList<Personne>();
        membres.add(membre);
        membre= new Personne(2, "Cheik", "Lanick","mohamedcheikhlanick@gmail.com",null,null);
        membres.add(membre);
        membre= new Personne(3, "Karim", "Amhri", "karim@yohoo.fr", null, null);
        membres.add(membre);
        request.setAttribute("membres" , membres);*/
        String vue = VUE;
        int idCanal=1;
        HttpSession session = request.getSession();
        // Appeller la Dao
        try {
            List<Personne> membres = CanalDao.getMembresByIdCanal(idCanal);
            System.out.println("nb de membres : " + membres.size());
            request.setAttribute("idCanal", idCanal);
            request.setAttribute("membres", membres);
        } catch (SQLException ex) {
            System.out.println("pb bd");
            Logger.getLogger(MembresCanalServlet.class.getName()).log(Level.SEVERE, null, ex);
            vue = VUE_ERREUR;
            request.setAttribute("message", "Pb avec la base de données");
        }
        //response.sendRedirect("membresCanal.jsp");
        request.getRequestDispatcher(vue).forward(request, response);
    }
    
    
    
    
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String supprime = request.getParameter("supprimeMembre");
        
        request.getRequestDispatcher(VUE).forward(request, response);
    }
}
