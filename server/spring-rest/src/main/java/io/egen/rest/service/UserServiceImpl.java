package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.User;
import io.egen.rest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public User createUser(User user) {
		return userRepository.createUser(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

	@Override
	public User findUserById(String userId) {
		return userRepository.findUserById(userId);
	}

	@Override
	@Transactional
	public User updateUser(String userId, User user) {
		User existing = userRepository.findUserById(userId);
		if(existing == null){
			return null; //not found exception
		}
		return userRepository.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(String userId) {
		User existing = userRepository.findUserById(userId);
		if(existing == null){
			 //throw not found exception
		}
		userRepository.deleteUser(existing);
	}

}
