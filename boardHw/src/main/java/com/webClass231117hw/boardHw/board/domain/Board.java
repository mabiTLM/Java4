package com.webClass231117hw.boardHw.board.domain;

import java.sql.Date;
import com.webClass231117hw.boardHw.category.domain.Category;
import com.webClass231117hw.boardHw.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Board {
  private int id;
  @NonNull
  private String title;
  @NonNull
  private String content;
  @NonNull
  private int views;
  @NonNull
  private int likes;
  @NonNull
  private int hates;
  @NonNull
  private Date createdAt;
  @NonNull
  private User writer;
  @NonNull
  private Category category;
  @NonNull
  private boolean isWithdrew;
}
