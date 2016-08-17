package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.rest.entity.User;

@Repository
public class UserRepositoryImp implements UserRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public User createUser(User user) {
		em.persist(user);
		return null;
	}
	
	@Override
	public User updateUser(User user) {
		return em.merge(user);
	}

	@Override
	public User findUserById(String userId) {
		return em.find(User.class, userId);
	}

	//security hazard. (password will be visible. )
	@Override
	public List<User> findAllUsers() {
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	
	@Override
	public void deleteUser(User user) {
		em.remove(user);
	}

	@Override
	public User login(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);
		return query.getSingleResult();
	}

}
