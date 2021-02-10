package com.nick.ClientCaseData.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nick.ClientCaseData.models.User;
import com.nick.ClientCaseData.services.UserService;
import com.nick.ClientCaseData.validators.Validator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private Validator validator;

	
	@RequestMapping("/")
	private String index(@ModelAttribute("user") User user) {
		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if (result.hasErrors()) {
			return "index.jsp";
		}
		User newUser = this.userService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/dashboard";

	}

	@PostMapping("/login")
	public String login(HttpSession session, @RequestParam("loginEmail") String email,
			@RequestParam("loginPassword") String password, RedirectAttributes redirectAttrs) {
		if (!this.userService.authenticateUser(email, password)) {
			redirectAttrs.addFlashAttribute("loginError", "Invalid Credentials");
			return "redirect:/";
		}
		User user = this.userService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		return "redirect:/dashboard";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
