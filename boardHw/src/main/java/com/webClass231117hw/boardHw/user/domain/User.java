package com.webClass231117hw.boardHw.user.domain;

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
public class User {
  private int id;
  @NonNull
  private String userId;
  @NonNull
  private String password;
  @NonNull
  private String name;
  @NonNull
  private String phone;
  @NonNull
  private String address;
  @NonNull
  private String email;
  @NonNull
  private String gitAddress;
  @NonNull
  private boolean gender;
  private Date createdAt;
  @NonNull
  private Date birth;
}
