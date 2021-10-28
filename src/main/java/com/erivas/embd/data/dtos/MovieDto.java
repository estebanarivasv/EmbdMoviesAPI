package com.erivas.embd.data.dtos;

import com.erivas.embd.data.models.ActorModel;
import com.erivas.embd.data.models.CommentModel;
import com.erivas.embd.data.models.DirectorModel;
import com.erivas.embd.data.models.PlaylistModel;
import com.erivas.embd.data.types.GenreEnum;
import com.erivas.embd.data.types.LanguageEnum;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class MovieDto {

    @JsonAlias("id")
    public Long id;

    @JsonAlias("title")
    public String title;

    @JsonAlias("trailer_url")
    public String trailerUrl;

    @JsonAlias("cover_url")
    public String coverUrl;

    @JsonAlias("genre")
    public Set<GenreEnum> genres;

    @JsonAlias("duration")
    public String duration;

    @JsonAlias("description")
    public String description;

    @JsonAlias("languages")
    public Set<LanguageEnum> languages;

    @JsonAlias("subtitles")
    public Set<LanguageEnum> subtitles;

    @JsonAlias("release_date")
    public Date releaseDate;

    @JsonAlias("comments")
    public List<CommentModel> comments;

    @JsonAlias("directors")
    public List<DirectorModel> directors;

    @JsonAlias("actors")
    public List<ActorModel> actors;

    @JsonAlias("playlists")
    public List<PlaylistModel> playlists;

}