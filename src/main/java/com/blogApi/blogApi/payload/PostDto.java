package com.blogApi.blogApi.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Long id;
    @NonNull
    @NotEmpty
    @Size(min = 3, message = "Post title should have atleast 2 character")
    private String title;
    @NonNull
    @NotEmpty
    @Size(min = 10, message = "Post Description should have at least 10 character or more")
    private String description;
    @NonNull
    @NotEmpty
    private String content;

}
