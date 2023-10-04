package webClass231004;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SetServletContext")
public class SetServletContext extends HttpServlet {
  private static final long serialVersionUID = -5541571553053558704L;

  public SetServletContext() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    ServletContext context = getServletContext();

    List testArr = new ArrayList();
    testArr.add("아무거나");
    testArr.add(123);

    context.setAttribute("test", "아몰랑, 아무거나");
    context.setAttribute("testArr", testArr);

    response.getWriter().print("입력완료");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
