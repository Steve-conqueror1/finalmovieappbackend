package com.accenture.itfactory.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "Review")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust")
    @SequenceGenerator(name = "cust", sequenceName = "seq_cust")
    @Column(name = "review_id")
    private Long id;

    private LocalDate reviewDate;
    private String reviewAuthor;
    private String reviewText;
    private double userRationg;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Movie movie;

    public Review() {
    }

    public Review(LocalDate reviewDate, String reviewAuthor, String reviewText, double userRationg) {
        this.reviewDate = reviewDate;
        this.reviewAuthor = reviewAuthor;
        this.reviewText = reviewText;
        this.userRationg = userRationg;
    }

    public Review(LocalDate reviewDate, String reviewAuthor, String reviewText, double userRationg, Movie movie) {
        this.reviewDate = reviewDate;
        this.reviewAuthor = reviewAuthor;
        this.reviewText = reviewText;
        this.userRationg = userRationg;
        this.movie = movie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public String getReviewAuthor() {
        return reviewAuthor;
    }

    public void setReviewAuthor(String reviewAuthor) {
        this.reviewAuthor = reviewAuthor;
    }

    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }

    public double getUserRationg() {
        return userRationg;
    }

    public void setUserRationg(double userRationg) {
        this.userRationg = userRationg;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
