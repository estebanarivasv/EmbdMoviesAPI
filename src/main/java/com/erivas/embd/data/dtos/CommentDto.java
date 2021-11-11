package com.erivas.embd.data.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class CommentDto {

    public String text;

    public Float rating;

    @JsonAlias("movie_id")
    public Long movieId;

    @JsonAlias("user_id")
    public Long userId;

}