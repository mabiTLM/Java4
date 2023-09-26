package webClass230926.studentServ;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webClass230926.student.StudentDAO;
import webClass230926.student.StudentVO;

/**
 * Servlet implementation class join
 */
@WebServlet("/join")
public class Join extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Join() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setCharacterEncoding("UTF-8");
    String html = "<html>";
    html += "<head>";
    html += "<meta charset='UTF-8'/>";
    html += "<title>";
    html += "회원가입";
    html += "</title>";
    html += "</head>";
    html += "<body>";

    html += "<form action = 'join' method='post'>";
    html += "<input type = 'text' name ='name' placeholder='NAME'/>";
    html += "<input type = 'text' name ='student_id' placeholder='ID'/>";
    html += "<input type = 'text' name ='password' placeholder='PASSWORD'/>";
    html += "<input type = 'text' name ='age' placeholder='AGE'/>";
    html += "<input type = 'text' name ='gitaddress' placeholder='GITADDRESS'/>";
    html += "<button>가입하기</button>";
    html += "</form>";

    html += "<a href = './student'> <button>돌아가기</button> </a>";

    html += "</body>";
    html += "</html>";
    response.getWriter().append(html);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String name = request.getParameter("name");
    String id = request.getParameter("student_id");
    String password = request.getParameter("password");
    int age = Integer.parseInt(request.getParameter("age"));
    String gitAddress = request.getParameter("gitaddress");

    StudentDAO dao = new StudentDAO();
    StudentVO temp = dao.getStudent(id);
    if (temp != null) {// 비어있지않을때 가입안됨

      response.setCharacterEncoding("UTF-8");
      String html = "<html>";
      html += "<head>";
      html += "<meta charset='UTF-8'/>";
      html += "<title>";
      html += "오류";
      html += "</title>";
      html += "</head>";
      html += "<body>";
      html += "<div>아이디가 중복되었습니다.</div>";
      html += "<a href = './join'> <button>돌아가기</button> </a>";
      html += "</body>";
      html += "</html>";
      response.getWriter().append(html);
    } else {// 비어있으면 가입

      dao.insertStudent(name, id, password, age, gitAddress);


      response.sendRedirect("student");
    }
  }
}
