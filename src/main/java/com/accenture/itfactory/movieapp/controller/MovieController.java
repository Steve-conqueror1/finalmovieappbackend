package com.accenture.itfactory.movieapp.controller;

import com.accenture.itfactory.movieapp.model.Movie;
import com.accenture.itfactory.movieapp.model.Review;
import com.accenture.itfactory.movieapp.service.MovieService;
import com.accenture.itfactory.movieapp.service.ReviewService;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.ObjPtr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;


    @Autowired
    private ReviewService reviewService;

    @PostMapping("/movies/view")
    Iterable<Movie> findByYear(
            @RequestParam(value = "fromYear") Long fromYear,
            @RequestParam(value = "toYear") Long toYear,
            @RequestParam(value = "fromRating") Long fromRating,
            @RequestParam(value = "toRating") Long toRating,
            @RequestParam(value = "isAdult") Long isAdult){

        return movieService.findAll();
    }

    @GetMapping("/movies")
    @CrossOrigin(origins = "http://localhost:3000")
    Iterable<Movie> read(){
        return movieService.findAll();
    }

    @GetMapping("/movie/{id}")
    Optional<Movie> findById(@PathVariable Long id)
    {
        return movieService.findById(id);
    }

    @PostMapping("/movie/{id}/review")
    void createReview(@PathVariable Long id, @RequestBody Review review){
       movieService.findById(id).get().getReviews().add(review);
    }


}
