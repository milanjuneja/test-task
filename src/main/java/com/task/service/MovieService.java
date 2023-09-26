package com.task.service;
import com.task.api.model.LongestDurationMovies;
import com.task.api.model.MoviesByRatings;
import com.task.entity.Movies;

import java.util.List;


public interface MovieService {

    List<LongestDurationMovies> getTop10LongestDurationMovie();

    void save(Movies movies);

    List<MoviesByRatings> getMoviesByRatings();

    List<Movies> getMoviesByGenresType();

    void incrementRuntime();
}
