package com.sword.trailersdb.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Comment {

    private @Id @GeneratedValue Long id;

    @Column(nullable = false, length = 250)
    private String text;

    @Column(nullable = false)
    private Long rating;

    @Column(nullable = false)
    private Date datePosted;

    @ManyToOne // set relationship with model
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    // @OneToOne
    // @JoinColumn(name="movie_id", nullable = false)
    // private Movie movie;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public Date getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(Date datePosted) {
        this.datePosted = datePosted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}