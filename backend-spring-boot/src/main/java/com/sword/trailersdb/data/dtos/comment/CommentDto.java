package com.sword.trailersdb.data.dtos.comment;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.sword.trailersdb.data.models.UserModel;

import java.util.Date;

public class CommentDto {

    private Long id;
    @JsonAlias("date_posted")
    private Date datePosted;
    private String text;
    private Long rating;
    private UserModel user;
    // private Movie movie;      TODO: Finish movie integration.

}