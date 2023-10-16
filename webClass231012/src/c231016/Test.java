package c231016;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import c231016.factory.DAOFactory;
import c231016.user.JdbcContextUserDAO;
import c231016.user.UserBean;

// User의 DAO를 테스트
public class Test {

  public static void main(String[] args) throws Exception {

    ApplicationContext context = new AnnotationConfigApplicationContext(DAOFactory.class);

    JdbcContextUserDAO dao = context.getBean("jdbcContextUserDAO", JdbcContextUserDAO.class);

    UserBean user = new UserBean();
    user.setName("정");
    user.setUserId("jkh");
    user.setPassword("1234");
    dao.add(user);
    System.out.println("추가 성공");

    // UserInterface createdUser = dao.get("ljh");
    // System.out.println(createdUser.getId());
    // System.out.println(createdUser.getName());
    // System.out.println(createdUser.getUserId());
    // System.out.println(createdUser.getPassword());
  }

}
