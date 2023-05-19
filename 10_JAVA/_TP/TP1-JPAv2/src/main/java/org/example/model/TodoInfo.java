package org.example.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "todo_info")
public class TodoInfo {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column (name = "id")
    private Long id;
    private String description;
    private LocalDate targetDate;
    private String priority;


    public TodoInfo() {
    }

    public TodoInfo(Long id, String description, LocalDate targetDate, String priority) {
        this.id = id;
        this.description = description;
        this.targetDate = targetDate;
        this.priority = priority;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }


    @Override
    public String toString() {
        return "TodoInfo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", targetDate='" + targetDate + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
