package com.webClass231117hw.boardHw.comment.domain;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Comment {
  private int id;
  @NonNull
  private String content;
  private Timestamp createdAt;
  @NonNull
  private int writerId;
  @NonNull
  private int boardId;
  private String name;
  private int reply;
}
