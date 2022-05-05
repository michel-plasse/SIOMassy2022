package controleur;

import dao.CanalDao;
import dao.EntrainementDao;
import dao.QuestionnaireDao;
import java.io.IOException;
import java.io.PrintWriter;
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
import modele.Canal;
import modele.Entrainement;
import modele.Questionnaire;

/**
 *
 * @author ak
 */
@WebServlet(name = "CreerEntrainementServlet", urlPatterns = {"/creerEntrainement"})
public class CreerEntrainementServlet extends HttpServlet {

    private static final String VUE = "WEB-INF/creerEntrainement.jsp";
    private static final String VUE_ERREUR = "WEB-INF/message.jsp";

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vue = VUE_ERREUR;
        int idQuestionnaire=3;
        int id=4;
        int idCanal= 2;
         
        try {
            
            List<Canal> canaux = CanalDao.getAll();// nous obtenons la liste à partir de la DAO Créée pour gérer les canaux
            request.setAttribute("canaux", canaux);
            
            
            vue = VUE;
        } catch (NumberFormatException ex) {
            request.setAttribute("message", "idQuestionnaire doit être un entier");// Exception en cas d'entrée d'une chaine de caractère au lieu d'un chiffre
        } catch (SQLException ex) {
            Logger.getLogger(CreerEntrainementServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "PB base de données. Voir journal");// message de retour d'erreur en cas de problème avec la base de données par exemple
        }
        // test pour récupérer un questionnaire
        try {
        // Mettre en post-it message
        idQuestionnaire =Integer.parseInt(request.getParameter("id"));
        //idCanal =Integer.parseInt(request.getParameter("idCanal"));
        idCanal=1;
         HttpSession session = request.getSession();
         
        Questionnaire q;
          q=EntrainementDao.getById(idQuestionnaire,idCanal);
     
        request.setAttribute("q", q);
          /* id=4;
         idCanal= 2;
         idQuestionnaire= 2;*/
            
            vue = VUE;
        } catch (NumberFormatException ex) {
            request.setAttribute("message", "idQuestionnaire doit être un entier");// Exception en cas d'entrée d'une chaine de caractère au lieu d'un chiffre
        } catch (SQLException ex) {
            Logger.getLogger(CreerEntrainementServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "PB base de données. Voir journal");// message de retour d'erreur en cas de problème avec la base de données par exemple
        }
        
       
    request.getRequestDispatcher(vue).forward(request, response);

    }
    

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       
        int idCanal= Integer.parseInt(request.getParameter("idCanal"));
        int idQuestionnaire= Integer.parseInt(request.getParameter("idQuestionnaire"));
        int id= Integer.parseInt(request.getParameter("id"));
   
     //Entrainement entrainement= new Entrainement(idEntrainement,idQuestionnaire,idCanal);
     
        String vue = VUE_ERREUR;
        try {
            
       
        HttpSession session = request.getSession();
           System.out.println("valide");

        Entrainement entrainement;
        entrainement= EntrainementDao.insert(id,idQuestionnaire,idCanal);
       request.setAttribute("entrainement", id);
        request.setAttribute("idCanal", idCanal);
        request.setAttribute("idQuestionnaire", idQuestionnaire);
        request.setAttribute("entrainement", entrainement);
       
        System.out.println("Création du questionaire");
        entrainement= EntrainementDao.Update(entrainement);
        // Mettre en post-it message
        Questionnaire q;
          q=EntrainementDao.getById(idQuestionnaire,idCanal);
        //idQuestionnaire =Integer.parseInt(request.getParameter("idQuestionnaire"));
       //id= Integer.parseInt(request.getParameter("id"));
       //idCanal = Integer.parseInt(request.getParameter("idCanal"));
        idCanal= Integer.parseInt(request.getParameter("idCanal"));
         idQuestionnaire= Integer.parseInt(request.getParameter("idQuestionnaire"));
         id= Integer.parseInt(request.getParameter("id"));
        
        vue = VUE;
        
        } catch (SQLException ex) {
            Logger.getLogger(SaisirNotesServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
        
        
        System.out.println("entrainement:" + request.getParameter("note"));
        // Passer la main à la vue
        response.sendRedirect(request.getRequestURL().toString() + "?idCanal="
                + request.getParameter("idQuestionnaire"));
        
        request.getRequestDispatcher(VUE).forward(request, response);
    }

}