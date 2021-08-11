package com.sword.trailersdb.data.dtos.user;

import javax.validation.constraints.Size;

public class InputUserDto {

    @Size(min = 8, max = 40)
    private String email;
    @Size(min = 4, max = 30)
    private String name;
    @Size(min = 8, max = 30)
    private String password;

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