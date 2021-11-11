package com.erivas.embd.data.dtos;

import com.erivas.embd.data.models.UserModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PlaylistDto {

    public Long userId;

    public String name;

}