package webClass0927;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/from")
public class FirstServ extends HttpServlet {

  private static final long serialVersionUID = -7687457789407480300L;

  public FirstServ() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // response.sendRedirect("to");
    // response.addHeader("Refresh", "1,url=to");
    // response.getWriter().append("<script>location.href='to'</script>");

    request.setAttribute("key", "값");
    request.setAttribute("key2", new ArrayList<String>());

    RequestDispatcher dispatch = request.getRequestDispatcher("to");
    dispatch.forward(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
