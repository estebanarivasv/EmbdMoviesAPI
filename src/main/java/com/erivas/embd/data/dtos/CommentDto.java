package com.erivas.embd.data.dtos;

import com.erivas.embd.data.models.MovieModel;
import com.erivas.embd.data.models.UserModel;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Date;

public class CommentDto {

    @JsonAlias("id")
    public Long id;

    @JsonAlias("text")
    public String text;

    @JsonAlias("rating")
    public Float rating;

    @JsonAlias("date_posted")
    public Date datePosted;

    @JsonAlias("movie")
    public MovieModel movie;

    @JsonAlias("user")
    public UserModel user;

}