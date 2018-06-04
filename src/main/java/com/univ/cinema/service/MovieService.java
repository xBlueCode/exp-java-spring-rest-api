package com.univ.cinema.service;

import com.univ.cinema.model.Movie;
import com.univ.cinema.repo.MovieRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service layer for Movie model to handle the business logic and data management
 */
@Service
public class MovieService {

  // Autowired object of MovieRepository to handle Data Management in the service
  private MovieRepository movieRepository;

  @Autowired
  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  /**
   * Store a movie in the database.
   * @param movie The Movie object to be stored.
   */
  public void addMovie(Movie movie) {
    movieRepository.save(movie);
  }

  /**
   * Update an existing movie.
   * @param movie
   */
  public void updateMovie(Movie movie){
    movieRepository.save(movie);
  }

  /**
   * List all the movies in the database.
   * @return List of Movie objects from the database.
   */
  public List<Movie> getAllMovies(){
    return (List<Movie>) movieRepository.findAll();
  }

  /**
   * Get a specific movie based on the ID.
   * @param id The ID of the movie to be returned.
   * @return A movie object with the specified ID.
   */
  public Optional<Movie> getMovieById(Long id) {
    return movieRepository.findById(id);
  }

  /**
   * Get all movies in a specific year ordered alphabetically by the title.
   * @param year Release year.
   * @return List of Movie objects.
   */
  public List<Movie> getAllMoviesByYear(int year) {
    return movieRepository.findAllByYearOrderByTitleAsc(year);
  }

  /**
   * Delete a movie based on the ID.
   * @param id The ID of the movie to be deleted.
   */
  public void deleteMovie(Long id) {
    movieRepository.deleteById(id);
  }

}
