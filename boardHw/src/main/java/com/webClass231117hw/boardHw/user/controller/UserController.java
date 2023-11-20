package com.webClass231117hw.boardHw.user.controller;

import java.sql.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.webClass231117hw.boardHw.user.domain.User;
import com.webClass231117hw.boardHw.user.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("/join")
  public String joinPage(Model model) {

    model.addAttribute("title", "회원가입");
    model.addAttribute("path", "/join/index");
    model.addAttribute("content", "joinFragment");
    model.addAttribute("contentHead", "joinFragmentHead");

    return "/basic/layout";
  }

  @PostMapping("/join")
  public String joinPagePost(@RequestParam Map<String, String> data) {
    System.out.println(data.get("birth"));
    userService.add(new User(data.get("user-id"), data.get("password"), data.get("name"),
        data.get("phone"), data.get("address"), data.get("email"), data.get("git-address"),
        data.get("gender") == "1", Date.valueOf(data.get("birth"))));
    return "redirect:/";
  }

  @GetMapping("/login")
  public String loginPage(Model model) {
    model.addAttribute("title", "로그인");
    model.addAttribute("path", "/login/index");
    model.addAttribute("content", "loginFragment");
    model.addAttribute("contentHead", "loginFragmentHead");

    return "/basic/layout";
  }

  @PostMapping("/login")
  public String loginPagePost(@RequestParam Map<String, String> data, HttpSession session) {
    if (userService.login(data.get("user-id"), data.get("password")) != 0) {
      session.setAttribute("user-id", userService.login(data.get("user-id"), data.get("password")));
      return "redirect:/";
    } else {
      return "redirect:/login";
    }
  }

  @GetMapping("/logout")
  public String logout(HttpSession session) {

    session.setAttribute("user-id", null);
    return "redirect:/";

  }
}
