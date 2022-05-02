/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import dao.EvaluationDao;
import java.io.IOException;
import java.io.PrintWriter;
import static java.sql.JDBCType.NULL;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Evaluation;

/**
 *
 * @author utilisateur
 */
@WebServlet(name = "evaluationFormateurServlet", urlPatterns = {"/evaluationFormateur"})
public class EvaluationFormateurServlet extends HttpServlet {

    private static final String VUE = "WEB-INF/evaluations.jsp";
    private static final String VUE_ERREUR = "WEB-INF/message.jsp";


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String vue = VUE;
        int idUser = 1;
            List<Evaluation> evalutions;
        try {
            evalutions = EvaluationDao.getById(idUser);
            request.setAttribute("evalutions", evalutions);
            request.setAttribute("idUser", idUser);
        } catch (SQLException ex) {
            Logger.getLogger(EvaluationFormateurServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("message", "Probleme avec la base de donnée");
            vue = VUE_ERREUR;
        }
        request.getRequestDispatcher(vue).forward(request, response);
    }

}
