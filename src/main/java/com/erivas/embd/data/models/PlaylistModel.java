package com.erivas.embd.data.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Playlist")
public class PlaylistModel {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserModel user;

    @OneToMany(cascade = CascadeType.ALL)   // set relationship with model
    @JoinColumn(name = "movies")
    private List<MovieModel> movies;

    // TODO RELATIONSHIPS, NULLABLE, SIZES, CONSTRUCTOR, GETTERS AND SETTERS, TO_STRING()

}
