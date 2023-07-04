package com.example.demo_rest.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table (name = "list_todo_item")
public class ListTodoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;


    @ Column(name = "date", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    @Column(name = "is_complete", nullable = false)
    boolean isComplete;

    @OneToMany(mappedBy = "listTodoItem")
    List<TodoItem> todoItems = new ArrayList<>();


    }

