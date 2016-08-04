package io.egen.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import io.egen.rest.entity.Cast;
import io.egen.rest.entity.Genre;
import io.egen.rest.entity.ImdbData;
import io.egen.rest.entity.Movie;

@Repository
public class MovieRepositoryImp implements MovieRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Movie create(Movie movie) {
		em.persist(movie);
		return movie;
	}
	
	@Override
	public List<Movie> findAll() {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findAll", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> findByYear(Integer year) {
		System.out.println("year");
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByYear", Movie.class);
		query.setParameter("pyear", year);
		return query.getResultList();
	}

	@Override
	public List<Movie> findByIMDBRating() {
		System.out.println("rating");
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByIMDBRating", Movie.class);
		return query.getResultList();
	}

	@Override
	public List<Movie> findByIMDBVotes() {
		System.out.println("votes");
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findByIMDBRating", Movie.class);
		return query.getResultList();
	}
	
	@Override
	public Movie findOne(String id) {
		return em.find(Movie.class, id);
	}

	
	@Override
	public Movie findById(String id) {
		TypedQuery<Movie> query = em.createNamedQuery("Movie.findById", Movie.class);
		query.setParameter("pId", id);
		List<Movie> Movies = query.getResultList();
		if (Movies != null && Movies.size() == 1) {
			return Movies.get(0);
		}
		return null;
	}

	

	@Override
	public Movie update(Movie movie) {	
		ImdbData imdb = movie.getImdb();
		em.merge(imdb);
		
		List<Cast> cast = movie.getCast();
		for(Cast c : cast){
			em.merge(c);
		}
		
		List<Genre> genre = movie.getGenre();
		for(Genre g : genre){
			em.merge(g);
		}
		movie.setCast(cast);
		movie.setGenre(genre);
		movie.setImdb(imdb);
			
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
		//consider deleting all related comments.
	}

	
}
