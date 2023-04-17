package org.example.Stream;

import org.example.Stream.course.Course;
import org.example.Stream.student.Student;
import org.example.Stream.teacher.Teacher;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Application {
    public static void main(String[] args) {

        Teacher teacher1 = new Teacher(1, "John Doe", "Math", 2010);
        Teacher teacher2 = new Teacher(2, "Jane Smith", "Physics", 2015);
        Teacher teacher3 = new Teacher(3, "Michael Johnson", "Chemistry", 2005);
        Teacher teacher4 = new Teacher(4, "Michel  Papin", "Informatique", 2003);

        Course course1 = new Course(1, "Calculus", teacher1, 55);
        Course course2 = new Course(2, "Mechanics", teacher2, 60);
        Course course3 = new Course(3, "Organic Chemistry", teacher3, 80);
        Course course4 = new Course(4, "Java", teacher4, 29);

        Student student1 = new Student(1,"Alice Smith", 18);
        Student student2 = new Student(2,"Bob Johnson", 20);
        Student student3 = new Student(3,"Charlie Williams", 19);
        Student student4 = new Student(4,"David Brown", 21);
        Student student5 = new Student(5,"Eve Jones", 22);

        student1.addCourse(course1);
        student1.addCourse(course2);
        student2 .addCourse(course3);
        student2.addCourse(course1);
        student3.addCourse(course4);
        student3.addCourse(course3);
        student3.addCourse(course1);
        student4 .addCourse(course3);
        student4.addCourse(course1);
        student4.addCourse(course2);
        student4.addCourse(course4);
        student5.addCourse(course1);
        student5.addCourse(course3);
        student5.addCourse(course2);


        System.out.println("**********************");
        System.out.println("1 - Sélectionner les Student qui ont un âge supérieur à 18 ans : ");

        Arrays.asList(student1, student2, student3, student4, student5)
                .stream()
                .filter(student -> student.getAge() > 18)
                .forEach(student -> System.out.println(student.getName()));


        System.out.println("**********************");
        System.out.println("2 - Transformer les Teacher en une liste de leurs noms ");
        Arrays.asList(teacher1, teacher2, teacher3, teacher4)
                .stream()
                .map(teacher -> teacher.getName())
                .forEach(teacher -> System.out.println(teacher));

        System.out.println("**********************");
        System.out.println("3 - Transformer les Teacher en une liste de leurs matières enseignées ");
        Arrays.asList(teacher1, teacher2, teacher3, teacher4)
                .stream()
                .map(teacher -> teacher.getName().concat(" : ").concat(teacher.getDepartment()))
                .forEach(teacher -> System.out.println(teacher));

        System.out.println("**********************");
        System.out.println("4 – Donnez-moi la liste des teachers en passant par les courses ");
        Arrays.asList(course1, course2, course3, course4)
                .stream()
                .map(course -> course.getTeacher()  )
                .forEach(teacher -> System.out.println("Teacher: " + teacher.getName()));

        System.out.println("**********************");
        System.out.println("5 - Calculer la somme de toutes les durées des cours ");
        Arrays.asList(course1, course2, course3, course4)
                .stream()
                .map(course -> course.getDuration())
                .reduce((a, b) -> a + b)
                .ifPresent(System.out::println);

        System.out.println("**********************");
        System.out.println("6 - Sélectionner les cours avec une durée supérieure à 30 heures, puis récupérer une liste de\n" +
                "leurs noms triée par ordre alphabétique");
        Arrays.asList(course1, course2, course3, course4)
                .stream()
                .filter(course -> course.getDuration() > 30)
                .map(course -> course.getName().concat(" : ").concat(String.valueOf(course.getDuration())))
                .sorted()
                .forEach(course -> System.out.println(course));

        System.out.println("**********************");
        System.out.println("7 - Regrouper les Student par âge avec les noms , puis afficher le nombre d'étudiants dans chaque groupe");
        Arrays.asList(student1, student2, student3, student4, student5)
                .stream()
                .collect(Collectors.groupingBy(Student::getAge))
                .forEach((age, students) -> System.out.println(age + " : " + students.stream().map(Student::getName).collect(Collectors.joining(", "))));


        System.out.println("**********************");
        System.out.println("8 – En passant par Student, il faut récupérer une liste de Course et il faut garder les doublons :");
        Arrays.asList(student1, student2, student3, student4, student5)
                .stream()
                .map(student -> student.getCourses())
                .flatMap(course -> course.stream())
                .forEach(course -> System.out.println(course.getName()));


        System.out.println("**********************");
        System.out.println("9 - Sélectionner les cours avec une durée supérieure à 40 heures, puis récupérer une liste de leurs noms triée par ordre alphabétique");
    Arrays.asList(course1, course2, course3, course4)
            .stream()
            .filter(course -> course.getDuration() > 40)
            .map(course -> course.getName().concat(" : ").concat(String.valueOf(course.getDuration())))
            .sorted()
            .forEach(course -> System.out.println(course));

        System.out.println("**********************");
        System.out.println("10 - Regrouper les Teacher par année d'entrée en fonction, puis afficher le nombre\n" +
                "d'enseignants dans chaque groupe ? (vous pouvez utiliser une collection comme map pour\n" +
                "récupérer le resultat).");
        Arrays.asList(teacher1, teacher2, teacher3, teacher4)
                .stream()
                .collect(Collectors.groupingBy(Teacher::getStartDate))
                .forEach((year, teachers) -> System.out.println(year + " : " + teachers.stream().map(Teacher::getName).collect(Collectors.joining(", "))));


        System.out.println("**********************");
        System.out.println("11 - Sélectionner les Student avec un âge compris entre 18 et 20 ans, puis récupérer une liste de leurs Course triée par ordre alphabétique");
        Arrays.asList(student1, student2, student3, student4, student5)
                .stream()
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 20)
                .collect(Collectors.toList())
                .forEach(student -> System.out.println(student.getName() + " : " + student.getCourses().stream().map(Course::getName).sorted().collect(Collectors.joining(", "))));

        System.out.println("**********************");
        System.out.println("12 - Quel est le nombre moyen de cours suivis par les étudiants de plus de 20 ans");
            Arrays.asList(student1, student2, student3, student4, student5)
                .stream()
                .filter(student -> student.getAge() > 20)
                .map(student -> student.getCourses().size())
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(System.out::println);

        System.out.println("**********************");
        System.out.println("13 - Quels sont les noms des étudiants qui ont suivi tous les cours");
        Arrays.asList(student1, student2, student3, student4, student5)
                .stream()
                .filter(student -> student.getCourses().size() == 3)
                .map(student -> student.getName())
                .forEach(student -> System.out.println(student));
}
}
