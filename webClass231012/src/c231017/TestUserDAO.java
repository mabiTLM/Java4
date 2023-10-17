package c231017;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestUserDAO {
  private JdbcTemplate jdbcTemplate;

  public TestUserDAO(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public void drop() {
    jdbcTemplate.execute("drop table users");
  }

  public void create() {
    jdbcTemplate.execute("create table users" + " (id number generated as identity primary key,"
        + " name varchar2(20)," + " user_id varchar2(50) not null,"
        + " password varchar2(64) not null)");
  }
}
