package com.erivas.embd.data.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Playlist")
public class PlaylistModel implements Serializable {

    public PlaylistModel() {
    }

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private UserModel user;

    @ManyToMany
    @JoinTable(name = "Playlist_Movie",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<MovieModel> movies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
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
        if (!(o instanceof PlaylistModel)) return false;
        PlaylistModel that = (PlaylistModel) o;
        return Objects.equals(id, that.id) && Objects.equals(getUser(), that.getUser()) && Objects.equals(getMovies(), that.getMovies());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getUser(), getMovies());
    }

    @Override
    public String toString() {
        return "PlaylistModel{" +
                "id=" + id +
                ", user=" + user +
                ", movies=" + movies +
                '}';
    }

}
