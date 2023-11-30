package com.webClass231117hw.boardHw.board.controller;

import java.io.File;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.webClass231117hw.boardHw.board.domain.Board;
import com.webClass231117hw.boardHw.board.service.BoardService;
import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {
  @Autowired
  BoardService boardService;

  int count = 5;

  @GetMapping("/")
  public String boardMainPage(Model model, @RequestParam Map<String, String> data) {
    int page = data.get("page") != null ? Integer.parseInt(data.get("page")) : 1;
    model.addAttribute("title", "게시판");
    model.addAttribute("path", "/board/index");
    model.addAttribute("content", "boardFragment");
    model.addAttribute("contentHead", "boardFragmentHead");
    model.addAttribute("list", boardService.getAll(page, count));
    model.addAttribute("pageCount", boardService.getPageCount(count));
    return "/basic/layout";
  }


  // @GetMapping("/")
  // public String boardMainPage(Model model, @RequestParam Map<String, String> data) {
  // model.addAttribute("title", "게시판");
  // model.addAttribute("path", "/board/index");
  // model.addAttribute("content", "boardFragment");
  // model.addAttribute("contentHead", "boardFragmentHead");
  //
  // int tempPage = 1;
  // if (data.get("page") != null) {
  // tempPage = Integer.parseInt(data.get("page"));
  // }
  // if (tempPage < 1) {
  // tempPage = 1;
  // }
  // int tempTotalPage = boardService.getAll().size() / count + 1;
  // if (boardService.getAll().size() % count == 0) {
  // tempTotalPage = tempTotalPage - 1;
  // }
  // if (tempPage > tempTotalPage) {
  // tempPage = tempTotalPage;
  // }
  // model.addAttribute("list", boardService.getAll(tempPage));
  // model.addAttribute("currentPage", tempPage);
  // model.addAttribute("totalPage", tempTotalPage);
  // return "/basic/layout";
  // }

  @PostMapping("/add")
  public String add(@RequestParam Map<String, String> data, HttpSession session,
      RedirectAttributes redirectAttributes) {
    try {
      String tempContent = data.get("content");
      tempContent = tempContent.replaceAll("width=\"[0-9]*\"", "width=\"100%\"");
      tempContent = tempContent.replaceAll("height=\"[0-9]*\"", "height=\"auto\"");
      boardService.add(new Board(data.get("title"), tempContent,
          Integer.parseInt(session.getAttribute("userId").toString())));
    } catch (Exception e) {
      redirectAttributes.addFlashAttribute("requestError", "게시글을 정확히 입력해주세요");
      e.printStackTrace();
    }
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


  @GetMapping("/board/{boardId}")
  public String itemPage(Model model, @PathVariable("boardId") int boardId) {
    Board board = boardService.get(boardId);

    model.addAttribute("title", board.getTitle());
    model.addAttribute("path", "/board/item");
    model.addAttribute("content", "boardItemFragment");
    model.addAttribute("contentHead", "boardItemFragmentHead");
    board.setContent(board.getContent().replace("\n", "<br />"));
    model.addAttribute("board", board);


    return "/basic/layout";
  }

  @PostMapping("/upload")
  @ResponseBody
  public ModelMap uploadImage(MultipartHttpServletRequest req) {
    ModelMap model = new ModelMap();
    try {
      MultipartFile uploadFile = req.getFile("upload");
      System.out.println(uploadFile.getOriginalFilename());
      String originName = uploadFile.getOriginalFilename();
      String[] tempNames = originName.split("[.]");
      System.out.println(tempNames[0]);
      String ext = originName.substring(originName.indexOf("."));
      String randomName = UUID.randomUUID() + ext;
      String savePath =
          "C:\\Users\\KGA\\git\\Java4\\boardHw\\src\\main\\resources\\static\\imgs\\" + randomName;
      String uploadUrl = "/imgs/" + randomName;
      File file = new File(savePath);
      uploadFile.transferTo(file);
      model.addAttribute("uploaded", true);
      model.addAttribute("url", uploadUrl);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return model;
  }



  @PostMapping("/delete")
  public String deletePage(HttpSession session, @RequestParam Map<String, String> data) {
    if (Integer.parseInt(session.getAttribute("userId").toString()) == Integer
        .parseInt(data.get("postUser"))) {
      boardService.delete(Integer.parseInt(data.get("currentPost")));
    }
    return "redirect:/";
  }

  @GetMapping("/edit")
  public String editPage(Model model, HttpSession session, @RequestParam Map<String, String> data) {
    if (Integer.parseInt(session.getAttribute("userId").toString()) == Integer
        .parseInt(data.get("postUser"))) {
      model.addAttribute("title", "수정");
      model.addAttribute("path", "/board/edit");
      model.addAttribute("content", "editFragment");
      model.addAttribute("contentHead", "editFragmentHead");
      model.addAttribute("editPost", boardService.get(Integer.parseInt(data.get("currentPost"))));
      return "/basic/layout";
    }
    return "redirect:/";
  }

  @PostMapping("/edit")
  public String editPagePost(HttpSession session, @RequestParam Map<String, String> data) {
    if (Integer.parseInt(session.getAttribute("userId").toString()) == Integer
        .parseInt(data.get("postUser"))) {

      boardService.edit(Integer.parseInt(data.get("currentPost")), data.get("title"),
          data.get("content"));
    }
    return "redirect:/";
  }

  // @GetMapping("/print")
  // public String printPage(Model model, @RequestParam Map<String, String> data) {
  // Board tempBoard = boardService.get(Integer.parseInt(data.get("postId")));
  // model.addAttribute("title", tempBoard.getTitle());
  // model.addAttribute("path", "/board/boardPrint");
  // model.addAttribute("content", "printFragment");
  // model.addAttribute("contentHead", "printFragmentHead");
  // model.addAttribute("currentPost", tempBoard);
  // return "/basic/layout";
  // }
}
