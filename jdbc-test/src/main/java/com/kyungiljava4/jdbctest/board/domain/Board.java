package com.kyungiljava4.jdbctest.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// POJO
// Plain Old Java Object
// 특정 규약에 종속되지 않는다. << 확실하게 정해진 규칙이 없다.
// 특정 환경에 종속되지 않는다.

// @Getter
// @Setter
// @ToString
// @EqualsAndHashCode(exclude = {"id"}) // onlyExplicitlyIncluded = true,
@Data // 이퀄스 해시코드 게터 세터
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Board {
  // @EqualsAndHashCode.Exclude
  private int id;
  @NonNull
  // @EqualsAndHashCode.Include
  private String user;
  @NonNull
  private String title;
  @NonNull
  private String content;

  // @Override
  // public int hashCode() {
  // return 0;
  // }
  //
  // @Override
  // public boolean equals(Object o) {
  // return false;
  // }
}
