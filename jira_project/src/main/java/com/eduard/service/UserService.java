package com.eduard.service;

import java.sql.Timestamp;
import java.util.List;

import com.eduard.entity.dto.UserRequestDTO;
import com.eduard.entity.dto.UserResponseDTO;

public interface UserService {

	UserResponseDTO registerUser(UserRequestDTO userRequestDTO);

	String unregisterUser(int id);

	List<UserResponseDTO> getUsers();

	List<UserResponseDTO> getUsersNewerThanADate(Timestamp dateToCompare);

	UserResponseDTO getUserByUsername(String username);

}