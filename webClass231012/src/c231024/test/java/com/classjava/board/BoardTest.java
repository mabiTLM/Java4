package c231024.test.java.com.classjava.board;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.sql.Date;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import c231024.main.java.com.classjava.board.dao.BoardDAO;
import c231024.main.java.com.classjava.board.domain.Board;
import c231024.main.java.com.classjava.board.service.BoardService;
import c231024.main.java.com.classjava.board.service.BoardServiceImpl;
import c231024.main.java.com.classjava.board.service.BoardServiceTx;
import c231024.main.java.com.classjava.user.dao.UserDAO;
import c231024.main.java.com.classjava.user.domain.User;
import c231024.main.java.com.classjava.user.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/c231023/dataSource.xml", "applicationContext.xml"})
public class BoardTest {
  @Autowired
  UserDAO userDAO;
  @Autowired
  BoardDAO boardDAO;
  @Autowired
  BoardService boardService;
  @Autowired
  BoardServiceImpl boardServiceImpl;

  @Before
  public void initialize() {
    boardServiceImpl.setUserService(new MockUserService());
    ((BoardServiceTx) boardService).setBoardService(boardServiceImpl);

    boardDAO.deleteAll();
    User user = userDAO.get("kwj");
    boardService.add(new Board(user, "테스트1", "테스트1 내용"), 1);
    boardService.add(new Board(user, "테스트2", "테스트2 내용"), 1);
    boardService.add(new Board(user, "테스트3", "테스트3 내용"), 1);
  }

  @Test
  public void getAll() {
    List<Board> list = boardService.getAll();
    User user = userDAO.get("kwj");
    for (int i = 0; i < list.size(); ++i) {
      assertThat(list.get(i).getTitle(), is("테스트" + (i + 1)));
      assertThat(list.get(i).getContent(), is("테스트" + (i + 1) + " 내용"));
      assertThat(list.get(i).getUser().getId(), is(user.getId()));
      assertThat(list.get(i).getUser().getName(), is(user.getName()));
      assertThat(list.get(i).getUser().getPassword(), is(user.getPassword()));
    }
  }

  @Test
  public void updateAll() {
    User user = userDAO.get("kwj");
    try {
      boardService.updateAll(user);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void add() {
    Board board = new Board(userDAO.get("kwj"), "테스트중입니다.", "23년 10월 24일 테스트");
    boardService.add(board, 1);
  }

  @Test
  public void test() {
    MockUserService userService = new MockUserService();
    User user = userService.get(1);
    Board board = new Board(user, "임시 데이터 테스트", "태스트중입니다.");
    boardService.add(board, user.getId());
  }

  public static class MockUserService implements UserService {

    @Override
    public void add(User user) {

    }

    public User get(int id) {
      return new User(1, "송", "ssm", "123", new Date(new java.util.Date().getTime()));
    }

    @Override
    public boolean isLogIn(int id) {

      if (id == 1)
        return true;
      return false;
    }

  }

}
