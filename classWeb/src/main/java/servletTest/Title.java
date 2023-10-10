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

    response.setCharacterEncoding("UTF-8");
    String html = "";
    html += "<!DOCTYPE html>";
    html += "<html lang='ko'>";
    html += "<head>";
    html += "<meta charset='UTF-8' />";
    html += "<meta name='viewport' content='width=device-width, initial-scale=1.0' />";
    html += "<title>시작화면</title>";
    html += "<script src='scripts/makeCardGame.js'></script>";
    html += "<link rel='stylesheet' href='styles/style.css' />";
    html += "</head>";
    html += "<body>";
    html += "<div>";
    html += "<form action='title' method='post'>";
    html +=
        "<input type='submit' name='start' value='새로운 시작' style='text-align: center; font-size: 100px'>";
    html += "</form>";
    html += "</br>";
    html += "<form action='title' method='post'>";
    html +=
        "<input type='submit' name='start' value='이어하기' style='text-align: center; font-size: 100px'>";
    html += "</form>";
    html += "</div>";
    html += "</body>";
    html += "</html>";
    response.getWriter().append(html);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String temp = request.getParameter("start");

    if (temp.equals("새로운 시작")) {
      CardDAO card = new CardDAO();
      card.newStart();
      for (int i = 0; i < 4; i++) {
        card.insertDeck(1, "card", "deck");
        card.insertDeck(2, "card", "deck");
      }
      response.sendRedirect("village.jsp");

    } else if (temp.equals("이어하기")) {
      response.sendRedirect("village.jsp");
    }

  }

}
