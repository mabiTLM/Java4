package webClass0927;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/to")
public class SecondServ extends HttpServlet {
  private static final long serialVersionUID = 1170634272639664372L;

  public SecondServ() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String temp = (String) request.getAttribute("key");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().append("<html><head><meta charset='UTF-8'/></head>");
    response.getWriter().append("from => to end" + temp);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }

}
