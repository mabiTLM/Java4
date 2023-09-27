package webClass230926.homework;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/edit")
public class Edit extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Edit() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int postNumber = Integer.parseInt(request.getParameter("postNumber"));
    BoardDAO dao = new BoardDAO();
    BoardVO temp = dao.getBoard(postNumber);
    response.setCharacterEncoding("UTF-8");
    String html = "<html>";
    html += "<head>";
    html += "<meta charset='UTF-8'/>";
    html += "<title>";
    html += "게시글 수정";
    html += "</title>";
    html += "</head>";
    html += "<body>";

    html += "<form action = 'edit' method='post'>";
    html += "<input type = 'hidden' name ='student-id' value = '" + temp.getWriter() + "'/>";
    html += "<input type = 'hidden' name ='postNumber' value = '" + temp.getIdNumber() + "'/>";
    html += "<input type = 'text' name ='title' value = '" + temp.getTitle() + "'/>";
    html += "<input type = 'text' name ='post' value = ' " + temp.getPost() + " '/>";
    html += "<button>수정하기</button>";
    html += "</form>";

    html += "<form action = 'board' method='get'>";
    html += "<input type = 'hidden' name ='student-id' value = '" + temp.getIdNumber() + "'/>";
    html += "<button>돌아가기</button>";
    html += "</form>";

    html += "</body>";
    html += "</html>";
    response.getWriter().append(html);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int postNumber = Integer.parseInt(request.getParameter("postNumber"));
    BoardDAO dao = new BoardDAO();
    System.out.println(postNumber);
    dao.editBoard(postNumber, request.getParameter("title"), request.getParameter("post"));
    response.sendRedirect("board?student-id=" + request.getParameter("student-id"));
  }

}
