package webClass230926.homework;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/writePage")
public class WritePage extends HttpServlet {

  private static final long serialVersionUID = 5890753821823199391L;

  public WritePage() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String currentId = request.getParameter("student-id");

    response.setCharacterEncoding("UTF-8");
    String html = "<html>";
    html += "<head>";
    html += "<meta charset='UTF-8'/>";
    html += "<title>";
    html += "게시글 작성중";
    html += "</title>";
    html += "</head>";
    html += "<body>";

    html += "<form action = 'writePage' method='post'>";
    html += "<input type = 'hidden' name ='student-id' value = '" + currentId + "'/>";
    html += "<input type = 'text' name ='title' placeholder='제목'/>";
    html += "<input type = 'text' name ='post' placeholder='내용을 적어주세요'/>";
    html += "<button>작성하기</button>";
    html += "</form>";

    html += "<form action = 'board' method='get'>";
    html += "<input type = 'hidden' name ='student-id' value = '" + currentId + "'/>";
    html += "<button>돌아가기</button>";
    html += "</form>";

    html += "</body>";
    html += "</html>";
    response.getWriter().append(html);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String title = request.getParameter("title");
    String post = request.getParameter("post");
    String writer = request.getParameter("student-id");

    BoardDAO temp = new BoardDAO();
    temp.insertBoard(title, writer, post);
    response.sendRedirect("board?student-id=" + writer);


  }
}
