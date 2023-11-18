package com.webClass231117hw.boardHw.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
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
      // TODO Auto-generated method stub
      return new Board(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
          rs.getInt("views"), rs.getInt("likes"), rs.getInt("hates"), rs.getTimestamp("createdAt"),
          rs.getBoolean("isWithdrew"), rs.getInt("userId"));
    }
  };

}
