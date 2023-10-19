package c231019.test.user;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserTestDAO {
  private JdbcTemplate jdbcTemplate;

  public void setDataSource(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public void drop() {
    jdbcTemplate.execute("drop table users");
  }

  public void create() throws Exception {

    int maxCount = 3;

    while (maxCount-- > 0) {
      try {
        jdbcTemplate.execute("create table users" + " (id number generated as identity primary key,"
            + " name varchar2(20)," + " user_id varchar2(50) not null unique,"
            + " password varchar2(64) not null)");
        return;

      } catch (Exception e) {
        System.out.println(maxCount + "번 남았어");
        // e.printStackTrace();
      }
    }
    throw new Exception("table 생성 실패");
  }
}
