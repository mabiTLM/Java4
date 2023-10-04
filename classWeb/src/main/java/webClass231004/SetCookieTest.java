package webClass231004;

import java.io.IOException;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SetCookieTest")
public class SetCookieTest extends HttpServlet {
  private static final long serialVersionUID = 5509185376723754440L;

  public SetCookieTest() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    Cookie cookie = new Cookie("test-cookie", URLEncoder.encode("now testing cookies", "utf-8"));
    // cookie.setMaxAge(10);
    cookie.setMaxAge(-1);

    HttpSession session = request.getSession();
    response.addCookie(cookie);
    response.getWriter().print(session.getAttribute("testing"));
    response.getWriter().print(request.getAttribute("userId"));
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
