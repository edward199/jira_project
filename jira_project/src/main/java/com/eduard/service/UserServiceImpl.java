package com.eduard.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eduard.aes.AES;
import com.eduard.entity.User;
import com.eduard.entity.dto.UserRequestDTO;
import com.eduard.entity.dto.UserResponseDTO;
import com.eduard.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	@Transactional
	public UserResponseDTO registerUser(UserRequestDTO userRequestDTO) {
		User user = new DozerBeanMapper().map(userRequestDTO, User.class);
		user.setPassword(AES.encrypt(user.getPassword(), "secret"));
		user.setCreatedDate(Timestamp.valueOf(LocalDateTime.now()));
		user.setUpdatedDate(Timestamp.valueOf(LocalDateTime.now()));
		userRepository.addUser(user);
		UserResponseDTO userResponseDTO = new DozerBeanMapper().map(user, UserResponseDTO.class);
		return userResponseDTO;
	}

	@Override
	@Transactional
	public String unregisterUser(int id) {
		return userRepository.deleteUser(id);
	}

	@Override
	@Transactional
	public List<UserResponseDTO> getUsers() {
		List<User> users = userRepository.getUsers();
		List<UserResponseDTO> usersDTO = new ArrayList<>();
		for (User user : users) {
			usersDTO.add(new DozerBeanMapper().map(user, UserResponseDTO.class));
		}
		return usersDTO;
	}

}
