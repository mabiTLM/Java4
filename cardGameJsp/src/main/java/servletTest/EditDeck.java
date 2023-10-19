package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servletTest.card.CardDAO;

@WebServlet("/editDeck")
public class EditDeck extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public EditDeck() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String tempIndex = request.getParameter("card-index");
    String isInDeck = request.getParameter("is-in-deck");

    int index = Integer.parseInt(tempIndex);

    CardDAO card = new CardDAO();
    card.updateInventory(index, isInDeck);
    response.sendRedirect("editDeck.jsp");
  }

}
