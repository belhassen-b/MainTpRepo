package org.example.exEnum;

import java.util.Scanner;


public class Application {
    public static void main(String[] args) {
        System.out.println("Merci de selectionner  le type de message : ");
        System.out.println("A : Urgent");
        System.out.println("B : Important");
        System.out.println("C : Normal");
        System.out.println("D : Faible");
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        MessageType messageType = new MessageType();
        Priority priority = messageType.getPriority(message);
        System.out.println("Le message est de type : " + priority);

    }
}
