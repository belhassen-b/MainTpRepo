package org.example.Stream.course;

import org.example.Stream.teacher.Teacher;



public class Course {

    private int id;
    private String name;
    private Teacher teacher;
    private int duration;

    public Course(int id, String name, Teacher teacher, int duration) {
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Object getStudents() {
        return null;
    }
}
