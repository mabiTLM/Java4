package com.webClass231117hw.boardHw.comment.domain;

import java.sql.Timestamp;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Comment {
  private int id;
  @NonNull
  private String content;
  private Timestamp createdAt;
  private boolean withdrew = false;
  private final int userId;
  private final int boardId;
  private int commentId;
  private List<Comment> children;
  private String userName;
}
// @Data
// @AllArgsConstructor
// @NoArgsConstructor
// @RequiredArgsConstructor
// public class Comment {
// private int id;
// @NonNull
// private String content;
// private Timestamp createdAt;
// @NonNull
// private int writerId;
// @NonNull
// private int boardId;
// private String name;
// private int reply;
// private int step;
// private int level;
// }
