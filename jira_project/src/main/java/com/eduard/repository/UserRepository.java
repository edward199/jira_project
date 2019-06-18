package com.eduard.repository;

import java.sql.Timestamp;
import java.util.List;

import com.eduard.entity.User;

public interface UserRepository {

	User addUser(User user);

	String deleteUser(int id);

	List<User> getUsers();

	List<User> getUsersNewerThanADate(Timestamp dateToCompare);

	User getUserByUsername(String username);
}