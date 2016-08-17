package io.egen.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egen.rest.entity.Movie;
import io.egen.rest.service.MovieService;

@RestController
@RequestMapping(path = "titles")
public class MovieController {

	@Autowired
	MovieService movieService;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> findAll() {
		return movieService.findAll();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/type/movie", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> getByTypeMovies() {
		return movieService.getByType("movie");
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/type/series", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> getByTypeSeries() {
		return movieService.getByType("series");
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/imdbrating", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> getByIMDBRating() {
		return movieService.findByIMDBRating();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/year{y}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> getByYear(@PathVariable("y") String year) {
			return movieService.findByYear(year);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/imdbvotes", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Movie> getByIMDBVotes() {
		return movieService.findIMDBVotes();
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie findOne(@PathVariable("id") String movieId) {
		return movieService.findOne(movieId);
	}

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie create(@RequestBody Movie movie) {
		return movieService.create(movie);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Movie update(@PathVariable("id") String movieId, @RequestBody Movie movie) {
		return movieService.update(movieId, movie);
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "{id}")
	public void delete(@PathVariable("id") String movieId) {
		movieService.delete(movieId);
	}
}
