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
import dao.NoteDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SaisirNotesServlet", urlPatterns = {"/saisirNotes"})
public class SaisirNotesServlet extends HttpServlet {

    private static final String VUE = "WEB-INF/editNotes.jsp";
    private static final String VUE_ERREUR = "WEB-INF/message.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Passer directement à la vuenotes = new ArrayList<>();
        int idEvaluation = 1;
        List<Note> notes;
        // En dur pour l'instant
        notes = new ArrayList<>();
        //notes.add(new Note(1, 3, "prenom", "nom", 10));
        //notes.add(new Note(1, 4, "prenom2", "nom2", 12));
       
        try {
            notes = NoteDao.getNotesByIdEvaluation(idEvaluation);
            System.out.println("nb de notes " + notes.size());
            request.setAttribute("idEvaluation", idEvaluation);
            request.setAttribute("notes", notes);

        }catch (SQLException ex) {
           Logger.getLogger(SaisirNotesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("idEvaluation", idEvaluation);
        request.setAttribute("notes", notes);
        request.getRequestDispatcher(VUE).forward(request, response);
        String vue = VUE;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Mettre en post-it message
        request.setAttribute("message", "pas encore implémenté");
        System.out.println("note :" + request.getParameter("note"));
        // Passer la main à la vue
        //request.getRequestDispatcher(VUE_ERREUR).forward(request, response);
        response.sendRedirect(request.getRequestURL().toString() + "?idEvaluation="
                + request.getParameter("idEvaluation"));
    }

}
