package com.example.spring_tp_vendredi_07072023.Dto;


import com.example.spring_tp_vendredi_07072023.entity.Comment;
import com.example.spring_tp_vendredi_07072023.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDto {

        private Integer id;
        private String title;
        private String body;
        private List<Comment> comments;
        private User user;


}
