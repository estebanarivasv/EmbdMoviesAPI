package com.erivas.embd.data.models;

import com.erivas.embd.data.types.GenreEnum;
import com.erivas.embd.data.types.LanguageEnum;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class MovieModel {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String title;

    private String trailer;

    private String cover;
    private List<LanguageEnum> language;
    private List<LanguageEnum> subtitles;

    private String duration;
    private String description;
    private Date releaseDate;

    private GenreEnum genre;
    private List<DirectorModel> directors;
    private List<ActorModel> actors;

    // Long list of all users ratings associated to users' ratings
    private List<Long> rating;
    private List<CommentModel> comments;

}
