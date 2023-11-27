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
  JdbcTemplate jdbcTemplate;

  private RowMapper<Comment> mapper = new RowMapper<Comment>() {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
      return new Comment(rs.getInt("id"), rs.getString("content"), rs.getTimestamp("created_at"),
          rs.getInt("is_withdrew") == 1, rs.getInt("user_id"), rs.getInt("board_id"),
          rs.getInt("comment_id"), null, rs.getString("name"));
    }
  };

  public void add(Comment comment) {
    jdbcTemplate.update(
        "insert into comments (content, user_id, board_id, comment_id) values (?,?,?,?)",
        comment.getContent(), comment.getUserId(), comment.getBoardId(),
        comment.getCommentId() > 0 ? comment.getCommentId() : null);
  }

  public List<Comment> getParents(int boardId, int start) {
    return jdbcTemplate.query(
        "select comments.*, users.name from comments join users on comments.user_id=users.id where comments.board_id = ? and comments.comment_id is null order by comments.id desc offset ? rows fetch first 5 rows only",
        mapper, boardId, start);
  }

  public List<Comment> getChildren(int boardId, int commentId) {
    return jdbcTemplate.query(
        "select comments.*, users.name from comments join users on comments.user_id=users.id where comments.board_id = ? and comments.comment_id = ? order by comments.id",
        mapper, boardId, commentId);
  }
}


// @Repository
// public class CommentDAO {
//
// @Autowired
// private JdbcTemplate jdbcTemplate;
//
// private RowMapper<Comment> mapper = new RowMapper<Comment>() {
// @Override
// public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
// return new Comment(rs.getInt("id"), rs.getString("content"), rs.getTimestamp("created_at"),
// rs.getInt("writer_id"), rs.getInt("board_id"), rs.getString("name"), rs.getInt("reply"),
// rs.getInt("reply_step"), rs.getInt("reply_level"));
// }
// };
//
// private RowMapper<Comment> isMapper = new RowMapper<Comment>() {
// @Override
// public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
// return new Comment();
// }
// };
//
// // 레벨의 이전껄 참조해서 불러오면된다.
// // 스텝은? 댓글을 달때는 제일 마지막껄 대댓글을 달때는 다는곳에서 가져와야한다
// public void add(Comment comment) {
// jdbcTemplate.update(
// "insert into comments (content, writer_id, board_id, reply, reply_step, reply_level) values
// (?,?,?,?,?,?)",
// comment.getContent(), comment.getWriterId(), comment.getBoardId(), comment.getReply(),
// comment.getStep(), comment.getLevel());
// }
//
// public List<Comment> getBoardId(int board_id) {
// return jdbcTemplate.query(
// "select comments.*, users.name from comments join users on comments.writer_id=users.id where
// comments.board_id = ? order by comments.id",
// mapper, board_id);
// }
//
// public boolean getStep(int step) {
// return jdbcTemplate.query("select * from comments where reply_step = ?", isMapper,
// step) == null;
// }
//
// public void upStep(int reply) {// level의 마지막 스텝을 가져오자
// jdbcTemplate.update("update comments set reply_step = reply_step + 1 where reply = " + reply);
// }
// }
