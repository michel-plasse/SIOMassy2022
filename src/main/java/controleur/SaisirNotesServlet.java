
package controleur;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.Note;


@WebServlet(name = "SaisirNotesServlet", urlPatterns = {"/saisirNotes"})
public class SaisirNotesServlet extends HttpServlet {
    
    private static final String VUE = "WEB-INF/editNotes.jsp";
    private static final String VUE_ERREUR= "WEB-INF/message.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Passer directement à la vue
        int idEvaluation = 1;
        List<Note> notes = new ArrayList<>();
        request.setAttribute("idEvaluation", idEvaluation);
        request.setAttribute("notes", notes);
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
