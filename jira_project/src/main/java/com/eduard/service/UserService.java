package com.eduard.service;

import com.eduard.entity.dto.UserRequestDTO;
import com.eduard.entity.dto.UserResponseDTO;

public interface UserService {

	UserResponseDTO registerUser(UserRequestDTO userRequestDTO);

	String unregisterUser(int id);

}