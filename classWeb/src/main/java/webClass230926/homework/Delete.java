package webClass230926.homework;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webClass230926.studentServ.Student;

@WebServlet("/delete")
public class Delete extends HttpServlet {
  private static final long serialVersionUID = -888167975899089319L;

  public Delete() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    String html = "<html>";
    html += "<head>";
    html += "<meta charset='UTF-8'/>";
    html += "<title>";
    html += "게시글 삭제";
    html += "</title>";
    html += "</head>";
    html += "<body>";
    html += "<script>";
    html += "alert('잘못된 접근입니다.');";
    html += "location.href='student'";
    html += "</script>";
    html += "</body>";
    html += "</html>";
    response.getWriter().append(html);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Student s = new Student();
    System.out.println(s.isLogin);
    if (s.isLogin) {
      int postNumber = Integer.parseInt(request.getParameter("postNumber"));
      String currentId = request.getParameter("student-id");
      BoardDAO dao = new BoardDAO();
      dao.deleteBoard(postNumber);
      response.sendRedirect("board?student-id=" + currentId);
    } else {

      response.setCharacterEncoding("UTF-8");
      String html = "<html>";
      html += "<head>";
      html += "<meta charset='UTF-8'/>";
      html += "<title>";
      html += "게시글 삭제";
      html += "</title>";
      html += "</head>";
      html += "<body>";
      html += "<script>";
      html += "alert('잘못된 접근입니다.');";
      html += "location.href='student'";
      html += "</script>";
      html += "</body>";
      html += "</html>";
      response.getWriter().append(html);
    }
  }
}
