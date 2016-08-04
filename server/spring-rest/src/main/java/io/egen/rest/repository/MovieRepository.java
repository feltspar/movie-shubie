package io.egen.rest.repository;

import java.util.List;

import io.egen.rest.entity.Movie;

public interface MovieRepository {

	public List<Movie> findAll();

	public Movie findOne(String id);

	public Movie create(Movie emp);

	public Movie update(Movie emp);

	public void delete(Movie emp);

	Movie findById(String id);

	public List<Movie> findByYear(Integer year);

	public List<Movie> findByIMDBRating();

	public List<Movie> findByIMDBVotes();
}
