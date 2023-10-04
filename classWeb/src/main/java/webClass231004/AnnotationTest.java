package webClass231004;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/AnnotationTest", "/AnnotationTest1"},
    initParams = {@WebInitParam(name = "a_test_name", value = "권"),
        @WebInitParam(name = "a_test_class", value = "Java 디지털 컨버전스")}) // 스트링밖에넣지못한다.
public class AnnotationTest extends HttpServlet {
  private static final long serialVersionUID = -1051890654362247310L;

  public AnnotationTest() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    response.getWriter().print(getInitParameter("a_test_name") + "<br/>");
    response.getWriter().print(getInitParameter("a_test_class") + "<br/>");
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }

}
