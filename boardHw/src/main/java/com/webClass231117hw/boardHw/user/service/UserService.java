package com.webClass231117hw.boardHw.user.service;

import java.security.MessageDigest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webClass231117hw.boardHw.user.dao.UserDAO;
import com.webClass231117hw.boardHw.user.domain.User;

@Service
public class UserService {
  @Autowired
  UserDAO userDAO;

  public void add(User user) {
    user.setPassword(cryptoPassword(user.getPassword()));
    userDAO.add(user);
  }

  public User login(User user) {
    try {
      User tempUser = userDAO.get(user.getUserId());
      if (tempUser != null && tempUser.getPassword().equals(cryptoPassword(user.getPassword()))) {
        return tempUser;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  private String cryptoPassword(String password) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(password.getBytes());
      byte[] sha256Hash = md.digest();
      StringBuilder sb = new StringBuilder();
      for (byte b : sha256Hash) {
        sb.append(String.format("%02x", b));
      }
      return sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }


  public User get(int id) {
    return userDAO.get(id);
  }

  // public int login(String userId, String password) {
  //
  // try {
  // if (userDAO.get(userId).getPassword().equals(password)) {
  // return userDAO.get(userId).getId();
  // }
  // } catch (Exception e) {
  // }
  // return 0;
  // }
}
