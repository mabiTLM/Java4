package servletTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServ extends HttpServlet {

  /**
   * 
   */
  private static final long serialVersionUID = -6417956420648078883L;

  @Override
  public void init() throws ServletException {
    System.out.println("두번째 컨테이너");

  }

  @Override
  public void destroy() {
    System.out.println("부순다");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
      throws ServletException, IOException {
    System.out.println("2번겟");
  }


}
