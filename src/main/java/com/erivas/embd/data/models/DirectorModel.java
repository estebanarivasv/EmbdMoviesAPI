package com.erivas.embd.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Director")
public class DirectorModel implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="Director_Movie",
            joinColumns={@JoinColumn(name="director_id", referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="movie_id", referencedColumnName="id")})
    private List<MovieModel> movies;

}