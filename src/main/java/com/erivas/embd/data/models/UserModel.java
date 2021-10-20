package com.erivas.embd.data.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "User")
public class UserModel implements Serializable {

    public UserModel() {
    }

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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PlaylistModel> playlists;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<CommentModel> comments;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserModel)) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(getEmail(), userModel.getEmail()) && Objects.equals(getName(), userModel.getName()) && Objects.equals(getPlaylists(), userModel.getPlaylists()) && Objects.equals(getComments(), userModel.getComments());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getEmail(), getName(), getPlaylists(), getComments());
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", playlists=" + playlists +
                ", comments=" + comments +
                '}';
    }
}
