package com.erivas.embd.data.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Playlist")
public class PlaylistModel {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private Long userId;

    // TODO RELATIONSHIPS
    // @OneToMany(fetch = FetchType.LAZY) // set relationship with model
    // @JoinColumn(name="id")
    // private Integer[] movies;

    // EMPTY CONSTRUCTOR, GETTERS AND SETTERS, TO_STRING()

}
