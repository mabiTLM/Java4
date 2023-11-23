package com.webClass231117hw.boardHw.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.webClass231117hw.boardHw.board.domain.Board;

@Repository
public class BoardDAO {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private RowMapper<Board> mapper = new RowMapper<Board>() {
    @Override
    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new Board(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
          rs.getInt("views"), 0, 0, rs.getTimestamp("created_at"), rs.getInt("is_withdrew") == 1,
          rs.getInt("user_id"), rs.getString("name"));
    }
  };

  public void add(Board board) {
    jdbcTemplate.update(
        "insert into boards (title, content, is_withdrew, user_id) values (?,?,?,?)",
        board.getTitle(), board.getContent(), board.isWithdrew() ? 1 : 0, board.getUserId());
  }

  public List<Board> getAll() {
    return jdbcTemplate.query(
        "select a.*, b.name from boards a join users b on a.user_id = b.id order by a.id offset 0 rows fetch first 5 rows only",
        mapper);
  }

}
