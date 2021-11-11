package com.erivas.embd.data.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    public String email;

    public String password;

    public String name;

}