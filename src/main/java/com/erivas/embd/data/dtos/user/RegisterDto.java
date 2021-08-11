package com.sword.trailersdb.data.dtos.user;

import com.sword.trailersdb.data.models.CommentModel;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class RegisterDto {

    private @NotNull String name;
    private @NotNull String email;
    private @NotNull String password;
    private ArrayList<CommentModel> comments;

    public RegisterDto() {
        this.comments = new ArrayList<CommentModel>();
    }

    // TODO: Finish DTO with auth
}