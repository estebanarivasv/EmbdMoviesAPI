package com.erivas.embd.data.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Actor")
public class ActorModel implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "Actor_Movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<MovieModel> movies;

}