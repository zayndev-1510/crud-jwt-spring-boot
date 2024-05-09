package com.restapijwt.crudjwt.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogResponse {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String author;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String category;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer views;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer commentars;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer likes;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer favorites;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UserResponse user;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime created;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime updated;

}
