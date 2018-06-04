package com.univ.cinema.utils;

import com.fasterxml.jackson.core.JsonParser.Feature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.univ.cinema.model.Movie;
import com.univ.cinema.service.MovieService;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// ApplicationRunner interface get called just before run() once SpringApplication completes.
@Component
public class FakeDataLoader implements ApplicationRunner {

  // Service which will do all data retrieval/manipulation work
  private MovieService movieService;

  // Define a file name of the json file with some data
  private String FAKE_DATA_FILENAME = "./src/main/resources/fake-data/movies.json";

  @Autowired
  public FakeDataLoader(MovieService movieService) {
    this.movieService = movieService;
  }

  // run() method will ib be invoked just before the application startup completes
  // it is used to pre-populate the database by some fake data from a file on start-up
  @Override
  public void run(ApplicationArguments args) throws Exception {

    // Map json data from a file to a list/array of Java objects(List<Movie> or. Movie[]) using jackson ObjectMapper
    // Create a json mapper of type ObjectMapper provided by jackson
    ObjectMapper mapper = new ObjectMapper();
    // Allow parsing json files with included comments
    mapper.configure(Feature.ALLOW_COMMENTS, true);
    // Read and parse json properties and save them in a array of Java objects
    Movie[] movies= mapper.readValue(new File(FAKE_DATA_FILENAME), Movie[].class);

    // Iterate of the array of Movie objects and save them in the database using movieService.
    for (int i = 0; i < movies.length ; i++) {
      movieService.addMovie(movies[i]);
    }
  }
}