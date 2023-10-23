package c231023.main.java.com.classjava.user.dao;

import c231023.main.java.com.classjava.user.domain.User;

public interface UserDAO {
  public void add(User user);

  public User get(String userId);

  public User get(int id);

  public void deleteAll();
}
