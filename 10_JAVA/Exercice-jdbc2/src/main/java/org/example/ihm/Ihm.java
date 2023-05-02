package org.example.ihm;

import org.example.contact.Contact;
import org.example.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Ihm {

    private Scanner scanner;

    public Ihm() {
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choix;
        do {
            displayMenu();
            choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    addContact();
                    break;
                case 2:
                    searchContact();
                    break;
                case 3:
                    deleteContact();
                    break;
                case 4:
                    updateContact();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        } while (choix != 5);

    }

    private void displayMenu() {
        System.out.println("Merci de faire votre choix : ");
        System.out.println("1 - Ajouter un contact");
        System.out.println("2 - Rechercher un contact");
        System.out.println("3 - Supprimer un contact");
        System.out.println("4 - Modifier un contact");
        System.out.println("5 - Quitter");
    }

    private void addContact() {
        System.out.println("Ajout d'un contact");
        System.out.print("Nom : ");
        String lastName = scanner.nextLine();
        System.out.print("Prenom : ");
        String firstName = scanner.nextLine();
        System.out.print("Numero de telephone : ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Contact ajoute");
        Contact contact = new Contact(lastName, firstName, phoneNumber);
        contact.save();
    }

    private void searchContact() {
        System.out.println("Recherche d'un contact");
        System.out.println("Selectionnez le type de recherche : ");
        System.out.println("1 - Nom");
        System.out.println("2 - Prenom");
        System.out.println("3 - Numero de telephone");
        int choix = scanner.nextInt();
        scanner.nextLine();
        switch (choix) {
            case 1:
                searchByLastName();
                break;
            case 2:
                searchByFirstName();
                break;
            case 3:
                searchByPhoneNumber();
                break;
            default:
                System.out.println("Choix invalide");
        }
    }

    private void searchByFirstName() {
        System.out.println("Merci de saisir le prénom :");
        String firstName = scanner.nextLine();
        System.out.println("Recherche de l'etudiant " + firstName);
        Contact.searchByIdWithFirstname(firstName);

    }

    private void searchByLastName() {
        System.out.println("Merci de saisir le nom :");
        String lastName = scanner.nextLine();
        System.out.println("Recherche de l'etudiant " + lastName);
        Contact.searchByIdWithLastname(lastName);

    }

    private void searchByPhoneNumber() {
        System.out.println("Merci de saisir le numéro de téléphone :");
        String phoneNumber = scanner.nextLine();
        System.out.println("Recherche de l'etudiant " + phoneNumber);
        Contact.searchByIdWithPhone(phoneNumber);
    }

    private void deleteContact() {
        System.out.println("Suppression d'un contact");
        System.out.println("Selectionnez le type de recherche : ");
        System.out.println("1 - Nom");
        System.out.println("2 - Prenom");
        System.out.println("3 - Numero de telephone");
        int choix = scanner.nextInt();
        scanner.nextLine();
        switch (choix) {
            case 1:
                deleteByLastName();
                break;
            case 2:
                deleteByFirstName();
                break;
            case 3:
                deleteByPhoneNumber();
                break;
            default:
                System.out.println("Choix invalide");
        }
    }

    private void deleteByPhoneNumber() {
        System.out.println("Merci de saisir le numéro de téléphone :");
        String phoneNumber = scanner.nextLine();
        System.out.println("Suppression du contact " + phoneNumber);
        Contact.deleteWithPhone(phoneNumber);
    }

    private void deleteByFirstName() {
        System.out.println("Merci de saisir le prénom :");
        String firstName = scanner.nextLine();
        System.out.println("Suppression du contact " + firstName);
        Contact.deleteWithFirstName(firstName);
    }

    private void deleteByLastName() {
        System.out.println("Merci de saisir le nom :");
        String lastName = scanner.nextLine();
        System.out.println("Suppression du contact " + lastName);
        Contact.deleteWithLastName(lastName);
    }

    private void updateContact() {
        System.out.println("Mise a jour d'un contact");
        System.out.println("Selectionner l'id du contact a mettre a jour : ");
        System.out.println("Liste des contacts : ");
        Contact.displayAll();
        int choix = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < choix; i++) {
            System.out.println("Contact : " + choix);
            System.out.println("Saisir le nouveau nom : ");
            String lastName = scanner.nextLine();
            System.out.println("Saisir le nouveau prenom : ");
            String firstName = scanner.nextLine();
            System.out.println("Saisir le nouveau numero de telephone : ");
            String phoneNumber = scanner.nextLine();
            System.out.println("Contact mis a jour");
            Contact.updateContact(choix,lastName, firstName, phoneNumber);
        }

    }
}
