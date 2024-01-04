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
public class BoardDAOMysql {
  @Autowired
  private JdbcTemplate jdbcTemplate;

  private RowMapper<Board> mapper = new RowMapper<Board>() {
    @Override
    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {

      return new Board(rs.getInt("id"), rs.getString("title"), rs.getString("content"),
          rs.getInt("views"), 0, 0, rs.getTimestamp("created_at"), rs.getInt("is_withdrew") == 1,
          rs.getInt("user_id"), rs.getString("name"), rs.getString("git_address"));
    }
  };

  public void add(Board board) {
    jdbcTemplate.update(
        "insert into boards (title, content, is_withdrew, user_id) values (?,?,?,?)",
        board.getTitle(), board.getContent(), board.isWithdrew() ? 1 : 0, board.getUserId());
  }

  public int getCount() {
    return jdbcTemplate.queryForObject("select count(*) from boards", Integer.class);
  }

  public Board get(int id) {
    return jdbcTemplate.queryForObject(
        "select boards.*, users.name, users.git_address from boards join users on boards.user_id=users.id where boards.id=?",
        mapper, id);
  }

  public List<Board> getAll(int idx, int count) {
    return jdbcTemplate.query(
        "select boards.*, users.name, users.git_address from boards join users on boards.user_id=users.id order by boards.id desc limit ?, ?",
        mapper, idx, count);
  }

  public void delete(int id) {
    jdbcTemplate.update("delete from boards where id = ?", id);
  }

  public void edit(int id, String title, String content) {
    jdbcTemplate.update(
        "update boards set title = '" + title + "', content = '" + content + "' where id = " + id);
  }

}