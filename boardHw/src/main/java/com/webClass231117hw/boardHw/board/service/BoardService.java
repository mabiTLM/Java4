package com.webClass231117hw.boardHw.board.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.webClass231117hw.boardHw.board.dao.BoardDAO;
import com.webClass231117hw.boardHw.board.domain.Board;

@Service
public class BoardService {
  @Autowired
  BoardDAO boardDAO;

  public void add(Board board) {
    boardDAO.add(board);
  }

  public List<Board> getAll() {
    return boardDAO.getAll();
  }
}
