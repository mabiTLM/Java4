package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import makeCardGame230901.cardBundle.TotalCardBase;

@WebServlet("/village")
public class Village extends HttpServlet {
  /**
   * 
   */
  private static final long serialVersionUID = 6370713015178192768L;

  public Village() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    response.getWriter().append("<!DOCTYPE html>"
        + "<html lang=\"ko\">"
        + "  <head>"
        + "    <meta charset=\"UTF-8\" />"
        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />"
        + "    <title>Document</title>"
        + "    <script src=\"/scripts/makeCardGame.js\"></script>"
        + "    <link rel=\"stylesheet\" href=\"/styles/style.css\" />"
        + "  </head>"
        + "  <body>"
        + "    <button id=\"editDeck\" onclick=\"watchCard()\">덱수정</button>"
        + "    <button id=\"editDeck\" onclick=\"add(1)\">카드추가</button>"
        + "    <button>상점</button>"
        + "    <a href=\"dungeon\"><button>모험으로</button></a>"
        + "  </body>"
        + "</html>"
        + "");
  }
//TotalCardBase card = new TotalCardBase();
//response.getWriter().append(card.watchCardData(card.totalCard()).replace("\n", "<br>"));

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);

  }

}
