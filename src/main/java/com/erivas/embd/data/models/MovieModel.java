package com.erivas.embd.data.models;

import com.erivas.embd.data.types.GenreEnum;
import com.erivas.embd.data.types.LanguageEnum;
import org.hibernate.mapping.Collection;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity(name = "Movie")
public class MovieModel {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String title;

    private String trailerUrl;

    private String coverUrl;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "movie_genres", joinColumns = @JoinColumn(name = "genres"))
    @Enumerated(EnumType.STRING)
    private Set<GenreEnum> genres;

    private String duration;

    private String description;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "movie_languages", joinColumns = @JoinColumn(name = "languages"))
    @Enumerated(EnumType.STRING)
    private Set<LanguageEnum> languages;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "movie_subtitles", joinColumns = @JoinColumn(name = "subtitles"))
    @Enumerated(EnumType.STRING)
    private Set<LanguageEnum> subtitles;

    private Date releaseDate;

    @OneToMany(mappedBy = "movieId", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentModel> comments;

    @ManyToMany
    @JoinTable(name = "director_movie", // Junction table name
            joinColumns = @JoinColumn(name = "director_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<DirectorModel> directors;

    @ManyToMany
    @JoinTable(name = "actor_movie", // Junction table name
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "movie_id"))
    private List<ActorModel> actors;

    // TODO RELATIONSHIPS, NULLABLE, SIZES, CONSTRUCTOR, GETTERS AND SETTERS, TO_STRING()


    public MovieModel() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public Set<GenreEnum> getGenres() {
        return genres;
    }

    public void setGenres(Set<GenreEnum> genres) {
        this.genres = genres;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<LanguageEnum> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<LanguageEnum> languages) {
        this.languages = languages;
    }

    public Set<LanguageEnum> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(Set<LanguageEnum> subtitles) {
        this.subtitles = subtitles;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<CommentModel> getComments() {
        return comments;
    }

    public void setComments(List<CommentModel> comments) {
        this.comments = comments;
    }

    public List<DirectorModel> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorModel> directors) {
        this.directors = directors;
    }

    public List<ActorModel> getActors() {
        return actors;
    }

    public void setActors(List<ActorModel> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "MovieModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", trailerUrl='" + trailerUrl + '\'' +
                ", coverUrl='" + coverUrl + '\'' +
                ", genres=" + genres +
                ", duration='" + duration + '\'' +
                ", description='" + description + '\'' +
                ", languages=" + languages +
                ", subtitles=" + subtitles +
                ", releaseDate=" + releaseDate +
                ", comments=" + comments +
                ", directors=" + directors +
                ", actors=" + actors +
                '}';
    }
}
