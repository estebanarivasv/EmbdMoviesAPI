package com.erivas.embd.data.models;

import com.erivas.embd.data.types.GenreEnum;
import com.erivas.embd.data.types.LanguageEnum;
import org.hibernate.mapping.Collection;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "Movie")
public class MovieModel implements Serializable {

    public MovieModel() {
    }

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String title;

    private String trailerUrl;

    private String coverUrl;

    @ElementCollection(targetClass=GenreEnum.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="movie_genre")
    @Column(name="genre")
    private Set<GenreEnum> genres;

    private String duration;

    private String description;

    @ElementCollection(targetClass=LanguageEnum.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="movie_language")
    @Column(name="language")
    private Set<LanguageEnum> languages;

    @ElementCollection(targetClass=LanguageEnum.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="movie_subtitle")
    @Column(name="subtitle")
    private Set<LanguageEnum> subtitles;

    private Date releaseDate;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentModel> comments;

    @ManyToMany(mappedBy="movies")
    private List<DirectorModel> directors;

    @ManyToMany(mappedBy="movies")
    private List<ActorModel> actors;

    @ManyToMany(mappedBy="movies")
    private List<PlaylistModel> playlists;

    // TODO RELATIONSHIPS, NULLABLE, SIZES, CONSTRUCTOR, GETTERS AND SETTERS, TO_STRING()


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

    public List<PlaylistModel> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistModel> playlists) {
        this.playlists = playlists;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MovieModel)) return false;
        MovieModel that = (MovieModel) o;
        return Objects.equals(id, that.id) && Objects.equals(getTitle(), that.getTitle()) && Objects.equals(getTrailerUrl(), that.getTrailerUrl()) && Objects.equals(getCoverUrl(), that.getCoverUrl()) && Objects.equals(getGenres(), that.getGenres()) && Objects.equals(getDuration(), that.getDuration()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getLanguages(), that.getLanguages()) && Objects.equals(getSubtitles(), that.getSubtitles()) && Objects.equals(getReleaseDate(), that.getReleaseDate()) && Objects.equals(getComments(), that.getComments()) && Objects.equals(getDirectors(), that.getDirectors()) && Objects.equals(getActors(), that.getActors()) && Objects.equals(getPlaylists(), that.getPlaylists());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getTitle(), getTrailerUrl(), getCoverUrl(), getGenres(), getDuration(), getDescription(), getLanguages(), getSubtitles(), getReleaseDate(), getComments(), getDirectors(), getActors(), getPlaylists());
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
                ", directors=" + directors +
                ", actors=" + actors +
                '}';
    }
}
