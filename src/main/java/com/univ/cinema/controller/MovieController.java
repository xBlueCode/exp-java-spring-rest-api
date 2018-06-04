package com.univ.cinema.controller;

import com.univ.cinema.model.Movie;
import com.univ.cinema.service.MovieService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cinema/movies")
public class MovieController {

  // Service which will do all data retrieval/manipulation work
  private MovieService movieService ;

  @Autowired
  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }

  /**
   * Retrieve all movies.
   * @return List of movies in json format.
   */
  @RequestMapping(value = "", method = RequestMethod.GET)
  @ResponseBody
  public List<Movie> getAllMovies(){
    return movieService.getAllMovies();
  }

  /**
   * Retrieve all movies in a specific year ordered alphabetically by the title.
   * @param year release year.
   * @return List of movies in json format.
   */
  @RequestMapping(value = "/year/{year}", method = RequestMethod.GET)
  @ResponseBody
  public List<Movie> getAllMoviesByYear(@PathVariable int year){
    return movieService.getAllMoviesByYear(year);
  }

  /**
   * Create the Movie object and store it in the database.
   * @param movie Movie object created by the GET request.
   */
  @RequestMapping(value = "", method = RequestMethod.POST)
  public void createMovie(@RequestBody Movie movie){
    movieService.addMovie(movie);
  }

  /**
   * Get the Movie object based on the ID.
   * @param movieId The ID of the desired Movie.
   * @return A Movie Object converted to json format.
   */
  @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
  @ResponseBody // to let spring serialise and convert the return type to HTTP request body
  public Optional<Movie> getMovieById(@PathVariable(value = "id") Long movieId){
    return movieService.getMovieById(movieId);
  }

  /**
   * Update a specific Movie in the database.
   * @param id The ID of the Movie to be updated.
   * @param movie The Movie Object created from the GET request
   */
  @RequestMapping(value = "/id/{id}", method = RequestMethod.PUT)
  public void updateMovie(@PathVariable Long id, @RequestBody Movie movie){
    // Add the ID from the path to the object created by the RequestBody
    movie.setId(id);
    movieService.updateMovie(movie);
  }

  /**
   * Delete a Movie based on the ID.
   * @param id The ID of the movie to be deleted.
   */
  @RequestMapping(value = "/id/{id}", method = RequestMethod.DELETE)
  public void deleteMovie(@PathVariable Long id){
    movieService.deleteMovie(id);
  }

}
