package io.egen.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({
		@NamedQuery(name = "Comment.findByUser", query = "SELECT c FROM Comment c WHERE c.commenterId =:pUserId"),
		@NamedQuery(name = "Comment.findByMovie", query = "SELECT c FROM Comment c WHERE c.movieId =:pMovieId"),
		@NamedQuery(name = "Comment.findByMovieAndUser", query = "SELECT c FROM Comment c WHERE c.movieId = :pMovieId AND c.commenterId = :pUserId")
})
public class Comment {
	
	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String commentId;
	
	private String commenterId;
	private String movieId;
	private String content;
	
	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getCommenterId() {
		return commenterId;
	}

	public void setCommenterId(String commenterId) {
		this.commenterId = commenterId;
	}

	public String getMovieId() {
		return movieId;
	}

	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commenterId=" + commenterId + ", movieId=" + movieId
				+ ", content=" + content + "]";
	}
	
}
