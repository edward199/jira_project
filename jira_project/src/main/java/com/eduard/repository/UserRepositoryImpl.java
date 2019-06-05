package com.eduard.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.eduard.entity.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User addUser(User user) {
		em.persist(user);
		em.flush();
		return user;
	}

	@Override
	public String deleteUser(int id) {
		User user = em.find(User.class, id);
		em.remove(user);
		em.flush();
		return "User deleted successfully";
	}

}
