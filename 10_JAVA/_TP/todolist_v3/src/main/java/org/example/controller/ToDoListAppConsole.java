package org.example.controller;

import org.example.impl.CategoryDAOImpl;
import org.example.impl.PersonDAOImpl;
import org.example.impl.TaskDAOImpl;
import org.example.model.Category;
import org.example.model.Person;
import org.example.model.Task;
import org.example.model.TaskInfo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDoListAppConsole {

    private static EntityManagerFactory entityManagerFactory;
    private static TaskDAOImpl taskDAO;

    private static PersonDAOImpl personDAO;

    private static CategoryDAOImpl categoryDAO;

    public static void main() {
        entityManagerFactory = Persistence.createEntityManagerFactory("todolist");
        taskDAO = new TaskDAOImpl(entityManagerFactory);
        personDAO = new PersonDAOImpl(entityManagerFactory);

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("#### To Do List ####");
            System.out.println("1. Ajouter une personne");
            System.out.println("2. Afficher les tâches d'une personne");
            System.out.println("3. Ajouter une tâche à la liste");
            System.out.println("4. Afficher toutes les tâches de la liste");
            System.out.println("5. Marquer une tâche comme terminée");
            System.out.println("6. Supprimer une personne et ses tâches");
            System.out.println("7. Supprimer une tâche de la liste");
            System.out.println("8. Ajouter une catégorie");
            System.out.println("9. Supprimer une catégorie");
            System.out.println("10. Afficher les tâches d'une catégorie");
            System.out.println("11. Ajouter une tâche à une catégorie");
            System.out.println("12. Supprimer une tâche d'une catégorie");


            System.out.println("0. Quitter l'application");
            System.out.println("Choix : ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consomme la nouvelle ligne

            switch (choice) {
                case 1 -> addPerson(scanner);
                case 2 -> displayTasksPerson(scanner);
                case 3 -> addTask(scanner);
                case 4 -> displayTasks();
                case 5 -> markTaskAsCompleted(scanner);
                case 6 -> deleteUser(scanner);
                case 7 -> deleteTask(scanner);
                case 8 -> addCategory(scanner);
                case 9 -> deleteCategory(scanner);
                case 10 -> showTasksByCategory(scanner);
                case 11 -> addTaskToCategory(scanner);
                case 12 -> deleteTaskFromCategory(scanner);
                case 0 -> {
                    System.out.println("Bye");
                    entityManagerFactory.close();
                }
                default -> System.out.println("Choix invalide. Veuillez réessayer.");
            }

        }while (choice != 0);
    }



    //1-
    private static void addPerson(Scanner scanner){
        System.out.println("Entrer le nom de la personne : ");
        String personName = scanner.nextLine();

        Person person = new Person(personName);
        personDAO.addPerson(person);
        System.out.println("Personne ajoutée");
    }

    //2-

    private static void displayTasksPerson(Scanner scanner){
        System.out.println("Entrez l'ID de la personne  : ");
        Long personId  = scanner.nextLong();
        scanner.nextLine();

        List<Task> tasks = taskDAO.gettasksByPersonId(personId);
        System.out.println("Tâches de la personne avec l' ID : "+ personId + " : ");
        for (Task t : tasks){
            System.out.println(t.getId() + ". " + t.getTitle() + " (" + (t.isCompleted() ? "Terminée" : "En cours") + ")");
        }
    }


    //3-

    private static void addTask(Scanner scanner){
        System.out.println("Entrer le titre de la tâche : ");
        String title = scanner.nextLine();

        System.out.println("Entrer la description de la tâche : ");
        String description = scanner.nextLine();

        System.out.println("Date limite de la tâche : (dd.MM.yyyy)");
        String dueDateStr = scanner.nextLine();

        LocalDate dueDate = LocalDate.parse(dueDateStr, DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        System.out.println("Priorité de la tâche : ");
        int priority = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Entrez l'ID de la personne pour cette tâche : ");
        Long personId = scanner.nextLong();

        // Creation de la tache
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);

        //Creation de la taskinfo
        TaskInfo taskInfo = new TaskInfo(description,dueDate,priority);

        // Mise en relation
        task.setTaskInfo(taskInfo);
        taskInfo.setTask(task);

        if(taskDAO.addTask(task,personId)){
            System.out.println("Tâche ajoutée avec succès !");
        }else {
            System.out.println("Erreur");
        }
    }

    //4-
    private static void displayTasks() {
        List<Task> tasks = taskDAO.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("Aucune tâche trouvée.");
        } else {
            System.out.println("=== Liste des tâches ===");
            for (Task task : tasks) {
                System.out.println("###########");
                System.out.println(task.getId() + ". " + task.getTitle() + " (" + (task.isCompleted() ? "Terminée" : "En cours") + ")");
                System.out.println(task.getTaskInfo().toString());
                System.out.println("###########");
            }
        }
    }

    //5-

    private static void markTaskAsCompleted(Scanner scanner){
        System.out.println("Entrez l'ID de la tâche à supprimer : ");
        Long taskId  = scanner.nextLong();
        scanner.nextLine();

        if (taskDAO.markTaskAsCompleted(taskId)){
            System.out.println("Modification OK");
        }else {
            System.out.println("Erreur");
        }
    }

    //6-
    private static void deleteUser(Scanner scanner){
        System.out.println("Entrez l'ID de la personne à supprimer : ");
        Long personId  = scanner.nextLong();
        scanner.nextLine();
        personDAO.deletePerson(personId);
        System.out.println("Personne supprimée");

    }


    //7-

    private static void deleteTask(Scanner scanner){
        System.out.println("Entrez l'ID de la tâche à supprimer : ");
        Long taskId  = scanner.nextLong();
        scanner.nextLine();

        if (taskDAO.deleteTask(taskId)){
            System.out.println("Suppression OK");
        }else {
            System.out.println("Erreur");
        }
    }


    //8-
    private static void addCategory(Scanner scanner){
        System.out.println("Entrer le nom de la catégorie : ");
        String categoryName = scanner.nextLine();

        Category category = new Category(categoryName);
        categoryDAO.addCategory(category);
        System.out.println("Catégorie ajoutée");
    }

    //9-
         public static void deleteCategory(Scanner scanner){
        System.out.println("Entrez l'ID de la catégorie à supprimer : ");
        Long categoryId  = scanner.nextLong();
        scanner.nextLine();

if(categoryDAO.delete(categoryId)){
            System.out.println("Suppression OK");
        }else {
            System.out.println("Erreur");
        }
    }

    //10-
    public static void showTasksByCategory(Scanner scanner){
        System.out.println("Entrez l'ID de la catégorie : ");
        Long categoryId  = scanner.nextLong();
        scanner.nextLine();

        List<Task> tasks = taskDAO.getTasksByCategoryId(categoryId);
                System.out.println("Tâches de la catégorie avec l' ID : "+ categoryId + " : ");
        for (Task t : tasks){
            System.out.println(t.getId() + ". " + t.getTitle() + " (" + (t.isCompleted() ? "Terminée" : "En cours") + ")");
        }
    }
    //11-

    public static void addTaskToCategory(Scanner scanner){
        System.out.println("Entrez l'ID de la tâche à ajouter : ");
        Long taskId  = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Entrez l'ID de la catégorie à ajouter : ");
        Long categoryId  = scanner.nextLong();
        scanner.nextLine();

        if (taskDAO.addTaskToCategory(taskId,categoryId)){
            System.out.println("Ajout OK");
        }else {
            System.out.println("Erreur");
        }
    }



    //12-

public static void deleteTaskFromCategory(Scanner scanner){
        System.out.println("Entrez l'ID de la tâche à supprimer : ");
        Long taskId  = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Entrez l'ID de la catégorie à supprimer : ");
        Long categoryId  = scanner.nextLong();
        scanner.nextLine();

        if (taskDAO.deleteTaskFromCategory(taskId,categoryId)){
            System.out.println("Suppression OK");
        }else {
            System.out.println("Erreur");
        }
}

}















