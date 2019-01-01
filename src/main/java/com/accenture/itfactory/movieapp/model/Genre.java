package com.accenture.itfactory.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="genre")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Genre implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust")
  @SequenceGenerator(name = "cust", sequenceName = "seq_cust")
  @Column(name = "genre_id")
  private Long id;

  private String name;
  private String description;

  @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  private List<Movie> movie = new ArrayList<>();

  public Genre() {
  }

  public Genre(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Genre(String name, String description, List<Movie> movie) {
    this.name = name;
    this.description = description;
    this.movie = movie;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Movie> getMovie() {
    return movie;
  }

  public void setMovie(List<Movie> movie) {
    this.movie = movie;
  }
}
