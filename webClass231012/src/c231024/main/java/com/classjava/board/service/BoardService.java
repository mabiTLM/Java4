package c231024.main.java.com.classjava.board.service;

import java.util.List;
import c231024.main.java.com.classjava.board.domain.Board;
import c231024.main.java.com.classjava.user.domain.User;

public interface BoardService {
  public void add(Board board, int userId);

  public Board get(int id);

  public List<Board> getAll();

  public void update(Board board, User user);

  public void updateAll(User user);

}
