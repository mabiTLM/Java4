package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import makeCardGame230901.mapBundle.FirstFloor;

@WebServlet("/dungeon")
public class Dungeon extends HttpServlet {

  private boolean makeDungeon = true;
  private boolean isEvent = false;
  FirstFloor make = new FirstFloor();
  private static final long serialVersionUID = 6758670203372055408L;

  public Dungeon() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {// 여기다 맵표시
    if (makeDungeon) {
      make.makeFirstMap();
      makeDungeon = false;
    }
    int[][] temp = make.getFirstMap();

    response.setCharacterEncoding("UTF-8");
    String html = "";
    html += "<!DOCTYPE html>";
    html += "<html lang='ko'>";
    html += "<head>";
    html += "<meta charset='UTF-8' />";
    html += "<meta name='viewport' content='width=device-width, initial-scale=1.0' />";
    html += "<title>던전</title>";
    html += "<script src='scripts/makeCardGame.js'></script>";
    html += "<link rel='stylesheet' href='styles/style.css' />";
    html += "</head>";
    html += "<body>";

    for (int i = 0; i < temp.length; i++) {
      html += "<div>";
      for (int j = 0; j < temp[0].length; j++) {
        html += "<form action='dungeon' method='post'>";
        html += "<input type = 'hidden' name ='event' value = '" + temp[i][j] + "'/>";
        html += "<button>";
        if (temp[i][j] == 1) {
          html += "엘리트";
        } else if (temp[i][j] == 2) {
          html += "일반몹";
        } else if (temp[i][j] == 3) {
          html += "이벤트";
        } else if (temp[i][j] == 4) {
          html += "모닥불";
        } else if (temp[i][j] == 5) {
          html += "상_점";
        }
        html += "</button>";
        html += "</form>";
      }
      html += "<br>";
      html += "</div>";
    }

    html += "</body>";
    html += "</html>";
    response.getWriter().append(html);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {// 이벤트발생하면 여기서 처리

    int temp = Integer.parseInt(request.getParameter("event"));
    response.setCharacterEncoding("UTF-8");
    if (temp == 1) {
      response.sendRedirect("elite");
    } else if (temp == 2) {
      response.sendRedirect("normal");
    } else if (temp == 3) {
      response.sendRedirect("event");
    } else if (temp == 4) {
      response.sendRedirect("fire");
    } else if (temp == 5) {
      response.sendRedirect("dungeonShop");
    }
  }
}
