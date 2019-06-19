package com.eduard.service;

import static org.junit.Assert.assertEquals;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.eduard.entity.User;
import com.eduard.repository.UserRepository;

public class TestUserService {

	@Mock
	UserRepository userRepository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getAllUsersTest() {
		List<User> users = new ArrayList<>();
		User user1 = new User("eduardoo", 1, Timestamp.valueOf("2019-06-05 14:39:17.0"),
				Timestamp.valueOf("2019-06-05 14:39:17.0"), "Eduard", "Venghiac", "edi", "eduard.venghiac@fortech.ro",
				null);
		User user2 = new User("eduard", 1, Timestamp.valueOf("2019-06-05 16:21:08.0"),
				Timestamp.valueOf("2019-06-05 16:21:08.0"), "Eduard", "Venghiac", "edi", "eduard.venghiac@fortech.ro",
				null);
		User user3 = new User("edu", 1, Timestamp.valueOf("2019-06-06 13:48:23.0"),
				Timestamp.valueOf("2019-06-06 13:48:23.0"), "Eduard", "Venghiac", "edi", "eduard.venghiac@fortech.ro",
				null);
		User user4 = new User("asdfsa", 1, Timestamp.valueOf("2019-06-07 15:22:53.0"),
				Timestamp.valueOf("2019-06-07 15:22:53.0"), "asdf", "fdfasasas", "asd", "asdfas", null);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);

		Mockito.when(userRepository.getUsers()).thenReturn(users);

		List<User> userss = userRepository.getUsers();

		assertEquals(4, userss.size());

		Mockito.verify(userRepository, Mockito.times(1)).getUsers();
	}

	@Test
	public void getUsersNewerThanADateTest() {
		List<User> users = new ArrayList<>();

		User user = new User("asdfsa", 1, Timestamp.valueOf("2019-06-07 15:22:53.0"),
				Timestamp.valueOf("2019-06-07 15:22:53.0"), "asdf", "fdfasasas", "asd", "asdfas", null);
		users.add(user);

		Mockito.when(userRepository.getUsersNewerThanADate(Timestamp.valueOf("2019-06-06 13:48:23.0")))
				.thenReturn(users);
		assertEquals(1, users.size());
		assertEquals("asdfsa", users.get(0).getUserName());
	}

	@Test
	public void getUserByUsernameTest() {

		User resultUser = Mockito.mock(User.class);

		Mockito.when(userRepository.getUserByUsername("eduard")).thenReturn(resultUser);

		Mockito.when(resultUser.getUserName()).thenReturn("eduard");

		assertEquals("eduard", resultUser.getUserName());
	}
}
