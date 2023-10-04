package webClass231004;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/SessionTest")
public class SessionTest extends HttpServlet {
  private static final long serialVersionUID = 4497456532829335084L;

  public SessionTest() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession();
    // 암호화한다 16진수 32글자
    response.setContentType("text/html;charset=utf-8");
    response.getWriter().println(session.getId() + "<br/>");
    response.getWriter().println(session.getCreationTime() + "<br/>");
    response.getWriter().println(session.getMaxInactiveInterval() + "<br/>");
    response.getWriter().println(session.getLastAccessedTime() + "<br/>");
    response.getWriter().println(session.getAttribute("test-session") + "<br/>");

    session.setMaxInactiveInterval(10);

    session.setAttribute("test-session", "하이염");

    // session.invalidate(); // 세션을 즉시 삭제한다.
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
