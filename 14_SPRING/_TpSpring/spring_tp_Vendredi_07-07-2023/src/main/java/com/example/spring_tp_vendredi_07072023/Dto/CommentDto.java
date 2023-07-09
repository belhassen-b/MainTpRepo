package com.example.spring_tp_vendredi_07072023.Dto;


import com.example.spring_tp_vendredi_07072023.entity.DislikeMention;
import com.example.spring_tp_vendredi_07072023.entity.LikeMention;
import com.example.spring_tp_vendredi_07072023.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CommentDto {

        private Integer id;
        private String message;
        private List<LikeMention> likeMentions;
        private List<DislikeMention> dislikeMentions;
        private Post post;
}
