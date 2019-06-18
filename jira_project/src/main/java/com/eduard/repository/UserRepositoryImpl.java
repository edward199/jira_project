package com.eduard.repository;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@Override
	public List<User> getUsers() {
		List<User> users = em.createQuery("From User").getResultList();

		return users;
	}

	@Override
	public List<User> getUsersNewerThanADate(Timestamp dateToCompare) {

		Query qry = em.createQuery("From User u where u.createdDate>=:a");

		qry.setParameter("a", dateToCompare);

		List<User> users = qry.getResultList();

		return users;

	}

	@Override
	public User getUserByUsername(String username) {

		Query qry = em.createQuery("From User u where u.userName=:a");

		qry.setParameter("a", username);

		User user = (User) qry.getSingleResult();

		return user;

	}

}
