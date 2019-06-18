package com.eduard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

	@GetMapping(value = "/list")
	public String listUsers(ModelMap model) {
		List<UserResponseDTO> users = userService.getUsers();

		model.addAttribute("users", users);

		return "list-users";

	}

	@GetMapping(value = "/{username}")
	public String listUserByUsername(ModelMap model, @PathVariable("username") String username) {
		UserResponseDTO user = userService.getUserByUsername(username);

		model.addAttribute("user", user);

		return "list-user";

	}

	@GetMapping(value = "/showUserRegisterForm")
	public String showUserRegisterForm(Model theModel) {
		UserRequestDTO userModel = new UserRequestDTO();

		theModel.addAttribute("user", userModel);

		return "register-user";
	}

	@ModelAttribute("user")
	public UserRequestDTO createUserRequestDTO() {
		return new UserRequestDTO();
	}

	@PostMapping(value = "/registerUser")
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