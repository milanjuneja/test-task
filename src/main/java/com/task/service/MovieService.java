package com.task.service;
import com.task.entity.Movies;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MovieService {

    List<Movies> getTop10LongestDurationMovie();

    void save(Movies movies);

    List<Movies> getMoviesByRatings();

    List<Movies> getMoviesByGenresType();

    void incrementRuntime();
}
