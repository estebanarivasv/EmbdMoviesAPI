package com.erivas.embd.data.models;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Playlist")
public class PlaylistModel {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    // TODO FINISH RELATIONSHIP
    //@OneToMany(fetch = FetchType.LAZY) // set relationship with model
    //@JoinColumn(name="movies_id")
    //private List<MovieModel> movies;
}
