package org.example.entity;

import lombok.*;

@Builder
@ToString
@AllArgsConstructor
@Setter
@Getter
public class Comment {
    private int idComment;
    private String content;
    private int idRecipe;
}
