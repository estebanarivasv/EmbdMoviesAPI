package com.erivas.embd.data.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Actor")
public class ActorModel implements Serializable {

    public ActorModel() {
    }

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "Actor_Movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<MovieModel> movies;


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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActorModel)) return false;
        ActorModel that = (ActorModel) o;
        return Objects.equals(id, that.id) && Objects.equals(getName(), that.getName()) && Objects.equals(getMovies(), that.getMovies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getMovies());
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