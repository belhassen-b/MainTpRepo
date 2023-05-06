package org.example.personne;

public class Teacher  extends Person{


    private String subject;
    public void Explain(){
        System.out.println("Explanation begins about " + subject);
    }

    public Teacher(String name, String surname, int age, String subject) {
        super(name);
        this.subject = subject;
    }
}
