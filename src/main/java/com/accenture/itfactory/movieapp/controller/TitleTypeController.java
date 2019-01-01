package com.accenture.itfactory.movieapp.controller;

import com.accenture.itfactory.movieapp.model.TitleType;
import com.accenture.itfactory.movieapp.service.TitleTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

public class TitleTypeController {

    @Autowired
    private TitleTypeService titleTypeService;

    @GetMapping("/titletype")
    Iterable<TitleType> findAllGenres(){
        return titleTypeService.findAll();
    }
}
