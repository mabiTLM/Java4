package c231017.factory;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import c231017.TestUserDAO;
import c231017.user.JdbcContextUserDAO;
import c231017.user.UsedSpringUserDAO;
import c231017.user.UserDAO;

// 전체적인 모든 DAO를 관리(생성 등등)
public class DAOFactory {

  private UserDAO USERDAOINSTANCE;

  @Bean
  public UserDAO userDAO() {
    // return new UserDAO(connectionMaker());
    if (USERDAOINSTANCE == null)
      USERDAOINSTANCE = new UserDAO(dataSource());
    return USERDAOINSTANCE;
  }

  @Bean
  public JdbcContextUserDAO jdbcContextUserDAO() {
    return new JdbcContextUserDAO(dataSource());
  }

  @Bean
  public UsedSpringUserDAO usedSpringUserDAO() {
    return new UsedSpringUserDAO(dataSource());
  }

  @Bean
  public TestUserDAO testUserDAO() {
    return new TestUserDAO(dataSource());
  }

  @Bean
  public DataSource dataSource() {
    SimpleDriverDataSource dataSource = new SimpleDriverDataSource();

    dataSource.setDriverClass(oracle.jdbc.OracleDriver.class);
    dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
    dataSource.setUsername("java");
    dataSource.setPassword("qwer");
    return dataSource;
  }

}
