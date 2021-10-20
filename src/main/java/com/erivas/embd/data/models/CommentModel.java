package com.erivas.embd.data.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Comment")
public class CommentModel implements Serializable {

    public CommentModel() {
    }

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 250)
    private String text;

    @Column(nullable = false)
    private Float rating;

    @CreationTimestamp
    @Column(nullable = false)
    private Date datePosted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieModel movie;

    @ManyToOne(fetch = FetchType.LAZY) // set relationship with model
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public MovieModel getMovie() {
        return movie;
    }

    public void setMovie(MovieModel movie) {
        this.movie = movie;
    }

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommentModel)) return false;
        CommentModel that = (CommentModel) o;
        return Objects.equals(id, that.id) && Objects.equals(getText(), that.getText()) && Objects.equals(getRating(), that.getRating()) && Objects.equals(getDatePosted(), that.getDatePosted()) && Objects.equals(getMovie(), that.getMovie()) && Objects.equals(getUser(), that.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getText(), getRating(), getDatePosted(), getMovie(), getUser());
    }

    @Override
    public String toString() {
        return "CommentModel{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", rating=" + rating +
                ", datePosted=" + datePosted +
                ", movie=" + movie +
                ", user=" + user +
                '}';
    }

}