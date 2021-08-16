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

    private String trailerUrl;

    private String coverUrl;

    private GenreEnum[] genre;

    private String duration;

    private String description;

    // Extra info
    private Float[] averageRating; // Long list of all users ratings associated to users' ratings

    private LanguageEnum[] languages;

    private LanguageEnum[] subtitles;

    private Date releaseDate;

    // TODO RELATIONSHIPS
    // private Long[] directors;
    // private Long[] actors;
    // private Long[] comments;

    // EMPTY CONSTRUCTOR, GETTERS AND SETTERS, TO_STRING()

}
