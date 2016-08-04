package io.egen.rest.service;

import java.util.List;

import io.egen.rest.entity.Movie;

public interface MovieService {

	public List<Movie> findAll();

	public Movie findOne(String id);

	public List<Movie> findByYear(String year);

	public List<Movie> findByIMDBRating();

	public List<Movie> findIMDBVotes();

	public Movie create(Movie emp);

	public Movie update(String id, Movie emp);

	public void delete(String id);

}
