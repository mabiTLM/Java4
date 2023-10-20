package c231020.board;

import java.sql.Date;
import c231020.user.UserBean;

public class BoardBean {
  private int id;
  private int userId;
  private UserBean user;
  private String title;
  private String content;
  private Date createdAt;

  public BoardBean() {

  }

  public void setId(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getUserId() {
    return userId;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getContent() {
    return content;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setUser(UserBean user) {
    this.user = user;
  }

  public UserBean getUser() {
    return user;
  }



}
