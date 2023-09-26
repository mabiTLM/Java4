package webClass230926.homework;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class Board extends HttpServlet {
  private static final long serialVersionUID = -2757985253100294789L;

  public Board() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BoardDAO dao = new BoardDAO();
    List<BoardVO> list = dao.getList();
    response.setCharacterEncoding("UTF-8");
    String html = "<html>";
    html += "<head>";
    html += "<meta charset='UTF-8'/>";
    html += "<title>";
    html += "게시판";
    html += "</title>";
    html += "</head>";
    html += "<body>";

    html += "<ol>";
    for (int i = 0; i < list.size(); ++i) {
      html += "<li>";
      html += "<form action = 'board?postNumber=" + list.get(i).getIdNumber() + "' method='post'>";
      html += "<button>" + list.get(i).getTitle() + "</button>";
      html += "</form>";
      html += "</li>";
    }
    html += "</ol>";

    html += "<a href = ./writePage><button>글쓰기</button></a>";

    html += "</body>";
    html += "</html>";
    response.getWriter().append(html);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int postNumber = Integer.parseInt(request.getParameter("postNumber"));
    BoardDAO dao = new BoardDAO();
    BoardVO temp = dao.getBoard(postNumber);
    response.setCharacterEncoding("UTF-8");
    String html = "<html>";
    html += "<head>";
    html += "<meta charset='UTF-8'/>";
    html += "<title>";
    html += "게시물";
    html += "</title>";
    html += "</head>";
    html += "<body>";

    html += "<div>제목 : " + temp.getTitle() + "</div>";
    html += "<div>작성자 : " + temp.getWriter() + "</div>";
    html += "<div>작성시각 : " + temp.getDate() + "</div>";
    html += "<div>내용 : " + temp.getPost() + "</div>";

    html += "<a href = ./board><button>돌아가기</button></a>";
    html += "<form action = 'delete?postNumber=" + temp.getIdNumber() + "' method='post'>";
    html += "<button>게시글 삭제</button>";
    html += "</form>";
    html += "</body>";
    html += "</html>";
    response.getWriter().append(html);

  }

}
