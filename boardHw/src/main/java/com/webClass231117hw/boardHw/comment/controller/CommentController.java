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
    Comment tempComment = new Comment(data.get("comment"),
        Integer.parseInt(session.getAttribute("userId").toString()),
        Integer.parseInt(data.get("currentPost")));

    if (data.get("replyId") != null) {
      tempComment.setReply(Integer.valueOf(data.get("replyId")));
    }

    commentService.add(tempComment);

    return "redirect:/board/" + data.get("currentPost");
  }


  @PostMapping("/commenttest")
  public String addCommenttest(@RequestParam Map<String, String> data, HttpSession session,
      RedirectAttributes redirectAttributes) {
    Comment tempComment = new Comment(data.get("comment"),
        Integer.parseInt(session.getAttribute("userId").toString()),
        Integer.parseInt(data.get("currentPost")));

    if (data.get("replyId") != null) {
      tempComment.setReply(Integer.valueOf(data.get("replyId")));
      tempComment.setReply(Integer.valueOf(data.get("replyId")));
      tempComment.setReply(Integer.valueOf(data.get("replyId")));
    }

    commentService.add(tempComment);

    return "redirect:/board/" + data.get("currentPost");
  }

}
