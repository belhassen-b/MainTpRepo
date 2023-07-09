package com.example.spring_tp_vendredi_07072023.Dto;


import com.example.spring_tp_vendredi_07072023.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LikeMentionDto {

        private Integer id;
        private Date date;
        private Comment comment;
}
