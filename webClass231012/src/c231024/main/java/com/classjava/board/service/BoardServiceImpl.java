package c231024.main.java.com.classjava.board.service;

import java.util.List;
import c231024.main.java.com.classjava.board.dao.BoardDAO;
import c231024.main.java.com.classjava.board.domain.Board;
import c231024.main.java.com.classjava.user.dao.UserDAO;
import c231024.main.java.com.classjava.user.domain.User;
import c231024.main.java.com.classjava.user.service.UserService;

public class BoardServiceImpl implements BoardService {
  private UserDAO userDAO;
  private BoardDAO boardDAO;
  private UserService userService;

  public void setUserDAO(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public void setBoardDAO(BoardDAO boardDAO) {
    this.boardDAO = boardDAO;
  }

  public void setUserService(UserService userService) {
    this.userService = userService;
  }

  public void add(Board board, int userId) {
    if (userService.isLogIn(userId)) {
      boardDAO.add(board);
    } else {
      new RuntimeException("로그인 실패");
    }
  }

  public Board get(int id) {
    Board board = boardDAO.get(id);
    User user = userDAO.get(board.getUserId());
    board.setUser(user);
    return board;
  }

  public List<Board> getAll() {
    List<Board> list = boardDAO.getAll();
    for (int i = 0; i < list.size(); i++) {
      int userId = list.get(i).getUserId();
      User user = userDAO.get(userId);
      list.get(i).setUser(user);
    }

    return list;
  }


  public void update(Board board, User user) {
    User writer = board.getUser();
    if (writer.getId() == user.getId()) {
      boardDAO.update(board);
    } else {
      throw new RuntimeException("wrong user");
    }
  }

  public void updateAll(User user) {
    List<Board> list = getAll();
    for (int i = 0; i < list.size(); i++) {
      // if (i == 2) {
      // user = new User("김남", "knk", "1234");
      // }
      Board board = list.get(i);
      board.setContent("삭제된 컨텐츠");
      User writer = board.getUser();
      if (writer.getId() == user.getId()) {
        boardDAO.update(board);
      } else {
        throw new RuntimeException("wrong user");
      }
    }
  }
}
