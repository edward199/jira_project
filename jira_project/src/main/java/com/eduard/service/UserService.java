package com.eduard.service;

import java.util.List;

import com.eduard.entity.dto.UserRequestDTO;
import com.eduard.entity.dto.UserResponseDTO;

public interface UserService {

	UserResponseDTO registerUser(UserRequestDTO userRequestDTO);

	String unregisterUser(int id);

	List<UserResponseDTO> getUsers();

}