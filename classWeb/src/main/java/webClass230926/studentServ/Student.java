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
    // System.out.println("id : " + request.getParameter("id"));
    StudentDAO dao = new StudentDAO();
    List<StudentVO> list = dao.getList();
    StudentVO student = null;
    if (request.getParameter("id") != null) {
      student = dao.getStudent(Integer.parseInt(request.getParameter("id")));
    }
    // System.out.println(list.size());
    response.setCharacterEncoding("UTF-8");
    String html = "<html>";
    html += "<head>";
    html += "<meta charset='UTF-8'/>";
    html += "<title>";
    html += "학생 목록";
    html += "</title>";
    html += "</head>";
    html += "<body>";

    if (student == null) {
      html += "<form action = 'student' method='post'>";
      html += "<input type = 'text' name ='student-id' placeholder='ID'/>";
      html += "<input type = 'text' name ='student-pw' placeholder='PASSWORD'/>";
      html += "<button>로그인</button>";
      html += "</form>";
      html += "<a href='./join'> <button>회원가입</button></a>";
    } else {
      html += "<div>";
      html += student.getName() + "님 어서오세요.";
      html += "</div>";
      html += "<a href='./student'><button>로그아웃</button></a>";
      html += "<form action = 'board' method='get'>";
      html +=
          "<input type = 'hidden' name ='student-id' value = '" + student.getStudentId() + "'/>";
      html += "<button>게시판으로</button>";
      html += "<form>";

    }
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
    // doGet(request, response);
    String studentId = request.getParameter("student-id");// name과 매치를 시킨다
    String password = request.getParameter("student-pw");
    StudentDAO dao = new StudentDAO();
    StudentVO temp = dao.getStudent(studentId);
    // System.out.println(temp);
    if (temp != null && password.equals(temp.getstudentPw())) {
      response.sendRedirect("student" + "?id=" + temp.getId());
    } else {
      response.sendRedirect("student");
    }
    // response.getWriter().append("testing");
  }

}
