package org.example.employe;

public class Technicien extends Employe{

    private int grade;

    public Technicien() {
    }

    public Technicien(String nom, int age, double salaire, int grade) {
        super(nom, age, salaire);
        this.grade = grade;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void prime() {
        if (grade == 1) {
            setSalaire(getSalaire() + 100);
        }
        if (grade == 2) {
            setSalaire(getSalaire() + 200);
        }
        if (grade == 3) {
            setSalaire(getSalaire() + 300);
        }
    }

    public void calculerSalaire() {
        super.calculerSalaire();
        prime();
        System.out.println("Salaire après prime : " + getSalaire());
    }


    @Override
    public String toString() {
        return "Technicien{" +
                "grade='" + grade + '\'' +
                '}';
    }
}
