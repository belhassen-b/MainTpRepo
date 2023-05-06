package org.example.employe;

public class Employe {

    private String nom;
    private int age;

    private double salaire;

    public Employe() {
    }

public Employe(String nom, int age, double salaire) {
        this.nom = nom;
        this.age = age;
        this.salaire = salaire;
    }

    public void Augmentation() {
        int grade = 0;
if (age < 20) {
            grade = 1;
        }
        if (age >= 20 && age < 30) {
            grade = 2;
        }
        if (age >= 30 && age < 40) {
            grade = 3;
        }
    }

        public void Afficher() {
            System.out.println("Nom : " + nom);
            System.out.println("Age : " + age);
        }

        public void calculerSalaire() {
            System.out.println("Salaire : " + salaire);
        }

        public String getNom() {
            return nom;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public double getSalaire() {
            return salaire;
        }

        public void setSalaire(double salaire) {
            this.salaire = salaire;
        }

        @Override
        public String toString() {
            return "Employe{" +
                    "nom='" + nom + '\'' +
                    ", age=" + age +
                    ", salaire=" + salaire +
                    '}';
        }

    }


