package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.rest.entity.Comment;

@Repository
public class CommentRepositoryImpl implements CommentRepository {

	@PersistenceContext
	private EntityManager em;
	
	
	@Override
	public Comment create(Comment comment) {
		em.persist(comment);
		return comment;
	}	
	
	@Override
	public Comment findOne(String commentId) {
		return em.find(Comment.class, commentId);
	}

	
	@Override
	public List<Comment> findAllByUser(String userId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findByUser", Comment.class);
		query.setParameter("pUserId", userId);
		return query.getResultList();
	}	

	@Override
	public List<Comment> findAllByMovie(String movieId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findByMovie", Comment.class);
		query.setParameter("pMovieId", movieId);
		return query.getResultList();
	}

	@Override
	public List<Comment> findByMovieAndUser(String movieId, String userId) {
		TypedQuery<Comment> query = em.createNamedQuery("Comment.findByMovieAndUser", Comment.class);
		query.setParameter("pMovieId", movieId);
		query.setParameter("pUserId", userId);
		return query.getResultList();
	}

	@Override
	public Comment update(String commentId, Comment comment) {
		em.merge(comment);
		return comment;
	}

	@Override
	public void delete(Comment comment) {
		em.remove(comment);
	}
}
