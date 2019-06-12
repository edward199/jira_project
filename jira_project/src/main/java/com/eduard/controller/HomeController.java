
package com.eduard.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

//	private UserService userService;
//
//	@Autowired
//	public HomeController(UserService userService) {
//		this.userService = userService;
//	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String privateHome() {
		return "privatePage";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "logout";
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() + ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", "You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}

//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public String registerPage() {
//		return "register";
//	}

//	@RequestMapping(value = "/user", method = RequestMethod.GET)
//	public ModelAndView user() {
//		return new ModelAndView("register", "command", new User());
//	}
//
//	@RequestMapping(value = "/register", method = RequestMethod.GET)
//	public String registerUser(@ModelAttribute("user") UserRequestDTO userRequestDTO, BindingResult result,
//			ModelMap model) {
//		if (result.hasErrors()) {
//			return "error";
//		}
//		model.addAttribute("myuser", new UserRequestDTO());
//		model.addAttribute("userName", userRequestDTO.getUserName());
//		model.addAttribute("password", userRequestDTO.getPassword());
//		model.addAttribute("active", userRequestDTO.getActive());
//		model.addAttribute("firstName", userRequestDTO.getFirstName());
//		model.addAttribute("lastName", userRequestDTO.getLastName());
//		model.addAttribute("displayName", userRequestDTO.getDisplayName());
//		model.addAttribute("emailAddress", userRequestDTO.getEmailAddress());
//		userService.registerUser(userRequestDTO);
//		return "userview";
//	}

}