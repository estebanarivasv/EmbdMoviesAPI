package com.sword.trailersdb.dtos;

import javax.validation.constraints.NotNull;

// Handles inputs from controller that are mapped into entities of the database
public class UserDto {

    private @NotNull String email;
    private @NotNull String name;
    private @NotNull String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
