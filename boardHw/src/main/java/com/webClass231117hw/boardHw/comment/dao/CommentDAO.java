package com.webClass231117hw.boardHw.comment.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.webClass231117hw.boardHw.comment.domain.Comment;

@Repository
public class CommentDAO {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  private RowMapper<Comment> mapper = new RowMapper<Comment>() {
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new Comment(rs.getInt("id"), rs.getString("content"), rs.getTimestamp("created_at"),
          rs.getInt("writer_id"), rs.getInt("board_id"), rs.getString("name"), rs.getInt("reply"));
    }
  };

  public void add(Comment comment) {
    jdbcTemplate.update("insert into comments (content, writer_id, board_id) values (?,?,?)",
        comment.getContent(), comment.getWriterId(), comment.getBoardId());
  }

  public List<Comment> getBoardId(int board_id) {
    return jdbcTemplate.query(
        "select comments.*, users.name from comments join users on comments.writer_id=users.id where comments.board_id = ? order by comments.id",
        mapper, board_id);
  }

}
