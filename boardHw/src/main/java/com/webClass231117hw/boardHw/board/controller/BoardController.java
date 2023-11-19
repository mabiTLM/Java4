package com.webClass231117hw.boardHw.board.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.webClass231117hw.boardHw.board.dao.BoardDAO;
import com.webClass231117hw.boardHw.board.domain.Board;

@Controller
public class BoardController {

  @Autowired
  BoardDAO boardDAO;

  @GetMapping("/")
  public String boardMainPage(Model model) {
    model.addAttribute("title", "게시판");
    model.addAttribute("path", "/board/index");
    model.addAttribute("content", "boardFragment");
    model.addAttribute("contentHead", "boardFragmentHead");


    return "/basic/layout";
  }

  @PostMapping("/")
  public String mainPagePost(Model model, @RequestParam Map<String, String> data) {

    boardDAO.add(new Board(data.get("title"), data.get("content"), 1));

    return "redirect:/";
  }

  @ResponseBody
  @PostMapping("/board")
  public String boardPagePost() {
    List<Board> list = boardDAO.getAll();

    StringBuilder sb = new StringBuilder();

    sb.append("[");
    for (int i = 0; i < list.size(); ++i) {
      sb.append("{\"id\":" + list.get(i).getId() + ",");
      sb.append("\"title\":\"" + list.get(i).getTitle() + "\",");
      sb.append("\"content\":\"" + list.get(i).getContent() + "\"}");
      if (i < list.size() - 1) {
        sb.append(",");
      }
    }
    sb.append("]");

    return sb.toString();
  }


  @GetMapping("/notice")
  public String noticePage(Model model) {
    model.addAttribute("title", "공지사항");
    model.addAttribute("path", "/board/notice");
    model.addAttribute("content", "noticeFragment");
    model.addAttribute("contentHead", "noticeFragmentHead");

    return "/basic/layout";
  }
}
