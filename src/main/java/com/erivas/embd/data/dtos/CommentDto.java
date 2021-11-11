package com.erivas.embd.data.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    public String text;

    public Float rating;

    @JsonIgnore
    public Long movieId;

    @JsonAlias("user_id")
    public Long userId;

}