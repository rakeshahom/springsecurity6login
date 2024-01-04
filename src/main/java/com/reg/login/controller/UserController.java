package com.reg.login.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.reg.login.Dto.UserDto;
import com.reg.login.serviceImpl.CustomeUserDetailService;
import com.reg.login.services.UserService;

@Controller
public class UserController {

	@Autowired
	private CustomeUserDetailService userDetailService;

	@Autowired
	private UserService userService;

	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDto userDto) {
		return "register";

	}

	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDto userDto, Model model) {

		userService.save(userDto);
		model.addAttribute("message", "Register successfully..!");
		return "register";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/user-page")
	public String userPage(Model model, Principal principal) {
		UserDetails loadUserByUsername = userDetailService.loadUserByUsername(principal.getName());
		model.addAttribute("user", loadUserByUsername);
		return "user";
	}

	@GetMapping("/admin-page")
	public String adminPage(Model model, Principal principal) {
		UserDetails loadUserByUsername = userDetailService.loadUserByUsername(principal.getName());
		model.addAttribute("user", loadUserByUsername);
		return "admin";
	}

}
