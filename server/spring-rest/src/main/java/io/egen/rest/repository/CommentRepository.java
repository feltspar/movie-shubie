package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Comment;

public interface CommentRepository {

	Comment create(Comment comment);
	
	Comment findOne(String commentId);	

	List<Comment> findAllByUser(String userId);

	List<Comment> findAllByMovie(String movieId);

	List<Comment> findByMovieAndUser(String movieId, String userId);
	
	Comment update(String commentId, Comment comment);

	void delete(Comment comment);
}
