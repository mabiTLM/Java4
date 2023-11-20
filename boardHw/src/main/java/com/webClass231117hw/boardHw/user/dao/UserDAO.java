package com.webClass231117hw.boardHw.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.webClass231117hw.boardHw.user.domain.User;

@Repository

public class UserDAO {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  private RowMapper<User> mapper = new RowMapper<User>() {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new User(rs.getInt("id"), rs.getString("user_id"), rs.getString("password"),
          rs.getString("name"), rs.getString("phone"), rs.getString("address"),
          rs.getString("email"), rs.getString("git_address"), rs.getInt("gender") == 1,
          rs.getDate("created_at"), rs.getDate("birth"));
    }
  };

  public void add(User user) {
    int tempGender = 0;
    if (user.isGender()) {
      tempGender = 1;
    }
    jdbcTemplate.update(
        "insert into users (user_id, password, name, phone, address, email, git_address, gender, birth) values (?,?,?,?,?,?,?,?,?)",
        user.getUserId(), user.getPassword(), user.getName(), user.getPhone(), user.getAddress(),
        user.getEmail(), user.getGitAddress(), tempGender, user.getBirth());
  }

  public User get(int id) {
    return jdbcTemplate.queryForObject("select * from users where id = ?", mapper, id);
  }
}
