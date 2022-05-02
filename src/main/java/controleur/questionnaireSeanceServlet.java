/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controleur;

import dao.QuestionnaireLanceDao;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele.Questionnaire;

/**
 *
 * @author ak
 */
@WebServlet(name = "questionnaireSeanceServlet", urlPatterns = {"/questionnaireSeance"})
public class questionnaireSeanceServlet extends HttpServlet {

    private static final String VUE = "WEB-INF/questionnaireSeance.jsp";
    private static final String VUE_ERREUR = "WEB-INF/message.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //pour tester en attendant l'intégration de choix dans la jsp canal:
        int idQUESTIONNAIRE = 1;
        int IDSEANCE = 4;
        /* int idquestionnaire = request.getParameter("idQUESTIONNAIRE");*/
 /* int idseance = request.getParameter("IDSEANCE");*/

        //HttpSession session = request.getSession();
        String vue = VUE;
        // Appeler la DAO
        try {
            Questionnaire questionDeSeance = QuestionnaireLanceDao.getById(idQUESTIONNAIRE, IDSEANCE);

            // Ajouter les données à la requête
            request.setAttribute("questionDeSeance", questionDeSeance);

        } catch (SQLException ex) {
            /*Logger.getLogger(EFGServlet.class.getName()).log(Level.SEVERE, null, ex);*/
            vue = VUE_ERREUR;
            request.setAttribute("message", "Pb avec la base de données");
        }
        // Passer la main à la vue
        request.getRequestDispatcher(vue).forward(request, response);
    }

    // on lance un  compte a rebours
    /*final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        final Runnable runnable = new Runnable() {
            int countdownStarter = getNbMinute();
            

            public void run() {

                System.out.println(countdownStarter);
                countdownStarter--;

                if (countdownStarter < 0) {
                    System.out.println("Timer Over!");
                    scheduler.shutdown();
                }
            }
        };
        scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);*/
}
