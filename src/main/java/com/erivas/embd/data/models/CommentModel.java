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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false)
    private MovieModel movie;

    @ManyToOne(fetch = FetchType.LAZY) // set relationship with model
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;

    // TODO RELATIONSHIPS, NULLABLE, SIZES, CONSTRUCTOR, GETTERS AND SETTERS, TO_STRING()


}