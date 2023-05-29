package com.task.repository;

import com.task.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MovieRepo extends JpaRepository<Movies, String> {

    @Query(
            value = "SELECT a.* FROM movies a order by a.run_time_minutes desc limit 10",
            nativeQuery = true
    )
    List<Movies> getTop10LongestDurationMovie();
    @Query(
            value =  "SELECT a.* FROM movies a, ratings b WHERE a.t_const = b.t_const AND b.average_rating > 6.0",
            nativeQuery = true
    )
    List<Movies> getMoviesByRatings();

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
