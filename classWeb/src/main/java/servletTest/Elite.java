package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/elite")
public class Elite extends HttpServlet {
  private static final long serialVersionUID = -8987317198854163427L;

  public Elite() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // FirstFloorEnemy monster = new FirstFloorEnemy();
    //
    // html += "<div>";
    // html += "<button>";// 이거 누르면 타겟되게
    // html += monster.stageEliteData()[0].getName();
    // html += "</button>";
    //
    // html += "<span id=>";// 이부분 몹에 맞춰 변수로
    // html += monster.stageEliteData()[0].getHp();
    // html += "</span>";
    // html += "</div>";

    // html += "<button>";
    // html += "임시카드";
    // html += "</button>";

    // if (isEvent) {// 각이벤트마다 설정해주자
    // html += "<form action='dungeon'>";
    // html += "<button>";
    // html += "확인";
    // html += "</button>";
    // html += "</form>";
    // }

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

}
