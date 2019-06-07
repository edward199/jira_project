package com.eduard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eduard.entity.dto.UserRequestDTO;
import com.eduard.entity.dto.UserResponseDTO;
import com.eduard.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listUsers(ModelMap model) {
		List<UserResponseDTO> users = userService.getUsers();

		model.addAttribute("users", users);

		return "listusers";

	}

	@RequestMapping(value = "/showRegisterForm", method = RequestMethod.GET)
	public String showRegisterForm(Model theModel) {
		UserRequestDTO userModel = new UserRequestDTO();

		theModel.addAttribute("user", userModel);

		return "register";
	}

	@ModelAttribute("user")
	public UserRequestDTO createUserRequestDTO() {
		return new UserRequestDTO();
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") UserRequestDTO userRequestDTO, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "error";
		}
		model.addAttribute("userName", userRequestDTO.getUserName());
		model.addAttribute("password", userRequestDTO.getPassword());
		model.addAttribute("active", userRequestDTO.getActive());
		model.addAttribute("firstName", userRequestDTO.getFirstName());
		model.addAttribute("lastName", userRequestDTO.getLastName());
		model.addAttribute("displayName", userRequestDTO.getDisplayName());
		model.addAttribute("emailAddress", userRequestDTO.getEmailAddress());
		userService.registerUser(userRequestDTO);
		return "redirect:/user/list";
	}
}