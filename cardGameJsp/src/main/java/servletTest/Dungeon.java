package servletTest;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import makeCardGame230901.mapBundle.FirstFloor;

@WebServlet("/dungeon")
public class Dungeon extends HttpServlet {
  private static final long serialVersionUID = 6758670203372055408L;

  private static boolean makeDungeon = true;
  private int[] playerLocation = {13, 3};
  FirstFloor make = new FirstFloor();


  public Dungeon() {
    super();
  }

  public void setMakeDungeon(boolean makeDungeon) {
    this.makeDungeon = makeDungeon;
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    response.setCharacterEncoding("UTF-8");
    if (makeDungeon) {
      make.makeFirstMap();
      makeDungeon = false;
    }

    int[][] mapData = make.getFirstMap();

    request.setAttribute("mapData", mapData);
    request.setAttribute("playerLocation", playerLocation);
    ServletContext app = this.getServletContext();
    RequestDispatcher dispatcher = app.getRequestDispatcher("/dungeon.jsp");
    try {
      dispatcher.forward(request, response);
    } catch (ServletException e) {
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


  }
}
