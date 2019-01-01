package com.accenture.itfactory.movieapp.service;

import com.accenture.itfactory.movieapp.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreService extends CrudRepository<Genre, Long> {
}
