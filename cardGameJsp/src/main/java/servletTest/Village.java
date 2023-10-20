package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servletTest.card.CardDAO;

@WebServlet("/village")
public class Village extends HttpServlet {
  private static final long serialVersionUID = 6370713015178192768L;

  public Village() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    CardDAO card = new CardDAO();
    for (int i = 0; i < card.DBLengthCheck("cardinventory"); i++) {
      if (card.getCard(i).getIsInDeck().equals("true")) {
        card.insertDeck(i, "cardinventory", "deck");
        System.out.println("왜전부들어가");
      }
    }
    response.sendRedirect("dungeon.jsp");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String temp = request.getParameter("card-index");

    int index = Integer.parseInt(temp);

    CardDAO card = new CardDAO();
    card.insertDeck(index, "villageshop", "cardinventory");

    response.sendRedirect("village.jsp");
  }

}
