package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.User;

public interface UserService {

	public User createUser(User user);

	public List<User> findAllUsers();

	public User findUserById(String userId);

	public User updateUser(String userId, User user);

	public void deleteUser(String userId);

}
