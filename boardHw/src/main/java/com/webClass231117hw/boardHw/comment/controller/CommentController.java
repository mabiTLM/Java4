package com.webClass231117hw.boardHw.comment.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.webClass231117hw.boardHw.comment.domain.Comment;
import com.webClass231117hw.boardHw.comment.service.CommentService;
import jakarta.servlet.http.HttpSession;

@Controller
public class CommentController {
  @Autowired
  CommentService commentService;

  @PostMapping("/comment")
  public String addComment(@RequestParam Map<String, String> data, HttpSession session,
      RedirectAttributes redirectAttributes) {
    commentService.add(new Comment(data.get("comment"),
        Integer.parseInt(session.getAttribute("userId").toString()),
        Integer.parseInt(data.get("currentPost"))));

    return "redirect:/board/" + data.get("currentPost");
  }

}
