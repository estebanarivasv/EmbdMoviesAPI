package com.erivas.embd.data.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Actor")
public class ActorModel {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "actors")
    private List<MovieModel> movies;

    // TODO RELATIONSHIPS, NULLABLE, SIZES, CONSTRUCTOR, GETTERS AND SETTERS, TO_STRING()

    public ActorModel() {
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

    public List<MovieModel> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieModel> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "ActorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }
}