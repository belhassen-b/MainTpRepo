package org.example.controller;

import java.util.Scanner;

public class AppConsole {





    public static void main() {


        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("1. Afficher la liste des tâches");


            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> System.out.println("Hello world!");
                case 2 -> System.out.println("Au revoir !");
                default -> System.out.println("Veuillez saisir un choix valide !");
            }
        } while (choice != 2);
        }

    }

