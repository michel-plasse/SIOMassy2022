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
        // choix de l'évaluation
        String vue = VUE;
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
        request.getRequestDispatcher(VUE).forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
        //int idEvaluation =Integer.parseInt(request.getParameter("idEvaluation"));
        // note= Integer.parseInt(request.getParameter("note"));
        String note= request.getParameter("note");
        request.setAttribute("note", note);
        request.setAttribute("idEtudiant", idEtudiant);
      //  request.setAttribute("idEvaluation", idEvaluation);
        try {
         //   NoteDao.update(note, idEtudiant, idEvaluation);
             NoteDao.update(note, idEtudiant,2);
        } catch (SQLException ex) {
            Logger.getLogger(SaisirNotesServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
        
        
        
        
        System.out.println("je suis dans le doPost");
        // Mettre en post-it message
        request.setAttribute("message", "pas encore implémenté");
        System.out.println("note :" + request.getParameter("note"));
        // Passer la main à la vue
        response.sendRedirect(request.getRequestURL().toString() + "?idEvaluation="
                + request.getParameter("idEvaluation"));
        
        //request.getRequestDispatcher("/accueil.jsp").forward(request, response);
    }

}
