package com.erivas.embd.data.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
public class UserModel {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 250)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // set relationship with model
    private List<PlaylistModel> playlists = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL) // set relationship with model
    private List<CommentModel> comments = new ArrayList<>();

    // TODO RELATIONSHIPS, NULLABLE, SIZES, CONSTRUCTOR, GETTERS AND SETTERS, TO_STRING()

    public UserModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PlaylistModel> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistModel> playlists) {
        this.playlists = playlists;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", playlists=" + playlists +
                ", comments=" + comments +
                '}';
    }

}
