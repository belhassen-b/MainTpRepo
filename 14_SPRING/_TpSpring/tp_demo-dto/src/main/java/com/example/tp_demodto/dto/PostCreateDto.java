package com.example.tp_demodto.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateDto implements PostDto{

    private String content;
    private String description;
    private String title;
    private Date createdAt;



}
