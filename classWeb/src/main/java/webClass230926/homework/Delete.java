package webClass230926.homework;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class Delete extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public Delete() {
    super();
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {}

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    int postNumber = Integer.parseInt(request.getParameter("postNumber"));
    String currentId = request.getParameter("student-id");
    BoardDAO dao = new BoardDAO();
    dao.deleteBoard(postNumber);
    response.sendRedirect("board?student-id=" + currentId);
  }

}
