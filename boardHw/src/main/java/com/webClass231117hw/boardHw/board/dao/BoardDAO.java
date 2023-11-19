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
      boolean tempDrew = false;

      String tempLongContent = rs.getString("content");

      if (rs.getInt("is_withdrew") == 1) {
        tempDrew = true;
      }

      // TODO Auto-generated method stub
      return new Board(tempLongContent, rs.getInt("id"), rs.getString("title"), rs.getInt("views"),
          rs.getInt("likes"), rs.getInt("hates"), rs.getTimestamp("created_at"), tempDrew,
          rs.getInt("user_id"));
    }
  };

  public void add(Board board) {
    jdbcTemplate.update("insert into boards (user_id, title, content) values (?,?,?)",
        board.getUserId(), board.getTitle(), board.getContent());
  }

  public List<Board> getAll() {
    return jdbcTemplate.query("select * from boards", mapper);
  }

}
