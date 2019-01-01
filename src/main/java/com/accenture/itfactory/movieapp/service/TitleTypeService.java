package com.accenture.itfactory.movieapp.service;

import com.accenture.itfactory.movieapp.model.TitleType;
import org.springframework.data.repository.CrudRepository;

public interface TitleTypeService extends CrudRepository<TitleType, Long> {
}
