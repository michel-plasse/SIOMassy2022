package controleur;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CreerSondageServlet", urlPatterns = {"/creerSondage"})
public class CreerSondageServlet extends HttpServlet {
    private static final String VUE = "WEB-INF/creerSondage.jsp";
    private static final String VUE_ERREUR= "WEB-INF/message.jsp";

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
int idCanal= 1;
        // Passer directement à la vue
        request.getRequestDispatcher(VUE).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Mettre en post-it message
        request.setAttribute("message", "pas encore implémenté");
        // Passer la main à la vue
        request.getRequestDispatcher(VUE_ERREUR).forward(request, response);
    }

}