package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateServ
 */
@WebServlet("/CreateServ")
public class CreateServ extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = 665207091866922583L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public CreateServ() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub

    // response.sendRedirect("./first");

    response.setCharacterEncoding("UTF-8");

    response.getWriter().append("<html>").append("<head>")
        .append("<meta charset='UTF-8'/>" + "<title>테스트중</title>" + "</head><html>")
        .append(request.getContentType());

    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
