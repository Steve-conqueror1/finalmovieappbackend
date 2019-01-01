package com.accenture.itfactory.movieapp.controller;

import com.accenture.itfactory.movieapp.model.Genre;
import com.accenture.itfactory.movieapp.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping("/genre")
    Iterable<Genre> findAllGenres(){
        return genreService.findAll();
    }
}
