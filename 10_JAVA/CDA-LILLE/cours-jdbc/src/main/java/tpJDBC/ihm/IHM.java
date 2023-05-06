package tpJDBC.ihm;

import jdk.jshell.spi.ExecutionControl;

import tpJDBC.dao.ProductDAO;
import tpJDBC.models.Product;
import tpJDBC.utils.DataBaseManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class IHM {
    Scanner scanner;
    String choix;

    private Connection connection;

    private ProductDAO productDAO;

    public IHM() {
        scanner = new Scanner(System.in);
    }

    public void start() throws SQLException, ExecutionControl.NotImplementedException {
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1":
                    createProductAction();
                    break;
                case "2":
                    showAllProductAction();
                    break;
                case "3":
                    showProductByIdAction();
                    break;
                case "4":
                    updateProductAction();
                    break;
                case "5":
                    deleteProductAction();
                    break;
            }
        } while (!choix.equals("6"));
    }


    // Creation produit
    private void createProductAction() {
        Product product = null;
        System.out.println("Allons créer un produit!");
        System.out.println("Donnez-moi le nom du produit");
        System.out.println("Nom : ");
        String name = scanner.nextLine();
        System.out.println("Prix : ");
        scanner.nextLine();
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Quantité : ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Description : ");
        String description = scanner.nextLine();
        product = new Product(name, price, quantity, description);
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            productDAO = new ProductDAO(connection);
            if (productDAO.create(product)) {
                System.out.println("Le produit a bien été créé");
                connection.commit();
            } else {
                System.out.println("Le produit n'a pas été créé");
                product = null;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Suppression produit

    private void deleteProductAction() throws SQLException, ExecutionControl.NotImplementedException {
        System.out.println("Allons supprimer le produit!");
        System.out.println("Donnez-moi l'id du produit à supprimer");
        System.out.println("Id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        try {
            connection = new DataBaseManager().getConnection();
            connection.setAutoCommit(false);
            productDAO = new ProductDAO(connection);
            if (productDAO.delete(id)) {
                System.out.println("Le produit a bien été supprimé");
            }
            connection.commit();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    // Mise à jour du produit
    private void updateProductAction() throws SQLException, ExecutionControl.NotImplementedException {
        Product product = null;
        System.out.println("Allons modifier le produit!");
        System.out.println("Donnez-moi l'id du produit à modifier et les élements à modifier");
        System.out.println("Id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        connection = new DataBaseManager().getConnection();
        productDAO = new ProductDAO(connection);
        Product Product = productDAO.findById(id);
        System.out.println("Nom : " + Product.getName());
        String name = scanner.nextLine();
        System.out.println("Prix : " + Product.getPrice());
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Quantité : " + Product.getQuantity());
        int quantity = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Description : " + Product.getDescription());
        String description = scanner.nextLine();
        scanner.nextLine();
        product = new Product(id, name, price, quantity, description);
        productDAO.update(product);
    }


    // Affichage produit par id
    private void showProductByIdAction() throws SQLException {
        System.out.println("Voyons le produit!");
        System.out.println("Donnez-moi l'id du produit");
        System.out.println("Id : ");
        int id = scanner.nextInt();
        scanner.nextLine();
        connection = new DataBaseManager().getConnection();
        productDAO = new ProductDAO(connection);
        Product product = productDAO.findById(id);
    }


    //Affichage de tous les produits
    private void showAllProductAction() {
        try {
            connection = new DataBaseManager().getConnection();
            productDAO = new ProductDAO(connection);
            productDAO.findAll();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    private void menu() {
        System.out.println("-------------------------------");
        System.out.println(" Liste de produits ");
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("1 - Enregistrer un produit ");
        System.out.println("2 - Afficher la liste des produits ");
        System.out.println("3 - Afficher un produit");
        System.out.println("4 - Mise à jour d'un produit");
        System.out.println("5 - Supprimer un produit");
        System.out.println("6 - Exit");
    }


}
