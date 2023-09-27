package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/village")
public class Village extends HttpServlet {
  private static final long serialVersionUID = 6370713015178192768L;

  public Village() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    String html = "";
    html += "<!DOCTYPE html>";
    html += "<html lang='ko'>";
    html += "  <head>";
    html += "    <meta charset='UTF-8' />";
    html += "    <meta name='viewport' content='width=device-width, initial-scale=1.0' />";
    html += "    <title>Document</title>";
    html += "    <script src='scripts/makeCardGame.js'></script>";
    // html += " <link rel='stylesheet' href='styles/style.css' />";
    html += "  </head>";
    html += "  <body>";
    html += "    <button id='editDeck' onclick='watchCard()'>덱수정</button>";
    html += "    <button id='editDeck' onclick='add(1)'>카드추가</button>";
    html += "    <button>상점</button>";
    html += "    <a href='dungeon'><button>모험으로</button></a>";
    html += "  </body>";
    html += "</html>";

    response.getWriter().append(html);
  }
  // TotalCardBase card = new TotalCardBase();
  // response.getWriter().append(card.watchCardData(card.totalCard()).replace("\n", "<br>"));

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);

  }

}
