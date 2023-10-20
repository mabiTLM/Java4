package c231020.test.board;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class BoardTestDAO {

  private JdbcTemplate jdbcTemplate;

  public void setDataSource(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public void drop() {
    jdbcTemplate.execute("drop table boards");
  }

  public void create() {

    int maxCount = 3;

    while (maxCount-- > 0) {
      try {
        jdbcTemplate.execute("create table boards(\"id\" number generated as identity primary key,"
            + "\"title\" varchar2(30) not null," + "\"content\" long not null,"
            + "\"created_at\" timestamp default sysdate," + "\"user_id\" number not null)");
        return;

      } catch (Exception e) {
        System.out.println(maxCount + "번 남았어");
        // e.printStackTrace();
      }
    }
    try {
      throw new Exception("table 생성 실패");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
