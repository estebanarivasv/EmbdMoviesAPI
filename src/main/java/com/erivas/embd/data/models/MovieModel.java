package com.sword.trailersdb.data.models;

import java.util.ArrayList;
import java.util.Date;

public class MovieModel {

    int id;
    String title;
    String trailer;
    String image;
    // Language language;
    // Language subtitle;
    String duration;
    String description;
    Date releaseDate;
    boolean sfa;
    // Genre genre;
    ArrayList<DirectorModel> directors;
    ArrayList<ActorModel> actors;
    float rating;
    int displays;
    // ArrayList<Comment> comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public boolean isSfa() {
        return sfa;
    }

    public void setSfa(boolean sfa) {
        this.sfa = sfa;
    }

    public ArrayList<DirectorModel> getDirectors() {
        return directors;
    }

    public void setDirectors(ArrayList<DirectorModel> directors) {
        this.directors = directors;
    }

    public ArrayList<ActorModel> getActors() {
        return actors;
    }

    public void setActors(ArrayList<ActorModel> actors) {
        this.actors = actors;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getDisplays() {
        return displays;
    }

    public void setDisplays(int displays) {
        this.displays = displays;
    }
}
