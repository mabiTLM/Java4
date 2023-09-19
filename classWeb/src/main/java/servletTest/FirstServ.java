package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// HttpServlet extends GenericServlet : HTTP 기능을 갖고 있는 클래스;
// GenericServlet implements Servlet, ServletConfig : 공통된 서블릿
// Servlet : 서블릿 기본 메서드를 포함
// ServletConfig : 기본 기능을 포함한다.

public class FirstServ extends HttpServlet {
  /**
   * 
   */
  private static final long serialVersionUID = -4117815483902930367L;

  @Override
  public void init() throws ServletException {
    System.out.println("요청 받아서 컨테이너 세팅");
  }

  @Override
  public void destroy() {
    System.out.println("컨테이너 종료 시 삭제");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    System.out.println("Get 받았음");
  }
}
