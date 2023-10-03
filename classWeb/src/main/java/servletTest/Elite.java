package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import makeCardGame230901.characterBundle.enemyBundle.EnemyCharacter;
import makeCardGame230901.characterBundle.enemyBundle.FirstFloorEnemy;

@WebServlet("/elite")
public class Elite extends HttpServlet {
  private static final long serialVersionUID = -8987317198854163427L;

  private EnemyCharacter eArray;

  public EnemyCharacter[] encount() // 어떤 적을 만날지 정해주자
  {
    EnemyCharacter[] currentEnemy;
    eArray = new FirstFloorEnemy();
    int temp = (int) (Math.random() * 2 + 1);
    currentEnemy = new EnemyCharacter[temp];
    for (int i = 0; i < currentEnemy.length; i++) {
      int enemyNumberTemp = (int) (Math.random() * eArray.stageEliteData().length);
      currentEnemy[i] = eArray.stageEliteData()[enemyNumberTemp];
    }
    return currentEnemy;
  }


  public Elite() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    FirstFloorEnemy monster = new FirstFloorEnemy();

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

    for (int i = 0; i < encount().length; i++) {
      EnemyCharacter c = monster.stageEliteData()[i];// current
      html += "<span>";
      html += "<button>";// 이거 누르면 타겟되게
      html += c.getName();
      html += "</button>";
      html += "</span>";
      html += "<span id=monsterHp" + i + ">";
      html += "체력 : " + c.getHp() + " 쉴드 : " + c.getDef() + " 공격력 : " + c.getAtk() + " 속도 : "
          + c.getSpeed();
      html += "</span>";
      html += "<br>";
    }
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

    html += "</body>";
    html += "</html>";
    response.getWriter().append(html);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

}
