package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import makeCardGame230901.cardBundle.TotalCardBase;


@WebServlet("/MakeNew")
public class MakeNew extends HttpServlet {
  /**
   * 
   */
  private static final long serialVersionUID = 6370713015178192768L;

  public MakeNew() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    response.getWriter().append("<html>").append("<head>")
        .append("<meta charset='UTF-8'/>" + "<title>게임</title>");
    TotalCardBase card = new TotalCardBase();
    response.getWriter().append(card.watchCardData(card.totalCard()).replace("\n", "<br>"));
    System.out.println("확인용");
    response.getWriter().append("</head><html>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
