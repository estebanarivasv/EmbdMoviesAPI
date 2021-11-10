package com.erivas.embd.data.dtos;

import com.erivas.embd.data.models.MovieModel;
import com.erivas.embd.data.models.UserModel;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class PlaylistDto {

    @JsonAlias("id")
    public Long id;

    @JsonAlias("user")
    public UserModel user;

    @JsonAlias("movies")
    public List<MovieDto> movies;

}