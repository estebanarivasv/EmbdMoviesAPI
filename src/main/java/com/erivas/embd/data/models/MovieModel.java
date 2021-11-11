package com.erivas.embd.data.models;

import com.erivas.embd.data.types.GenreEnum;
import com.erivas.embd.data.types.LanguageEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.Collection;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Movie")
public class MovieModel implements Serializable {

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

    @Size(max = 250)
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

    @JsonIgnore
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CommentModel> comments;

    @ManyToMany(mappedBy="movies")
    private List<DirectorModel> directors;

    @ManyToMany(mappedBy="movies")
    private List<ActorModel> actors;

    @JsonIgnore
    @ManyToMany(mappedBy="movies")
    private List<PlaylistModel> playlists;

}
