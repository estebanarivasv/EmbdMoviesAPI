package com.erivas.embd.data.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;

public class UserDto {

    @JsonAlias("id")
    public Integer id;

    @JsonAlias("email")
    public String email;

    @JsonAlias("password")
    public String password;

    @JsonAlias("name")
    public String name;

}