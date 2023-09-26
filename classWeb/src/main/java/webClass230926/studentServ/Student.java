package webClass230926.studentServ;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webClass230926.student.StudentDAO;
import webClass230926.student.StudentVO;

@WebServlet("/student")
public class Student extends HttpServlet {

  private static final long serialVersionUID = 4979268612911450776L;

  public Student() {
    super();
  }

  public void init(ServletConfig config) throws ServletException {}

  public void destroy() {}

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    StudentDAO dao = new StudentDAO();
    List<StudentVO> list = dao.getList();
    System.out.println(list.size());
    response.setCharacterEncoding("UTF-8");
    String html = "<html>";
    html += "<head>";
    html += "<meta charset='UTF-8'/>";
    html += "<title>";
    html += "학생 목록";
    html += "</title>";
    html += "</head>";
    html += "<body>";
    html += "<ol>";
    for (int i = 0; i < list.size(); ++i) {
      html += "<li>";
      html += list.get(i).getName();
      html += "</li>";
    }
    html += "</ol>";
    html += "</body>";
    html += "</html>";
    response.getWriter().append(html);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }

}
