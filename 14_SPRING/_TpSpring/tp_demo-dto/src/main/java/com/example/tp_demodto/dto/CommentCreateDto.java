package com.example.tp_demodto.dto;


import com.example.tp_demodto.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentCreateDto implements CommentDto {

    private String body;
    private String email;
    private String name;
    private Post post;
    private Date createdAt;

}
