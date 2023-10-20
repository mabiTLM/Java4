package c231020.board;

import c231020.user.UserBean;
import c231020.user.UserDAO;

public class BoardService {

  private BoardDAO boardDAO;
  private UserDAO userDAO;

  public void setBoardDAO(BoardDAO boardDAO) {
    this.boardDAO = boardDAO;
  }

  public void setUserDAO(UserDAO userDAO) {
    this.userDAO = userDAO;
  }

  public void add(BoardBean board, UserBean user) {
    board.setUserId(user.getId());
    boardDAO.add(board);
  }

  public BoardBean get(int id) {
    // 유저 정보 매치
    BoardBean board = boardDAO.get(id);
    UserBean user = userDAO.get(board.getUserId());

    board.setUser(user);

    return board;
  }


  // /**
  // * id 게시글의 작성자의 정보를 불러오는 함수
  // **/
  // public UserBean writer(int id) {
  // return userDAO.get(boardDAO.get(id).getUserId());
  // }
}
