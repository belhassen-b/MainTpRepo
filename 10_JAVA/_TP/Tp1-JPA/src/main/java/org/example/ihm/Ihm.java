package org.example.ihm;

import java.sql.SQLException;
import java.util.Scanner;

import static org.example.persistence.Useful.*;

public class Ihm {

    Scanner scanner;
    String choix;
    public Ihm() {
        this.scanner = new Scanner(System.in);
        this.choix = "";
    }
    public void start() throws SQLException {
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1" -> createTodo();
                case "2" -> showAllTodos();
                case "3" -> setTodoAchieved();
                case "4" -> deleteTodo();
                case "5" -> quit();
            }
        }while (!choix.equals("5"));
    }


    private void menu() {
                System.out.println("******************************");
                System.out.println("1 - Ajouter une tâche à la liste");
                System.out.println("2 - Afficher toutes les tâches");
                System.out.println("3 - Marquer une tâche comme terminée");
                System.out.println("4 - Supprimer une tâche");
                System.out.println("5 - Quitter");
            }

    }