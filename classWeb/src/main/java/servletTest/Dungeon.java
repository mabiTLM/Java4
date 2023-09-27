package servletTest;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dungeon")
public class Dungeon extends HttpServlet {

  private boolean makeDungeon = true;
  private int firstMap[][] = new int[14][7];

  private static final long serialVersionUID = 6758670203372055408L;

  public Dungeon() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {// 여기다 맵표시
    if (makeDungeon) {
      Random random = new Random();
      for (int i = 0; i < 14; i++) {
        for (int j = 0; j < 7; j++) {
          int roomPercent = random.nextInt(100);
          int roomType = 0;
          if (i == 14 - 1) {
            continue;
          }
          if (roomPercent >= 92)// 강한몹
          {
            roomType = 1;
          } else if (roomPercent >= 39)// 일반몹1
          {
            roomType = 2;
          } else if (roomPercent >= 17)// 이벤트
          {
            roomType = 3;
          } else if (roomPercent >= 5)// 불
          {
            roomType = 4;
          } else if (roomPercent >= 0)// 상점
          {
            roomType = 5;
          }

          firstMap[i][j] = roomType;
        }
      }
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {// 이벤트발생하면 여기서 처리
  }
}
