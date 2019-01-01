package com.accenture.itfactory.movieapp.service;

import com.accenture.itfactory.movieapp.model.Review;
import org.springframework.data.repository.CrudRepository;

public interface ReviewService extends CrudRepository<Review, Long> {
}
