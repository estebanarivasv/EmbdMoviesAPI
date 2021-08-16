package com.erivas.embd.data.models;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Comment")
public class CommentModel {
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

    // Todo: Finish relationship when Movie model is finished
    // @OneToOne
    // @JoinColumn(name="movie_id", nullable = false)
    // private Movie movie;

    // @ManyToOne(fetch = FetchType.LAZY) // set relationship with model
    // @JoinColumn(name="user_id", nullable = false)
    // private UserModel user;

    // EMPTY CONSTRUCTOR, GETTERS AND SETTERS, TO_STRING()

}