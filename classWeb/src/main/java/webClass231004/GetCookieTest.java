package webClass231004;

import java.io.IOException;
import java.net.URLDecoder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetCookieTest")
public class GetCookieTest extends HttpServlet {

  private static final long serialVersionUID = -1231220047673832874L;

  public GetCookieTest() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; ++i) {
      if (cookies[i].getName().equals("test-cookie")) {
        cookies[i].setMaxAge(-1);
        response.getWriter().print(URLDecoder.decode(cookies[i].getValue(), "utf-8"));
        response.addCookie(cookies[i]);
      }
    }
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

  }

}
