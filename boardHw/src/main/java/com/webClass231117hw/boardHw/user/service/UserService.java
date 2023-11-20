package com.webClass231117hw.boardHw.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webClass231117hw.boardHw.user.dao.UserDAO;
import com.webClass231117hw.boardHw.user.domain.User;

@Service
public class UserService {
  @Autowired
  UserDAO userDAO;

  public void add(User user) {
    userDAO.add(user);
  }

  public User get(int id) {
    return userDAO.get(id);
  }

  public int login(String userId, String password) {

    try {
      if (userDAO.get(userId).getPassword().equals(password)) {
        return userDAO.get(userId).getId();
      }
    } catch (Exception e) {
    }
    return 0;
  }
}
