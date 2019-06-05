package com.eduard.repository;

import com.eduard.entity.User;

public interface UserRepository {

	User addUser(User user);

	String deleteUser(int id);

}