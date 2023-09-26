package com.task.repository;

import com.task.api.model.LongestDurationMovies;
import com.task.api.model.MoviesByRatings;
import com.task.entity.Movies;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MovieRepo extends ListCrudRepository<Movies, String> {

    @Query(
            value = "SELECT a.t_const, a.primary_title,a.run_time_minutes, a.genres FROM movies a ORDER BY a.run_time_minutes DESC LIMIT 10",
            nativeQuery = true
    )
    List<LongestDurationMovies> getTop10LongestDurationMovie();
    @Query(
            value =  "SELECT a.t_const, a.primary_title, a.genres, b.average_rating FROM movies a, ratings b WHERE a.t_const = b.t_const AND b.average_rating > 6.0 ORDER BY b.average_rating DESC;",
            nativeQuery = true
    )
    List<MoviesByRatings> getMoviesByRatings();

    @Query(
            value = "SELECT a.genres, SUM(b.num_votes) FROM movies a, ratings b WHERE a.t_const = b.t_const GROUP BY a.genres",
            nativeQuery = true
    )
    List<Movies> getMoviesByGenresType();

    @Modifying
    @Transactional
    @Query(
            value = "UPDATE movies a SET a.run_time_minutes = CASE WHEN a.genres = 'Documentary' THEN a.run_time_minutes + 15 WHEN a.genres = 'Animation' THEN a.run_time_minutes + 30 WHEN a.genres != 'Documentary' OR a.genres != 'Animation' THEN a.run_time_minutes + 40 END;",
            nativeQuery = true
    )
    void incrementRuntime();
}
