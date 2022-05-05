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
        String vue = VUE_ERREUR;
        int idQuestionnaire = Integer.parseInt(request.getParameter("idQuestionnaire"));//On obtient l'id depus la jsp EFGs.jsp
        int id = 4;
        int idCanal = 2;
        //int idQuestionnaire= 2;

        try {

            //Questionnaire  questionnaire    = EntrainementDao.GetByIdQuestionnaire(idQuestionnaire);
            // Mettre en post-it message
            Questionnaire q;
            q = EntrainementDao.getById(idQuestionnaire, idCanal);
            idQuestionnaire = 1;
            id = 3;
            idCanal = 1;
            idCanal = Integer.parseInt(request.getParameter("idCanal"));
            idQuestionnaire = Integer.parseInt(request.getParameter("idQuestionnaire"));
            id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("idQuestionnaire", idQuestionnaire);
            id = 4;
            idCanal = 2;
            idQuestionnaire = 2;

            vue = VUE;
        } catch (NumberFormatException ex) {
            request.setAttribute("message", "idQuestionnaire doit être un entier");// Exception en cas d'entrée d'une chaine de caractère au lieu d'un chiffre
        } catch (SQLException ex) {
            Logger.getLogger(CreerEntrainementServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "PB base de données. Voir journal");// message de retour d'erreur en cas de problème avec la base de données par exemple
        }

        request.getRequestDispatcher(vue).forward(request, response);
// test pour récupérer un questionnaire
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//        int id=3;
        //       int idCanal= 2;
//        int idQuestionnaire= 1;
        int idCanal = Integer.parseInt(request.getParameter("idCanal"));
        int idQuestionnaire = Integer.parseInt(request.getParameter("idQuestionnaire"));
        //Entrainement entrainement= new Entrainement(idEntrainement,idQuestionnaire,idCanal);

        String vue = VUE_ERREUR;
        try {
            EntrainementDao.insert(new Entrainement(0, idQuestionnaire, idCanal));
            request.setAttribute("message", "Entrainement créé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Création du questionaire");
        request.getRequestDispatcher(vue).forward(request, response);
    }
    //entrainement= EntrainementDao.Update();
    // Mettre en post-it message
//        Questionnaire q;
//          q=EntrainementDao.getById(idQuestionnaire);
    //idQuestionnaire =Integer.parseInt(request.getParameter("idQuestionnaire"));
    //id= Integer.parseInt(request.getParameter("id"));
    //idCanal = Integer.parseInt(request.getParameter("idCanal"));
//       int idCanal= Integer.parseInt(request.getParameter("idCanal"));
//        int idQuestionnaire= Integer.parseInt(request.getParameter("idQuestionnaire"));
//        int id= Integer.parseInt(request.getParameter("id"));

}
