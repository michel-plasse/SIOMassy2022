package controleur;

import dao.NoteDao;
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
import modele.Note;

@WebServlet(name = "AfficheNote", urlPatterns = {"/AfficheNote"})
public class AfficheNotesServlet extends HttpServlet {
     private static final String VUE = "WEB-INF/afficheNote.jsp";
    private static final String VUE_ERREUR = "WEB-INF/message.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // choix de l'évaluation
        int idEvaluation = 1;
        List<Note> notes;
        // En dur pour l'instant
        notes = new ArrayList<>();
       
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
        request.getRequestDispatcher("WEB-INF/afficheNote.jsp").forward(request, response);
        String vue = VUE;
    }

}