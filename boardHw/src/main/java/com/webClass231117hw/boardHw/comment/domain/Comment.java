package com.webClass231117hw.boardHw.comment.domain;

import java.sql.Date;
import com.webClass231117hw.boardHw.board.domain.Board;
import com.webClass231117hw.boardHw.user.domain.User;
import lombok.NonNull;

public class Comment {
  private int id;
  @NonNull
  private String content;
  @NonNull
  private int likes;
  @NonNull
  private Date createdAt;
  @NonNull
  private User writer;
  @NonNull
  private Board board;

}
