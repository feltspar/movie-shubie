package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Comment;
import io.egen.rest.exception.BadRequestException;
import io.egen.rest.exception.CommentAlreadyExistsException;
import io.egen.rest.exception.CommentNotFoundException;
import io.egen.rest.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentRepository commentRepository;
	
	@Override
	@Transactional
	public Comment create(Comment comment) {
		Comment existing = commentRepository.findOne(comment.getCommentId());
		if(existing != null){
			throw new CommentAlreadyExistsException("Comment Already Esists");//make a more sensible exception.
		}
		return commentRepository.create(comment);
	}	
	
	@Override
	public List<Comment> findAllByMovie(String movieId) {
		//add exception check
		if(movieId == null){
			throw new BadRequestException("Invalid or Null id");
		}
		return commentRepository.findAllByMovie(movieId);
	}

	@Override
	public List<Comment> findByMovieAndUser(String movieId, String userId) {
		//add exception check
		return commentRepository.findByMovieAndUser(movieId, userId);
	}

	@Override
	public List<Comment> findByUser(String userId) {
		//add exception check
		return commentRepository.findAllByUser(userId);
	}
	
	@Override
	@Transactional
	public Comment update(String commentId, Comment comment) {
		Comment existing = commentRepository.findOne(commentId);
		if (existing == null) {
			throw new CommentNotFoundException("Comment with id:" + commentId + " not found");
		}
		return commentRepository.update(commentId, comment);
	}

	@Override
	@Transactional
	public void delete(String commentId) {
		Comment existing = commentRepository.findOne(commentId);
		if (existing == null) {
			throw new CommentNotFoundException("Comment with id:" + commentId + " not found");
		}
		commentRepository.delete(existing);
	}
}
