package com.webClass231117hw.boardHw.category.domain;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Category {
  private int id;
  @NonNull
  private String title;
  @NonNull
  private Date createdAt;

}
