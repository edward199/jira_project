package com.eduard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduard.entity.dto.UserRequestDTO;
import com.eduard.entity.dto.UserResponseDTO;
import com.eduard.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/register", consumes = "application/json", produces = "application/json")
	public ResponseEntity<UserResponseDTO> registerUser(@RequestBody UserRequestDTO userRequestDTO) {
		return new ResponseEntity<UserResponseDTO>(userService.registerUser(userRequestDTO), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/delete/{id}", consumes = "application/json", produces = "application/json")
	public String unregisterUser(@PathVariable("id") int id) {
		return userService.unregisterUser(id);
	}
}