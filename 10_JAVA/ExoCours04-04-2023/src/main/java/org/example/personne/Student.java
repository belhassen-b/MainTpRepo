package org.example.personne;

public class Student  extends Person{


    public Student(String name, String surname, int age) {
        super(name, surname, age);
    }

    public void GoToClasses(){
        System.out.println("I'm going to classes");
    }

    public void DisplayAge(){
        System.out.println("My age is " + getAge() + " years old");
    }

}
