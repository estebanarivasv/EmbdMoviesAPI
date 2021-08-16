package com.erivas.embd.data.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "User")
public class UserModel {
    @Id
    @GeneratedValue
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 250)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    // TODO RELATIONSHIPS
    // private Long[] playlists;
    // private Long[] comments;

    // EMPTY CONSTRUCTOR, GETTERS AND SETTERS, TO_STRING()

}
