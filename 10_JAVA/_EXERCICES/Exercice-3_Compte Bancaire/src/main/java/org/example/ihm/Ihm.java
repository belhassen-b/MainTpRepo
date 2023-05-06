package org.example.ihm;

import org.example.bank.BankAccount;

import org.example.customer.Customer;
import org.example.operations.Operation;

import java.sql.SQLException;
import java.util.Scanner;

public class Ihm {

    private Scanner scanner;

    public Ihm() {
        this.scanner = new Scanner(System.in);
    }

    private void menu() {
        System.out.println("Bienvenue dans votre banque");
        System.out.println("1. Créer un compte");
        System.out.println("2. Déposer de l'argent");
        System.out.println("3. Retirer de l'argent");
        System.out.println("4. Afficher un compte");
        System.out.println("6. Quitter");

    }

    private void createAccountAction() {
        System.out.println("Création d'un compte");
        System.out.println("Saisir le nom du client");
        String firstName = scanner.nextLine();
        System.out.println("Saisir le prénom du client");
        String lastName = scanner.nextLine();
        System.out.println("Saisir le numéro de téléphone du client");
        String phone = scanner.nextLine();
        System.out.println("Saisir le solde du compte");
        double solde = scanner.nextDouble();
        scanner.nextLine();
        Customer customer = new Customer(firstName, lastName, phone);
        if (customer.save()) {
            BankAccount account = new BankAccount(customer.getId(), solde);
            if (account.save()) {
                System.out.println("Compte créé");
            } else {
                System.out.println("Erreur lors de la création du compte");
            }
        } else {
            System.out.println("Erreur lors de la création du client");
        }


    }

    private void depositAction() throws SQLException {
        System.out.println("Déposer de l'argent");
        System.out.println("Saisir le numéro du compte");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir le montant à déposer");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        BankAccount account = BankAccount.getById(numero);
        if (account != null) {
            Operation operation = new Operation(montant, account.getId());
            if (account.makeDeposit(operation)) {
                System.out.println("Dépôt effectué");
            } else {
                System.out.println("Erreur lors du dépôt");
            }
        } else {
            System.out.println("Compte inconnu");
        }

    }

    private void withDrawlAction() throws SQLException {
        System.out.println("Retirer de l'argent");
        System.out.println("Saisir le numéro du compte");
        int numero = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir le montant à retirer");
        double montant = scanner.nextDouble();
        scanner.nextLine();
        BankAccount account = BankAccount.getById(numero);
        if (account != null) {
            Operation operation = new Operation(montant, account.getId());
            if (account.makeWithDrawl(operation)) {
                System.out.println("Retrait effectué");
            } else {
                System.out.println("Erreur lors du retrait");
            }
        } else {
            System.out.println("Compte inconnu");
        }

    }

    private BankAccount getAccountAction() throws SQLException {
        System.out.println("Afficher un compte");
        System.out.println("Saisir le numéro du compte");
        int numero = scanner.nextInt();
        scanner.nextLine();
        BankAccount account = BankAccount.getById(numero);
        if (account != null) {
            System.out.println("Numéro du compte : " + account.getId());
            System.out.println("Solde du compte : " + account.getTotalAmount());
            System.out.println("Opérations : ");
            for (Operation operation : account.getOperations()) {
                System.out.println(operation);
            }

        } else {
            System.out.println("Compte inconnu");
        }
        return account;
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            menu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    createAccountAction();
                    break;
                case 2:
                    try {
                        depositAction();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    try {
                        withDrawlAction();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    try {
                        getAccountAction();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Choix inconnu");
            }
        }
    }
}


