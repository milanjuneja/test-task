package com.task.controller;

import com.task.entity.Movies;
import com.task.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    @Autowired
    private MovieService movieService;

    @GetMapping("api/v1/longest-duration-movies")
    public ResponseEntity<List<Movies>> getTop10LongestDurationMovie(){

        List<Movies> movies = this.movieService.getTop10LongestDurationMovie();
        return ResponseEntity.of(Optional.of(movies));


    }
    @PostMapping("api/v1/new-movie")
    public String saveMovies(@RequestBody Movies movies){
        movies.settConst("tt0000100");
        this.movieService.save(movies);
        return "Success";
    }

    @GetMapping("api/v1/top-rated-movies")
    public ResponseEntity<List<Movies>> getMoviesByRatings(){
        List<Movies> movies = this.movieService.getMoviesByRatings();
        return ResponseEntity.of(Optional.of(movies));
    }

    @GetMapping("api/v1/genre-movies-with-subtotals")
    public ResponseEntity<List<Movies>> getMoviesByGenresType(){
        List<Movies> movies = this.movieService.getMoviesByGenresType();
        return ResponseEntity.of(Optional.of(movies));
    }

    @PostMapping("api/v1/update-runtime-minutes")
    public String incrementRuntime(){

        this.movieService.incrementRuntime();
        return "Success";
    }



}
