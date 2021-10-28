package com.erivas.embd.data.dtos;

import com.erivas.embd.data.models.MovieModel;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public class DirectorDto {

    @JsonAlias("id")
    public Long id;

    @JsonAlias("name")
    public String name;

    @JsonAlias("movies")
    public List<MovieModel> movies;

}