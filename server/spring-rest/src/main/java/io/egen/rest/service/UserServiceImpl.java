package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.User;
import io.egen.rest.exception.UserAlreadyExistsException;
import io.egen.rest.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public User createUser(User user) {
		User exist = userRepository.findUserById(user.getUserId()); 
		if(exist != null){
			throw new UserAlreadyExistsException("User with id: "+user.getUserId()+" already exists");
		}
		return userRepository.createUser(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}

	@Override
	public User findUserById(String userId) {
		User exist = userRepository.findUserById(userId); 
		if(exist == null){
			throw new UserAlreadyExistsException("User wit id: "+ userId+" not found.");
		}
		return userRepository.findUserById(userId);
	}

	@Override
	@Transactional
	public User updateUser(String userId, User user) {
		User existing = userRepository.findUserById(userId);
		if(existing == null){
			throw new UserAlreadyExistsException("User wit id: "+ userId+" not found.");
		}
		return userRepository.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(String userId) {
		User existing = userRepository.findUserById(userId);
		if(existing == null){
			throw new UserAlreadyExistsException("User wit id: "+ userId+" not found.");
		}
		userRepository.deleteUser(existing);
	}

	@Override
	public User login(User user) {
		User backend = userRepository.login(user.getEmail());
		if(user.getPassWord().equals(backend.getPassWord())){
			return user;
		}
		else
			return null;
	}

	
}
