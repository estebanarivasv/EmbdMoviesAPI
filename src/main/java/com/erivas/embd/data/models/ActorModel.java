package com.erivas.embd.data.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity(name = "Actor")
public class ActorModel {

    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    private String name;

    private List<MovieModel> movies;

}