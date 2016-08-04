package io.egen.rest.entity;

//import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import io.egen.rest.entity.Cast;
import io.egen.rest.entity.ImdbData;

@Entity
@Table
@NamedQueries({ 
		@NamedQuery(name = "Movie.findAll", query = "SELECT m FROM Movie m ORDER BY m.id ASC"),
		@NamedQuery(name = "Movie.findById", query = "SELECT m FROM Movie m WHERE m.id=:pId"),
		@NamedQuery(name = "Movie.findByYear", query = "SELECT m FROM Movie m WHERE m.year=:pyear"),
		@NamedQuery(name = "Movie.findByIMDBRating", query = "SELECT m FROM Movie m ORDER BY m.imdb.imdbRating DESC"),
		@NamedQuery(name = "Movie.findByIMDVotes", query = "SELECT m FROM Movie m ORDER BY m.imdb.imdbVotes DESC")
})
public class Movie {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;

	private String title;
	private Integer year;
	private String censorRating;
	private String releaseDate; // make into Date object
	private Integer runtime; //minutes
	
	@ManyToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Genre> genre; 
	
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Cast> cast;
	
	private String plot;
	
	private String language; // consider making list
	
	private String country; // consider making list
	
	private String award; 

	private String posterURL;
	
	@OneToOne(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private ImdbData imdb;
	
	private String type;
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public String getCensorRating() {
		return censorRating;
	}

	public void setCensorRating(String censorRating) {
		this.censorRating = censorRating;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPosterURL() {
		return posterURL;
	}

	public void setPosterURL(String posterURL) {
		this.posterURL = posterURL;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public List<Genre> getGenre() {
		return genre;
	}

	public void setGenre(List<Genre> genre) {
		this.genre = genre;
	}

	public ImdbData getImdb() {
		return imdb;
	}

	public void setImdb(ImdbData imdb) {
		this.imdb = imdb;
	}

	public List<Cast> getCast() {
		return cast;
	}

	public void setCast(List<Cast> cast) {
		this.cast = cast;
	}
	
	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", year=" + year + ", censorRating=" + censorRating
				+ ", releaseDate=" + releaseDate + ", runtime=" + runtime + ", genre=" + genre + ", cast=" + cast
				+ ", plot=" + plot + ", language=" + language + ", country=" + country + ", award=" + award
				+ ", posterURL=" + posterURL + ", imdb=" + imdb + ", type=" + type + "]";
	}
}

/*
  {

	"title": "interstellar",
	"year": "2014",
	"censorRating": "pg-13",
	"releaseDate": "07 nov 2014",
	"runtime": 169,
	"genre": [{
		"genreName": "adventure"},{
		"genreName": "drama"},{
		"genreName": "sci-fi"
	}],
	"cast": [{
		"type": "director",
		"name": "christopher nolan"
	}, {
		"type": "writer",
		"name": "jonathan nolan"
	}, {
		"type": "writer",
		"name": "christopher nolan"
	}, {
		"type": "actors",
		"name": "ellen burstyn"
	}, {
		"type": "actors",
		"name": "ellen burstyn"
	}],
	"plot": "a team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival.",
	"language": "english",
	"country": "usa, uk",
	"award": "won 1 oscar. another 35 wins & 123 nominations.",
	"poster": "http://ia.media-imdb.com/images/m/mv5bmjixntu4mzy4mf5bml5banbnxkftztgwmzm4odi3mje@._v1_sx300.jpg",
	"imdb": {
		"metascore": 74,
		"imdbRating": 8.6,
		"imdbVotes": 821030,
		"imdbId": "tt0816692"
	},
	"type": "movie"
}
*/