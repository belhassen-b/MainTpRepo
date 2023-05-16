package org.example.model;

import javax.persistence.*;
import java.util.Date;


@Entity
    @Table(name = "todo")
    public class Todo {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "todo_id")
        private Long id;
        private String title;
        private boolean achieved;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "todo_info_id", referencedColumnName = "id")
        private TodoInfo todoInfo;


        public Todo() {
        }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAchieved() {
        return achieved;
    }

    public void setAchieved(boolean achieved) {
        this.achieved = achieved;
    }

    public TodoInfo getTodoInfo() {
        return todoInfo;
    }

    public void setTodoInfo(TodoInfo todoInfo) {
        this.todoInfo = todoInfo;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", achieved=" + achieved +
                ", todoInfo=" + todoInfo +
                '}';
    }
}

