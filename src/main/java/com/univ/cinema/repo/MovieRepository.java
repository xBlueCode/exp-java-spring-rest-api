package com.univ.cinema.repo;

import com.univ.cinema.model.Movie;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// by extending the CrudRepository, spring will automatically generate a DAO class with implmentations
// the main methods (create, read, update and delete) with the additional methods defined in this
// interface by the smart signature naming
@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

  /**
   *
   * @param year year of release
   * @return List of movies released in the specified year ordered alphabetically by the title
   */
  List<Movie> findAllByYearOrderByTitleAsc(int year);

  /**
   * Delete a specific movie based on the ID
   * @param id The ID of the movie to be deleted from the DataBase
   */
  void deleteById(Long id);
}
