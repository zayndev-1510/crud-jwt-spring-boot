package com.restapijwt.crudjwt.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class BlogRequest {
    private Integer user;

    @NotBlank(message = "title can't blank")
    private String title;

    @NotBlank(message = "content can't blank")
    private String content;

    @NotBlank(message = "tags can't blank")
    private String tags;

    @NotBlank(message = "category can't blank")
    private String category;

    @NotBlank(message = "author can't blank")
    private String author;
    private String foto;
    private Integer views;
    private Integer likes;
    private Integer comments;
    private Integer favorites;
}
