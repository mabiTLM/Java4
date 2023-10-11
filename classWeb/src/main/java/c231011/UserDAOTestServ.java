package c231011;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserDAOTestServ")
public class UserDAOTestServ extends HttpServlet {
  private static final long serialVersionUID = 1L;


  public UserDAOTestServ() {
    super();

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    response.setContentType("text/html; charset=utf-8");
    try {
      // ConnectionMaker maker = new TomcatOracleConnectionMaker();
      UserDAO dao = new DAOFactory().userDAO();

      UserBean user = new UserBean();
      user.setName("김");
      user.setUserId("kds");
      user.setPassword("qwer");
      dao.add(user);
      System.out.println("추가 성공");
      response.getWriter().append("추가 성공");

      UserBean createdUser = dao.get("kds");
      System.out.println(createdUser.getId());
      System.out.println(createdUser.getName());
      System.out.println(createdUser.getUserId());
      System.out.println(createdUser.getPassword());

      response.getWriter().append("" + createdUser.getId());
      response.getWriter().append(createdUser.getName());
      response.getWriter().append(createdUser.getUserId());
      response.getWriter().append(createdUser.getPassword());

    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doGet(request, response);
  }

}
