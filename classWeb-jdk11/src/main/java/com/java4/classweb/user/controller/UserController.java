package com.java4.classweb.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.java4.classweb.user.domain.User;
import com.java4.classweb.user.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public String regist() {
		return "user/regist";
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPost(@RequestParam Map<String, String> map) {
		userService.add(new User(map.get("user-name"), map.get("user-id"), map.get("user-pw")));
		return "redirect:/regist";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@RequestParam Map<String, String> map, HttpSession sessoin, HttpServletRequest request) {
		User user = new User();
		user.setUserId(map.get("user-id"));
		user.setPassword(map.get("user-pw"));
		user = userService.login(user);
		if (user != null) {
			sessoin.setAttribute("userName", user.getName());
			// model.addAttribute("userName", user.getName());
		}
		return "redirect:/";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logoutPost(@RequestParam Map<String, String> map, HttpSession sessoin, HttpServletRequest request) {
		sessoin.setAttribute("userName", null);
		return "redirect:/";
	}

}
