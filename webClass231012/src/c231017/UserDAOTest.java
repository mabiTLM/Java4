package c231017;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import c231017.factory.DAOFactory;
import c231017.user.UsedSpringUserDAO;
import c231017.user.UserBean;
import c231017.user.UserInterface;

public class UserDAOTest {

  private UserInterface user1 = new UserBean();
  private ApplicationContext context = new AnnotationConfigApplicationContext(DAOFactory.class);

  @Before
  public void initialize() throws SQLException {
    TestUserDAO testUserDAO = context.getBean("testUserDAO", TestUserDAO.class);
    UsedSpringUserDAO dao = context.getBean("usedSpringUserDAO", UsedSpringUserDAO.class);
    try {
      testUserDAO.drop();
    } catch (Exception e) {
      e.printStackTrace();
    }
    testUserDAO.create();

    user1.setName("lim1");
    user1.setUserId("asdf1");
    user1.setPassword("1111");
    dao.add(user1);
  }

  @After
  public void dropTable() throws SQLException {
    TestUserDAO testDao = context.getBean("testUserDAO", TestUserDAO.class);
    testDao.drop();
  }


  @Test
  public void get() throws SQLException {
    UsedSpringUserDAO dao = context.getBean("usedSpringUserDAO", UsedSpringUserDAO.class);
    UserInterface createdUser = dao.get(user1.getUserId());
    assertThat(createdUser.getId(), is(1));
    assertThat(createdUser.getName(), is(user1.getName()));
    assertThat(createdUser.getUserId(), is(user1.getUserId()));
    assertThat(createdUser.getPassword(), is(user1.getPassword()));
  }

  @Test
  public void add() throws SQLException {
    UsedSpringUserDAO dao = context.getBean("usedSpringUserDAO", UsedSpringUserDAO.class);

    UserBean user = new UserBean();

    user.setName("lim1");
    user.setUserId("asdf4");
    user.setPassword("1111");
    dao.add(user);

  }



  @Test
  public void addAndGet() throws SQLException {
    UsedSpringUserDAO dao = context.getBean("usedSpringUserDAO", UsedSpringUserDAO.class);

    TestUserDAO testUserDAO = context.getBean("testUserDAO", TestUserDAO.class);

    // try {
    // testUserDAO.drop();
    // } catch (Exception e) {
    // e.printStackTrace();
    // }
    // testUserDAO.create();


    UserBean user = new UserBean();

    user.setName("lim1");
    user.setUserId("asdf2");
    user.setPassword("1111");
    dao.add(user);

    UserInterface createdUser = dao.get(user.getUserId());
    assertThat(createdUser.getName(), is(user.getName()));
    assertThat(createdUser.getUserId(), is(user.getUserId()));
    assertThat(createdUser.getPassword(), is(user.getPassword()));

  }

}
