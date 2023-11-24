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


  public List<Board> getAll(int page, int count) {
    return boardDAO.getAll((page - 1) * count, count);
  }

  public int getPageCount(int count) {
    return (boardDAO.getCount() - 1) / count + 1;
  }

  public Board get(int id) {
    return boardDAO.get(id);
  }

  // public Board get(int id) {
  // return boardDAO.get(id);
  // }

  // public List<Board> getAll(int page) {
  // return boardDAO.getAll(page);
  // }
  //
  // public List<Board> getAll() {
  // return boardDAO.getAll();
  // }

  public void delete(int id) {
    boardDAO.delete(id);
  }

  public void edit(int id, String title, String content) {
    boardDAO.edit(id, title, content);
  }
}
