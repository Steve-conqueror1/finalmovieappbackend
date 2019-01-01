package com.accenture.itfactory.movieapp.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TitleType")
public class TitleType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cust")
    @SequenceGenerator(name = "cust", sequenceName = "seq_cust")
    private Long id;
    private String name;
    private String Description;

    @OneToMany(mappedBy = "titleType")
    private List<Movie> movie;

    public TitleType() {
    }

    public TitleType(String name, String description) {
        this.name = name;
        Description = description;
    }

    public TitleType(String name, String description, List<Movie> movie) {
        this.name = name;
        Description = description;
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
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
