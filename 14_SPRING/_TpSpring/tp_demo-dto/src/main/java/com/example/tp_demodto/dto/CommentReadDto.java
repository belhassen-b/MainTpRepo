package com.example.tp_demodto.dto;


import com.example.tp_demodto.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentReadDto implements CommentDto {
    private Integer id;
    private String body;
    private String email;
    private String name;
    private Post post;

}
