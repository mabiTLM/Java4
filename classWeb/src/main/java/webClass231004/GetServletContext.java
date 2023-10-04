package webClass231004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetServletContext")
public class GetServletContext extends HttpServlet {
  private static final long serialVersionUID = 8260562218735453673L;

  public GetServletContext() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html;charset=utf-8");
    ServletContext context = getServletContext();

    List testArr = (ArrayList) context.getAttribute("testArr");

    InputStream is = context.getResourceAsStream("/WEB-INF/bin/test.txt");
    BufferedReader br = new BufferedReader(new InputStreamReader(is));

    StringTokenizer st = new StringTokenizer(br.readLine(), ",");

    response.getWriter().print(context.getAttribute("test") + "<br />");
    response.getWriter().print(testArr.get(0) + "<br />");
    response.getWriter().print(((Integer) testArr.get(1)) + "<br />");
    response.getWriter().print(context.getInitParameter("test_xml") + "<br />");
    response.getWriter().print(br.readLine() + "<br />");
    response.getWriter().print(st.nextToken() + "<br />");
    response.getWriter().print(st.nextToken() + "<br />");
    st.nextToken();
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
