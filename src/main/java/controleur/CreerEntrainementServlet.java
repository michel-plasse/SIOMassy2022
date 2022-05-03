package controleur;

import dao.CanalDao;
import dao.EntrainementDao;
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
        
        request.getRequestDispatcher(vue).forward(request, response);
        int idQuestionnaire=1;
        request.setAttribute("idQuestionnaire", idQuestionnaire);
         idQuestionnaire = Integer.parseInt(request.getParameter("idQuestionnaire"));//On obtient l'id depus la jsp EFGs.jsp
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    
    
    
    
    @Override
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idQuestionnaire;
        int idCanal;
        int id=0;
        
        try {
            
        
        idQuestionnaire= Integer.parseInt("idQuestionnaire");
        idCanal= Integer.parseInt("idCanal");
        idQuestionnaire = Integer.parseInt(request.getParameter("idQuestionnaire"));
         idCanal = Integer.parseInt(request.getParameter("id_canal"));
        //Entrainement entrainement= new Entrainement("int id_entrainement","idQuestionnaire","idCanal");
        //Entrainement entrainement= new Entrainement(int id,idQuestionnaire,null/*dCanal*/       /*);
        //insertEntrainement
      HttpSession session = request.getSession();
        Object entrainement=null;
        //Questionnaire question = (Question) session.getAttribute("idQuestionnaire");
        request.setAttribute("entrainement", entrainement);
        entrainement = EntrainementDao.insert(id,
                idQuestionnaire,
                idCanal);
        String vue = VUE; // soyons pessimistes :-)
        }catch (NumberFormatException ex) {
            request.setAttribute("message", "idefg doit être un entier");

        } catch (SQLException ex) {
            Logger.getLogger(EFGServlet.class.getName()).log(Level.SEVERE, null, ex);
            
            request.setAttribute("message", "Pb avec la base de données");
            
        }
        
        
        boolean isValid = true;
         idQuestionnaire = Integer.parseInt(request.getParameter("idQuestionnaire"));// en atendant de vérifier la compli soit correcte
        if (idQuestionnaire <0 /*|| idQuestionR.trim().equals("")*/) {
           isValid = false;
            request.setAttribute("message", "Problème d'intégration d'un numéro");
        }
        System.out.println("ok! " + isValid);
        if (isValid) {
            try {
      CanalDao.insert(idQuestionnaire);
                      request.setAttribute("canalMsg", "Le canal a bien été crée !");
            }
            catch (SQLException ex) {
                Logger.getLogger(CreerCanalServlet.class.getName()).log(Level.SEVERE, null, ex);
                request.setAttribute("canalMsg", ex.getMessage());
            }
        } else {
            System.out.println("Invalide !");
        }
        
        request.getRequestDispatcher(VUE).forward(request, response);
            
    
    }}

    /**
     *Le controleur permet de lister les questionnaires et de poster un questionnaire dans une séance ou un canal
     *
     * @return Controleur d'affichage des canaux dans un entrainement et intègre le questionnaire dans le canal
     */


