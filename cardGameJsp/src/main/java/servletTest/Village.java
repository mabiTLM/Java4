package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servletTest.card.CardDAO;
import servletTest.deck.DeckDAO;

@WebServlet("/village")
public class Village extends HttpServlet {
  private static final long serialVersionUID = 6370713015178192768L;

  public Village() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    CardDAO card = new CardDAO();
    DeckDAO deck = new DeckDAO();
    try {
      deck.dropTableDeck();
    } catch (Exception e) {
      e.printStackTrace();
    }

    deck.createTableDeck();

    for (int i = 0; i < card.dBLengthCheck("cardinventory"); i++) {
      if (card.getCard(i).getIsInDeck().equals("true")) {
        card.insertDeck(i, "cardinventory", "deck");
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
