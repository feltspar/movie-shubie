package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.User;

public interface UserRepository {

	void deleteUser(User user);

	User updateUser(User user);

	User findUserById(String userId);

	List<User> findAllUsers();

	User createUser(User user);

}
