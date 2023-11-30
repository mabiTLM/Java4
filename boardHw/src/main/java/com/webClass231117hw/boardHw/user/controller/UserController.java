package com.webClass231117hw.boardHw.user.controller;

import java.sql.Date;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.webClass231117hw.boardHw.user.domain.User;
import com.webClass231117hw.boardHw.user.service.UserService;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/user/regist")
  public String regist(Model model) {
    model.addAttribute("title", "회원가입");
    model.addAttribute("path", "/user/regist");
    model.addAttribute("content", "registFragment");
    model.addAttribute("contentHead", "registFragmentHead");
    return "basic/layout";
  }

  @PostMapping("/user/regist")
  public String registPost(@RequestParam Map<String, String> map, Model model,
      RedirectAttributes redirectAttributes) {
    try {
      if (map.get("userId").replaceAll("[a-zA-Z0-9]", "").equals("")
          && map.get("userId").length() > 2 && map.get("userId").length() < 21) {

        if (map.get("password").replaceAll("[A-Za-z\\d!@#$%^&]", "").equals("")
            && map.get("password").length() > 9 && map.get("password").length() < 31) {
          if (map.get("name").replaceAll("[가-힣]", "aa").length() > 3
              && map.get("name").replaceAll("[가-힣]", "aa").length() < 21) {
            if (map.get("phone").replaceAll("[0-9-]", "").equals("")
                && (map.get("phone").replaceAll("-", "").length() == 10
                    || map.get("phone").replaceAll("-", "").length() == 11)) {

              if (map.get("email").endsWith(".com") || map.get("email").endsWith(".org")
                  || map.get("email").endsWith(".net") || map.get("email").endsWith(".co.kr")) {

                User tempUser = new User(map.get("userId"), map.get("password"), map.get("name"),
                    map.get("phone"), map.get("email"));

                if (map.get("address") != "") {
                  tempUser.setAddress(map.get("address"));
                }
                if (map.get("gitAddress") != "") {
                  map.get("gitAddress").replaceAll("https://github.com/", "");
                  tempUser.setGitAddress("https://github.com/" + map.get("gitAddress"));
                }
                if (map.get("gender") != null) {
                  tempUser.setGender(Integer.parseInt(map.get("gender")));
                }
                if (map.get("birth") != "") {
                  tempUser.setBirth(Date.valueOf(map.get("birth")));
                }
                userService.add(tempUser);
              }
            }
          }
        }
      }
      return "redirect:/";

    } catch (Exception e) {
      e.printStackTrace();
      redirectAttributes.addFlashAttribute("requestError", "아이디 또는 이메일 중복");
      return "redirect:/user/regist";
    }
  }

  @PostMapping("/user/login")
  public String loginPost(@RequestParam Map<String, String> map, HttpSession session,
      RedirectAttributes redirectAttributes) {
    User tempUser = new User();
    tempUser.setUserId(map.get("userId"));
    tempUser.setPassword(map.get("password"));
    tempUser = userService.login(tempUser);
    if (tempUser != null) {
      session.setAttribute("userName", tempUser.getName());
      session.setAttribute("userId", tempUser.getId());
    } else {
      redirectAttributes.addFlashAttribute("requestError", "로그인 실패 아이디 또는 비밀번호 확인");
    }
    return "redirect:/";
  }


  @GetMapping("/user/logout")
  public String logout(HttpSession session) {
    session.removeAttribute("userName");
    session.removeAttribute("userId");
    return "redirect:/";
  }


  // @GetMapping("/login")
  // public String loginPage(Model model) {
  // model.addAttribute("title", "로그인");
  // model.addAttribute("path", "/login/index");
  // model.addAttribute("content", "loginFragment");
  // model.addAttribute("contentHead", "loginFragmentHead");
  //
  // return "/basic/layout";
  // }
  //
  // @PostMapping("/login")
  // public String loginPagePost(@RequestParam Map<String, String> data, HttpSession session) {
  // if (userService.login(data.get("user-id"), data.get("password")) != 0) {
  // session.setAttribute("userId", userService.login(data.get("user-id"), data.get("password")));
  // return "redirect:/";
  // } else {
  // return "redirect:/login";
  // }
  // }
  // @GetMapping("/join")
  // public String joinPage(Model model) {
  // model.addAttribute("title", "회원가입");
  // model.addAttribute("path", "/join/index");
  // model.addAttribute("content", "joinFragment");
  // model.addAttribute("contentHead", "joinFragmentHead");
  // return "/basic/layout";
  // }
  //
  // @PostMapping("/join")
  // public String joinPagePost(@RequestParam Map<String, String> data) {
  //
  // User tempUser = new User(data.get("user-id"), data.get("password"), data.get("name"),
  // data.get("phone"), data.get("email"));
  // tempUser.setAddress(data.get("address"));
  // tempUser.setGitAddress(data.get("git-address"));
  // tempUser.setGender(Integer.parseInt(data.get("gender")));
  // tempUser.setBirth(Date.valueOf(data.get("birth")));
  // userService.add(tempUser);
  // return "redirect:/";
  // }
}
