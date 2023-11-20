package com.webClass231117hw.boardHw.board.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.webClass231117hw.boardHw.board.domain.Board;
import com.webClass231117hw.boardHw.board.service.BoardService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
  @Autowired
  BoardService boardService;

  // @Autowired
  // BoardDAO boardDAO;

  @GetMapping("/")
  public String boardMainPage(Model model) {
    model.addAttribute("title", "게시판");
    model.addAttribute("path", "/board/index");
    model.addAttribute("content", "boardFragment");
    model.addAttribute("contentHead", "boardFragmentHead");
    model.addAttribute("list", boardService.getAll());
    return "/basic/layout";
  }


  @PostMapping("/add")
  public String add(@RequestParam Map<String, String> data, HttpSession session) {

    boardService.add(
        new Board(data.get("title"), data.get("content"), (int) session.getAttribute("userId")));

    return "redirect:/";
  }

  // @PostMapping("/")
  // public String mainPagePost(Model model, @RequestParam Map<String, String> data) {
  //
  // boardDAO.add(new Board(data.get("title"), data.get("content"), 1));
  //
  // return "redirect:/";
  // }

  // @ResponseBody
  // @PostMapping("/board")
  // public String boardPagePost() {
  // List<Board> list = boardDAO.getAll();
  //
  // StringBuilder sb = new StringBuilder();
  //
  // sb.append("[");
  // for (int i = 0; i < list.size(); ++i) {
  // sb.append("{\"id\":" + list.get(i).getId() + ",");
  // sb.append("\"title\":\"" + list.get(i).getTitle() + "\",");
  // sb.append("\"content\":\"" + list.get(i).getContent() + "\"}");
  // if (i < list.size() - 1) {
  // sb.append(",");
  // }
  // }
  // sb.append("]");
  //
  // return sb.toString();
  // }


  @GetMapping("/notice")
  public String noticePage(Model model) {
    model.addAttribute("title", "공지사항");
    model.addAttribute("path", "/board/notice");
    model.addAttribute("content", "noticeFragment");
    model.addAttribute("contentHead", "noticeFragmentHead");

    return "/basic/layout";
  }
}
