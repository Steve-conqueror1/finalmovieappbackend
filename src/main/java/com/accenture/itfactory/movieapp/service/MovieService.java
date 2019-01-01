package com.accenture.itfactory.movieapp.service;

import com.accenture.itfactory.movieapp.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieService extends CrudRepository<Movie, Long> {

    @Query(value = "(SELECT * FROM movie m WHERE (m.release_year BETWEEN ?1 AND  ?2)) INTERSECT (SELECT * FROM movie m WHERE (m.movie_rating BETWEEN ?3 and ?4) AND (m.is_adult = ?5))", nativeQuery = true)
    Iterable<Movie> findAll(Long fromYear, Long toYear, Double fromRating, Double toRating, Boolean isAdult);
}
