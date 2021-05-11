package com.sword.trailersdb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Actor {
    private @Id @GeneratedValue Long id;
    private String name;
    //private ArrayList<Movie> movies;

    // Constructor
    Actor() {}

    Actor(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }


}