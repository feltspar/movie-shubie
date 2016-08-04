package io.egen.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.egen.rest.entity.Movie;
import io.egen.rest.exception.BadRequestException;
import io.egen.rest.exception.MovieAlreadyExistsException;
import io.egen.rest.exception.MovieNotFoundException;
import io.egen.rest.repository.MovieRepository;

@Service
public class MovieServiceImp implements MovieService {

	@Autowired
	MovieRepository repository;

	@Override
	@Transactional
	public Movie create(Movie mov) {
		Movie existing = repository.findById(mov.getId());
		if (existing != null) {
			throw new MovieAlreadyExistsException("Movie already exists: " + mov.getId());
		}
		return repository.create(mov);
	}
	
	@Override
	public List<Movie> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Movie> findByYear(String y) {
		if(y!=null){
			Integer year = Integer.parseInt(y);
			System.out.println(year);
			return repository.findByYear(year);
		}else {
			throw new BadRequestException("Bad parameter");
		}
	}

	@Override
	public List<Movie> findByIMDBRating() {
		return repository.findByIMDBRating();
	}

	@Override
	public List<Movie> findIMDBVotes() {
		return repository.findByIMDBVotes();
	}
	
	@Override
	public Movie findOne(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with id:" + id + " not found");
		}
		return existing;
	}

	@Override
	@Transactional
	public Movie update(String id, Movie mov) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with id:" + id + " not found");
		}
		return repository.update(mov);
	}

	@Override
	@Transactional
	public void delete(String id) {
		Movie existing = repository.findOne(id);
		if (existing == null) {
			throw new MovieNotFoundException("Movie with id:" + id + " not found");
		}
		repository.delete(existing);
	}
}
