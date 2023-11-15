package com.kyungiljava4.jdbctest.board.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.kyungiljava4.jdbctest.board.domain.Board;
import com.kyungiljava4.jdbctest.board.service.BoardService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
  @Autowired
  BoardService boardService;

  @GetMapping("/board")
  public String listPage() {
    return "boards/index";
  }

  @ResponseBody
  @PostMapping("/board")
  public String list() {// json형식의 배열
    List<Board> list = boardService.getAll();
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < list.size(); ++i) {
      sb.append("{\"id\":" + list.get(i).getId() + ",");
      sb.append("\"user\":\"" + list.get(i).getUser() + "\",");
      sb.append("\"title\":\"" + list.get(i).getTitle() + "\",");
      sb.append("\"content\":\"" + list.get(i).getContent() + "\"}");
      if (i < list.size() - 1) {
        sb.append(",");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  @GetMapping("/board/add")
  public String addPage() {
    return "boards/add";
  }

  @PostMapping("/board/add")
  public String add(@RequestParam Map<String, String> data) {
    boardService.add(new Board(data.get("user"), data.get("title"), data.get("content")));

    return "redirect:/board";
  }

  @GetMapping("/board/print")
  public String printPage(@RequestParam Map<String, String> data, HttpSession session) {
    session.setAttribute("id", data.get("id"));
    // boardService.get(Integer.valueOf(data.get("id")));
    return "boards/print";
  }

  @ResponseBody
  @PostMapping("/board/print")
  public String printPagePost(@RequestParam Map<String, String> data, HttpSession session) {
    Board post = boardService.get(Integer.valueOf(session.getAttribute("id").toString()));
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    sb.append("{\"id\":" + post.getId() + ",");
    sb.append("\"user\":\"" + post.getUser() + "\",");
    sb.append("\"title\":\"" + post.getTitle() + "\",");
    sb.append("\"content\":\"" + post.getContent() + "\"}");
    sb.append("]");
    return sb.toString();
  }

}
