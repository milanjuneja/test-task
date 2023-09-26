package com.task.service;
import com.task.api.model.LongestDurationMovies;
import com.task.api.model.MoviesByRatings;
import com.task.entity.Movies;
import com.task.repository.MovieRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepo movieRepo;

    @Override
    public List<LongestDurationMovies> getTop10LongestDurationMovie() {
        return this.movieRepo.getTop10LongestDurationMovie();
    }

    @Override
    public void save(Movies movies) {
        this.movieRepo.save(movies);
    }

    @Override
    public List<MoviesByRatings> getMoviesByRatings() {
        return this.movieRepo.getMoviesByRatings();
    }

    @Override
    public List<Movies> getMoviesByGenresType() {
        return this.movieRepo.getMoviesByGenresType();
    }

    @Override
    public void incrementRuntime() {
        this.movieRepo.incrementRuntime();
    }
}
