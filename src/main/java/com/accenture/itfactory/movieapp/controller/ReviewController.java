package com.accenture.itfactory.movieapp.controller;

import com.accenture.itfactory.movieapp.model.Review;
import com.accenture.itfactory.movieapp.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/review/view")
    @CrossOrigin(origins = "http://localhost:3000")
    Iterable<Review> read(){
        return reviewService.findAll();
    }

    @DeleteMapping("/review/{id}")
    void delete(@PathVariable Long id){
        reviewService.deleteById(id);
    }

    @PutMapping("/review")
    Review update(@RequestBody Review review){
        return reviewService.save(review);
    }

}
