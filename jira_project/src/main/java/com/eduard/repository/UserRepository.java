package com.eduard.repository;

import java.util.List;

import com.eduard.entity.User;

public interface UserRepository {

	User addUser(User user);

	String deleteUser(int id);

	List<User> getUsers();

}