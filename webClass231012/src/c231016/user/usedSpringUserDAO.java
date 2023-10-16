package c231016.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class usedSpringUserDAO {
  private JdbcTemplate jdbcTemplate;

  public usedSpringUserDAO(DataSource dataSource) {
    jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public void add(UserInterface user) throws SQLException {
    jdbcTemplate.update("insert into users (name,user_id,password) values (?,?,?)", user.getName(),
        user.getUserId(), user.getPassword());
  }

  public UserInterface get(String userId) throws SQLException {
    // jdbcTemplate.queryForInt("select count(*) from users");// 몇개있는지 가져온다 loss

    jdbcTemplate.queryForList("qeury", UserBean.class, "? 1", "? 2");

    return jdbcTemplate.queryForObject("select * from users where user_id=?", new Object[] {userId},
        new RowMapper<UserBean>() {
          @Override
          public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserBean user = new UserBean();
            user.setId(rs.getInt("id"));
            return user;
          }
        });
  }

}
