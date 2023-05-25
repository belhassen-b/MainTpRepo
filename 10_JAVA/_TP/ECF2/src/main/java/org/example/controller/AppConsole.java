package org.example.controller;

import org.example.dao.impl.AccountDAOImpl;
import org.example.dao.impl.AgencyDAOImpl;
import org.example.dao.impl.ClientDAOImpl;
import org.example.model.Account;
import org.example.model.Agency;
import org.example.model.Client;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class AppConsole {

    private static ClientDAOImpl clientDAO;
    private static AgencyDAOImpl agencyDAO;
    private static AccountDAOImpl accountDAO;


    public static void main() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque");
        clientDAO = new ClientDAOImpl(emf);
        agencyDAO = new AgencyDAOImpl(emf);
        accountDAO = new AccountDAOImpl(emf);

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Créer une banque");
            System.out.println("2. Créer un client");
            System.out.println("3. Créer un compte");
            System.out.println("4. Afficher les banques disponibles");
            System.out.println("5. Afficher les comptes d'un client");
            System.out.println("6. Afficher les comptes d'une banque");
            System.out.println("7. Opération sur un compte client ");
            System.out.println("0. Quitter");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> createAgency(sc);
                case 2 -> createClient(sc);
                case 3 -> createAccount(sc);
                case 4 -> showAgencies();
                case 5 -> showAccountByClient(sc);
                case 6 -> showAgencyAccounts(sc);
                case 7 -> clientOperation(sc);
                case 8 -> {
                    System.out.println("Opération sur un compte client");
                    menuClient();
                }
                case 0 -> {
                    System.out.println("Au revoir !");
                    emf.close();
                }
                default -> System.out.println("Veuillez saisir un choix valide !");
            }
        } while (choice != 0);
    }

    private static void showAgencyAccounts(Scanner sc) {
        System.out.println("Liste des comptes d'une banque");
        agencyDAO.getAll().forEach( agency -> System.out.println("Agence n°: " + agency.getAgencyId() + " - Adresse :  " + agency.getAddress()));
        System.out.println("Saisir l'id de la banque");
        Long id = sc.nextLong();
        sc.nextLine();
        List<Account> accounts = accountDAO.getAllByAgency(id);
        if (accounts.isEmpty()) {
            System.out.println("Aucun compte trouvé");
        } else {
            accounts.forEach(
                    account -> System.out.println("Compte n°: " + account.getAccountId() + " - Solde :  " + account.getBalance() + "€"
                    )
            );
        }
    }

    private static void clientOperation(Scanner sc) {
        System.out.println("Opération sur un compte client");
        menuClient();
    }

    private static void showAccountByClient(Scanner sc) {
        System.out.println("Liste des comptes d'un client");
        clientDAO.getAll();
        System.out.println("Saisir l'id du client");
        Long id = sc.nextLong();
        sc.nextLine();
        Client client = clientDAO.getById(id);
        if (client != null) {
            client.getAccounts().forEach(
                    account -> System.out.println("Compte n°: " + account.getAccountId() + " - Solde :  " + account.getBalance() + "€"
                    )
            );
        } else {
            System.out.println("Client non trouvé");
        }
    }


    private static void showAgencies() {
        System.out.println("Liste des banques");
        agencyDAO.getAll().forEach(
                agency -> System.out.println("Agence n°: " + agency.getAgencyId() + " - Adresse :  " + agency.getAddress())
        );

    }

    private static void createAgency(Scanner sc) {
        System.out.println("Création d'une banque");
        System.out.println("Adresse de la banque : ");
        String address = sc.nextLine();
        Agency agency = new Agency();
        agency.setAddress(address);
        if (agencyDAO.create(agency)) {
            System.out.println("Banque créée avec succès !");
        } else {
            System.out.println("Erreur lors de la création de la banque !");
        }
    }

    private static void createClient(Scanner sc) {
        System.out.println("Création d'un client");
        System.out.println("Nom du client : ");
        String name = sc.nextLine();
        System.out.println("Prénom du client : ");
        String firstname = sc.nextLine();
        System.out.println("Date de naissance du client : ");
        String birthDate = sc.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(birthDate, formatter);
        Client client = new Client();
        client.setLastname(name);
        client.setFirstname(firstname);
        client.setBirthdate(localDate);
        if (clientDAO.create(client)) {
            System.out.println("Client créé avec succès !");
        } else {
            System.out.println("Erreur lors de la création du client !");
        }
    }

    private static void createAccount(Scanner sc) {
        System.out.println("Création d'un compte");
        System.out.println("Saisir le libéllé du compte : ");
        String label = sc.nextLine();
        System.out.println("Saisir l'Iban du compte : ");
        String iban = sc.nextLine();
        System.out.println("Numéro du client : ");
        Long clientId = sc.nextLong();
        sc.nextLine();
        System.out.println("Numéro de la banque : ");
        Long agencyId = sc.nextLong();
        sc.nextLine();
        System.out.println("Solde du compte : ");
        double balance = sc.nextDouble();
        sc.nextLine();
        Account account = new Account();
        account.setAccountName(label);
        account.setIban(iban);
        account.setBalance(balance);
        if (accountDAO.create(account, agencyId, clientId)) {
            System.out.println("Compte créé avec succès !");
        } else {
            System.out.println("Erreur lors de la création du compte !");
        }
    }

    private static void menuClient() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Dépot");
            System.out.println("2. Retrait");
            System.out.println("3. voir le soldes");
            System.out.println("0. Quitter");

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1 -> balanceDeposit();
                case 2 -> balanceWithdrawal();
                case 3 -> accountBalance();
                default -> System.out.println("Choix invalide");
            }
        } while (choice != 0);
    }

    // menu operation client
    private static void accountBalance() {
        System.out.println("Solde");
        System.out.println("Numéro du compte : ");
        Scanner sc = new Scanner(System.in);
        Long accountId = sc.nextLong();
        sc.nextLine();

        System.out.print("Libéllé Compte : " + accountDAO.getById(accountId).getAccountName() + " - ");
        Account account = accountDAO.getById(accountId);
        account.getClients().forEach(
                client -> System.out.println("Client : " + client.getFullName())
        );
        System.out.println("Solde du compte : " + account.getBalance() + "€");
    }

    private static void balanceDeposit() {
        System.out.println("Dépot");
        System.out.println("Numéro du compte : ");
        Scanner sc = new Scanner(System.in);
        Long accountId = sc.nextLong();
        sc.nextLine();
        System.out.println("Libéllé Compte : " + accountDAO.getById(accountId).getAccountName());
        Account account = accountDAO.getById(accountId);
        System.out.println("Montant du dépot : ");
        double amount = sc.nextDouble();
        sc.nextLine();
        account.setBalance(account.getBalance() + amount);
        if (accountDAO.update(account)) {
            System.out.println("Dépot effectué avec succès !");
        } else {
            System.out.println("Erreur lors du dépot !");
        }
    }

    private static void balanceWithdrawal() {
        System.out.println("Retrait");
        System.out.println("Numéro du compte : ");
        Scanner sc = new Scanner(System.in);
        Long accountId = sc.nextLong();
        sc.nextLine();
        System.out.println("Libéllé Compte : " + accountDAO.getById(accountId).getAccountName());
        Account account = accountDAO.getById(accountId);
        System.out.println("Montant du retrait : ");
        double amount = sc.nextDouble();
        sc.nextLine();
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            if (accountDAO.update(account)) {
                System.out.println("Retrait effectué avec succès !");
            } else {
                System.out.println("Erreur lors du retrait !");
            }
        } else {
            System.out.println("Solde insuffisant !");
        }
    }
}

