package org.example.ihm;

import org.example.contact.Contact;

import java.sql.SQLException;
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
                    delete();
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
        search();
    }

    private void search() {
        System.out.println("Merci de saisir le nom, prénom ou le numéro de télephone pour la recherche :");
        String searchWord = scanner.nextLine();
        System.out.println("Recherche de l'etudiant " + searchWord);
        Contact.searchWithsearchWord(searchWord);

    }

    private void deleteContact() throws SQLException {
        System.out.println("Suppression d'un contact");
          System.out.println("Selectionner l'id du contact a supprimer : ");
            System.out.println("Liste des contacts : ");
            Contact.displayAll();
            int choix = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < choix; i++) {
                System.out.println("Contact : " + choix);
                System.out.println("Contact supprimé");
                Contact.delete();
            }

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
            Contact.update(lastName, firstName, phoneNumber);
        }

    }
}
