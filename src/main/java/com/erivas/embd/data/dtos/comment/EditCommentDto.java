package com.sword.trailersdb.data.dtos.comment;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class EditCommentDto {

    @Size(min = 8, max = 255)           private String text;
    @Min(value = 1) @Max(value = 5)     private Long rating;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }
}
