package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.Comment;

public interface CommentService {

	Comment create(Comment comment);
	
	List<Comment> findAllByMovie(String movieId);

	List<Comment> findByMovieAndUser(String movieId, String userId);

	List<Comment> findByUser(String userId);
	
	Comment update(String commentId, Comment comment);

	void delete(String commentId);

}
