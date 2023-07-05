package com.example.tp_demodto.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostReadDto implements PostDto{
    private Integer id;
    private String content;
    private String description;
    private String title;

}
