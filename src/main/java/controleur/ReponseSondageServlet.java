package controleur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ReponseSondageServlet", urlPatterns = {"/reponsesSondage"})
public class ReponseSondageServlet extends HttpServlet {

  private static final String VUE = "WEB-INF/reponsesSondage.jsp";

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    request.getRequestDispatcher(VUE).forward(request, response);
  }

}
