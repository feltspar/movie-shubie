package io.egen.rest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ImdbData {
	
	@Id
	private String imdbId;
	private Double metascore;
	private Double imdbRating;
	private Integer imdbVotes;
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public Double getMetascore() {
		return metascore;
	}
	public void setMetascore(Double metascore) {
		this.metascore = metascore;
	}
	public Double getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}
	public Integer getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(Integer imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	@Override
	public String toString() {
		return "IMDBMovieData [imdbId=" + imdbId + ", metascore=" + metascore + ", imdbRating=" + imdbRating
				+ ", imdbVotes=" + imdbVotes + "]";
	}
	
}
