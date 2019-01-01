package com.accenture.itfactory.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name ="movie" )
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Movie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust")
    @SequenceGenerator(name = "cust", sequenceName = "seq_cust")
    @Column(name = "movie_id")
    private Long id;
    private String name;
    private String imbd;
    private LocalDate releaseYear;
    private Double rating;
    private String description;
    private Boolean isAdult;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

//    @JsonIgnore

    private Genre genre;

    @ManyToOne
    private TitleType titleType;

    public Movie() {
    }

    public Movie(String name, String imbd, LocalDate releaseYear, Double rating, String description, Boolean isAdult) {
        this.name = name;
        this.imbd = imbd;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.description = description;
        this.isAdult = isAdult;
    }

    public Movie(String name, String imbd, LocalDate releaseYear, Double rating, String description, Boolean isAdult, List<Review> reviews, Genre genre, TitleType titleType) {
        this.name = name;
        this.imbd = imbd;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.description = description;
        this.isAdult = isAdult;
        this.reviews = reviews;
        this.genre = genre;
        this.titleType = titleType;
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

    public String getImbd() {
        return imbd;
    }

    public void setImbd(String imbd) {
        this.imbd = imbd;
    }


    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDate releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAdult() {
        return isAdult;
    }

    public void setAdult(Boolean adult) {
        isAdult = adult;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public TitleType getTitleType() {
        return titleType;
    }

    public void setTitleType(TitleType titleType) {
        this.titleType = titleType;
    }
}
