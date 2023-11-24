package com.webClass231117hw.boardHw.comment.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webClass231117hw.boardHw.comment.dao.CommentDAO;
import com.webClass231117hw.boardHw.comment.domain.Comment;

@Service
public class CommentService {
  @Autowired
  CommentDAO commentDAO;

  public void add(Comment comment) {
    commentDAO.add(comment);
  }

  public List<Comment> getBoardId(int board_id) {
    return commentDAO.getBoardId(board_id);
  }

}
