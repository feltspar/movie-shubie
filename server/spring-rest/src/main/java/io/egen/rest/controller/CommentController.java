package io.egen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.rest.entity.Comment;
import io.egen.rest.service.CommentService;

@RestController
@RequestMapping(path = "comment")
public class CommentController {

	@Autowired
	CommentService commentService;
	
	//all movie comments
	@RequestMapping(method = RequestMethod.GET, path ="/movie{movieId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comment> findAllByMovie(@PathVariable("movieId") String movieId){
		return commentService.findAllByMovie(movieId);
	}
	
	//all users comments
	@RequestMapping(method = RequestMethod.GET, path ="/user{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comment> findAllByUser(@PathVariable("userId") String userId){
		return commentService.findAllByMovie(userId);
	}
	
	//user's comments on a movie
	@RequestMapping(method = RequestMethod.GET, path ="/movie{movieId}/user{userId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comment> findAllByUser(@PathVariable("movieId") String movieId, @PathVariable("userId") String userId){
		return commentService.findByMovieAndUser(movieId, userId);
	}
	
	//create
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment create(@RequestBody Comment comment) {
		return commentService.create(comment);
	}
	
	//update
	@RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Comment updateComment(@PathVariable("id") String commentId, @RequestBody Comment comment) {
		return commentService.update(commentId, comment);
	}
	
	//delete
	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String commentId) {
		commentService.delete(commentId);
	}
	
	//all comments ONLY FOR ADMIN. 
	/*@RequestMapping(method = RequestMethod.GET, path = "all", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Comment> getAll(){
		System.out.println("Returning all ");
		return null;
	}*/
	
}
