package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servletTest.card.CardDAO;

@WebServlet("/title")
public class Title extends HttpServlet {
  private static final long serialVersionUID = 4484831934382328816L;

  public Title() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String temp = request.getParameter("start");

    if (temp.equals("새로운 시작")) {
      CardDAO card = new CardDAO();
      card.newStart();
      for (int i = 0; i < 4; i++) {
        card.insertDeck(0, "card", "cardInventory");
        card.insertDeck(1, "card", "cardInventory");
      }

      response.sendRedirect("village.jsp");

    } else if (temp.equals("이어하기")) {
      response.sendRedirect("village.jsp");
    }
  }
}
