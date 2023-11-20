package com.webClass231117hw.boardHw.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.webClass231117hw.boardHw.user.dao.UserDAO;
import com.webClass231117hw.boardHw.user.domain.User;

public class UserService {
  @Autowired
  UserDAO userDAO;

  public void add(User user) {
    userDAO.add(user);
  }

  public User get(int id) {
    return userDAO.get(id);
  }
}
