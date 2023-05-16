package org.example.controller;

import org.example.dao.impl.TodoDaoImpl;
import org.example.dao.impl.TodoInfoDaoImpl;
import org.example.model.Todo;
import org.example.model.TodoInfo;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class TodoAppConsole {
    private static TodoDaoImpl todoDao;
    private static TodoInfoDaoImpl todoInfoDao;

    public static void main() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("tpJPA");
        todoDao = new TodoDaoImpl(entityManagerFactory);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Afficher la liste des tâches");
            System.out.println("2. Ajouter une tâche");
            System.out.println("3. Supprimer une tâche");
            System.out.println("4. Mettre à jour une tâche");
            System.out.println("5. Marquer une tâche comme faite");
            System.out.println("6. Quitter");
            System.out.println("Votre choix : ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    todoDao.getAll().forEach(System.out::println);
                    break;
                case 2:
                    addTodo(scanner);
                    break;
                case 3:
                    deleteTodo(scanner);
                    break;
                case 4:
                    updateTodo(scanner);
                    break;
                case 5:
                    setAchieved(scanner);
                    break;
                case 6:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Veuillez saisir un choix valide !");
                    break;
            }

        } while (choice != 6);

    }

    private static void addTodo(Scanner scanner) {
        System.out.println("Veuillez saisir le titre de la tâche : ");
        String title = scanner.nextLine();
        Todo todo = new Todo();
        TodoInfo todoInfo = new TodoInfo();
        todo.setTitle(title);
        System.out.println("Veuillez saisir la description de la tâche : ");
        String description = scanner.nextLine();
        todoInfo.setDescription(description);
        System.out.println("Veuillez saisir la priorité de la tâche : ");
        String priority = scanner.nextLine();
        todoInfo.setPriority(priority);
        System.out.println("Veuillez saisir la date d'échéance de la tâche : au format dd-MM-yyyy ");
        String targetDate = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse(targetDate, formatter);
        todoInfo.setTargetDate(localDate);
        todo.setAchieved(false);
        todo.setTodoInfo(todoInfo);
        if (todoDao.create(todo)){
            System.out.println("La tâche a été ajoutée avec succès !");
        } else {
            System.out.println("Une erreur est survenue lors de l'ajout de la tâche !");
        }
    }

    private static void deleteTodo(Scanner scanner) {
        System.out.println("Veuillez saisir l'identifiant de la tâche à supprimer : ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Todo todo = todoDao.getById(id);
        if (todo != null) {
            if (todoDao.delete(todo)) {
                System.out.println("La tâche a été supprimée avec succès !");
            } else {
                System.out.println("Une erreur est survenue lors de la suppression de la tâche !");
            }
        } else {
            System.out.println("Aucune tâche ne correspond à l'identifiant saisi !");
        }
    }

    private static void updateTodo(Scanner scanner) {
        System.out.println("Veuillez saisir l'identifiant de la tâche à mettre à jour : ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        Todo todo = todoDao.getById(id);
        if (todo != null) {
            System.out.println("Veuillez saisir le nouveau titre de la tâche : ");
            String title = scanner.nextLine();
            todo.setTitle(title);
            System.out.println("Veuillez saisir la nouvelle description de la tâche : ");
            String description = scanner.nextLine();
            todo.getTodoInfo().setDescription(description);
            System.out.println("Veuillez saisir la nouvelle priorité de la tâche : ");
            String priority = scanner.nextLine();
            todo.getTodoInfo().setPriority(priority);
            System.out.println("Veuillez saisir la nouvelle date d'échéance de la tâche : au format dd-MM-yyyy ");
            String date = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate targetDate = LocalDate.parse(date, formatter);
            todo.getTodoInfo().setTargetDate(targetDate);
            if (todoDao.update(todo)) {
                System.out.println("La tâche a été mise à jour avec succès !");
            } else {
                System.out.println("Une erreur est survenue lors de la mise à jour de la tâche !");
            }
        } else {
            System.out.println("Aucune tâche ne correspond à l'identifiant saisi !");
        }
    }

    private static void setAchieved(Scanner scanner) {
        System.out.println("Veuillez saisir l'identifiant de la tâche à marquer comme faite : ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        if (todoDao.setAchieved(id)) {
            System.out.println("La tâche a été marquée comme faite avec succès !");
        } else {
            System.out.println("Une erreur est survenue lors du marquage de la tâche comme faite !");
        }

    }
}
