package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import makeCardGame230901.characterBundle.enemyBundle.EnemyCharacter;
import makeCardGame230901.characterBundle.enemyBundle.FirstFloorEnemy;

/**
 * Servlet implementation class Normal
 */
@WebServlet("/normal")
public class Normal extends HttpServlet {
  private static final long serialVersionUID = 178385972209299671L;
  private EnemyCharacter eArray;

  private EnemyCharacter[] encount() // 어떤 적을 만날지 정해주자
  {
    EnemyCharacter[] currentEnemy;
    eArray = new FirstFloorEnemy();
    int temp = (int) (Math.random() * 4 + 1);
    currentEnemy = new EnemyCharacter[temp];
    for (int i = 0; i < currentEnemy.length; i++) {
      int enemyNumberTemp = (int) (Math.random() * eArray.stageData().length);
      currentEnemy[i] = eArray.stageData()[enemyNumberTemp];
    }
    return currentEnemy;
  }

  public Normal() {
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
      EnemyCharacter c = monster.stageData()[i];// current
      html += "<span>";
      html += "<button onclick=target(" + i + ")>";// 체력이 다되면 없어져야하는데...
      html += c.getName();
      html += "</button>";
      html += "</span>";
      html += "<span>";
      html += "체력 : ";
      html += "<span id=monsterHp" + i + ">" + c.getHp() + "</span>";
      html += " 쉴드 : ";
      html += "<span id=monsterDef" + i + ">" + c.getDef() + "</span>";
      html += " 공격력 : " + c.getAtk() + " 속도 : " + c.getSpeed();
      html += "</span>";
      html += "<br>";
    }

    html += "</body>";
    html += "</html>";
    response.getWriter().append(html);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

}
