package com.erivas.embd.data.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Director")
public class DirectorModel implements Serializable {

    public DirectorModel() {
    }

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name="Director_Movie",
            joinColumns={@JoinColumn(name="director_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="movie_id", referencedColumnName="id")})
    private List<MovieModel> movies;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DirectorModel)) return false;
        DirectorModel that = (DirectorModel) o;
        return Objects.equals(id, that.id) && Objects.equals(getName(), that.getName()) && Objects.equals(getMovies(), that.getMovies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getName(), getMovies());
    }

    @Override
    public String toString() {
        return "DirectorModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", movies=" + movies +
                '}';
    }

}