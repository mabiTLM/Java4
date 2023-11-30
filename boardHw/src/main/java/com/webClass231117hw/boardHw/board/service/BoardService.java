package com.webClass231117hw.boardHw.board.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webClass231117hw.boardHw.board.dao.BoardDAOMysql;
import com.webClass231117hw.boardHw.board.domain.Board;

@Service
public class BoardService {
  @Autowired
  BoardDAOMysql boardDAO;

  public void add(Board board) {
    boardDAO.add(board);
  }

  public List<Board> getAll(int page, int count) {
    return boardDAO.getAll((page - 1) * count, count);
  }

  public int getPageCount(int count) {
    // 한 페이지에서 목록을 몇개 출력할 것인가? 5
    // 글 1 => 페이지1
    // 글 10 => 페이지2
    // 글 11 => 페이지2
    // 글 15 => 페이지3
    return (boardDAO.getCount() - 1) / count + 1;
  }

  public Board get(int id) {
    return boardDAO.get(id);
  }
}
