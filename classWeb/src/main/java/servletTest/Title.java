package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/title")
public class Title extends HttpServlet {
  private static final long serialVersionUID = 4484831934382328816L;

  public Title() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // CardDAO card = new CardDAO();
    // card.totalCardInsert();
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
    html += "<a href='village'>";
    html += "<button style='text-align: center; font-size: 100px' onclick='newGame()'>";
    html += "새로운 시작";
    html += "</button>";
    html += "</a>";
    html += "</div>";
    html += "</body>";
    html += "</html>";
    response.getWriter().append(html);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }

}
