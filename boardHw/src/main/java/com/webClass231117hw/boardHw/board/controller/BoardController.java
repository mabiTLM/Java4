package com.webClass231117hw.boardHw.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
  public String mainPagePost(Model model) {

    boardDAO.add(new Board("실험", "실험", 1));
    boardDAO.getAll();
    System.out.print("확인용");

    return "redirect:/";
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
