package com.erivas.embd.data.dtos.comment;

import com.erivas.embd.data.models.UserModel;

import com.fasterxml.jackson.annotation.JsonAlias;
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