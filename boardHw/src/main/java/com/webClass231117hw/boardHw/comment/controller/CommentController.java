package com.webClass231117hw.boardHw.comment.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.webClass231117hw.boardHw.comment.domain.Comment;
import com.webClass231117hw.boardHw.comment.service.CommentService;

@Controller
@RequestMapping("/comments")
public class CommentController {
  @Autowired
  CommentService commentService;

  @GetMapping
  @ResponseBody
  public List<Comment> getComments(@RequestParam Map<String, String> map) {
    return commentService.getComments(Integer.parseInt(map.get("boardId")), 0);
  }

  @PostMapping("add")
  public String add(@RequestParam Map<String, String> map) {
    Comment comment = new Comment(map.get("content"), Integer.parseInt(map.get("user_id")),
        Integer.parseInt(map.get("board_id")));
    commentService.add(comment);
    return "redirect:/board/" + map.get("board_id");
  }
}

// @Controller
// public class CommentController {
// @Autowired
// CommentService commentService;
//
// @PostMapping("/comment")
// public String addComment(@RequestParam Map<String, String> data, HttpSession session,
// RedirectAttributes redirectAttributes) {
// Comment tempComment = new Comment(data.get("comment"),
// Integer.parseInt(session.getAttribute("userId").toString()),
// Integer.parseInt(data.get("currentPost")));
//
// if (data.get("replyId") != null) {
// tempComment.setReply(Integer.valueOf(data.get("replyId")));
// }
//
// commentService.add(tempComment);
//
// return "redirect:/board/" + data.get("currentPost");
// }
//
// @PostMapping("/commenttest")
// public String addCommenttest(@RequestParam Map<String, String> data, HttpSession session,
// RedirectAttributes redirectAttributes) {
// Comment tempComment = new Comment(data.get("comment"),
// Integer.parseInt(session.getAttribute("userId").toString()),
// Integer.parseInt(data.get("currentPost")));
//
// if (data.get("replyId") != null) {
// tempComment.setReply(Integer.valueOf(data.get("replyId")));
// tempComment.setReply(Integer.valueOf(data.get("replyId")));
// tempComment.setReply(Integer.valueOf(data.get("replyId")));
// }
//
// commentService.add(tempComment);
//
// return "redirect:/board/" + data.get("currentPost");
// }
//
// }
