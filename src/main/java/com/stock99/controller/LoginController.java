/**
 * 
 */
package com.stock99.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stock99.model.UserVO;
import com.stock99.service.UserManager;

/**
 * @author anthonydonx
 * 
 */
@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	@Autowired
	UserManager userManager;
	@Value("#{applicationProperties['application.imageUrl']}") String imageUrl;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		logger.info("Welcome home!");

		List<UserVO> userlist = userManager.getAll();
		model.addAttribute("controllerMessage",
				"This is the message from the controller!");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginTry(@RequestParam("username") String username,
			@RequestParam("password") String password,
			HttpServletRequest request, HttpServletResponse response) {
		boolean find = false;
		String uType = "";

		UserVO userVO;
		try {
			userVO = userManager.get(username);
			if (userVO.getPassword().equals(password)) {
				find = true;
				uType = userVO.getUsertype();
				HttpSession session = request.getSession();
				session.setAttribute("uname", userVO.getUsername());
				session.setAttribute("utype", userVO.getUsertype());
				session.setAttribute("url", imageUrl+userVO.getUrl());

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

		if (find && uType.equals("admin")) {
			return "redirect:home";
		} else if (find && uType.equals("booker")) {
			return "redirect:booking";
		} else if (find && uType.equals("user")) {
			return "redirect:grnin";
		} else {
			return "redirect:";
		}

	}

}
