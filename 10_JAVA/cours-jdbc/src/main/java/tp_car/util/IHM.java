package tp_car.util;

import tp_car.service.CarService;
import tp_car.service.PersonService;
import tp_car.service.SaleService;

import java.util.Scanner;

public class IHM {

    private Scanner sc;
    private String choix;
    private CarService carService;
    private PersonService personService;
    private SaleService saleService;
    public void start() {
        sc = new Scanner(System.in);


        do {
            menu();
            choix = sc.nextLine();
            switch (choix) {
                case "1":
                    createCar();
                    break;
                case "2":
                    listCar();
                    break;
                case "3":
                    deleteCar();
                    break;
                case "4":
                    updateCar();
                    break;
                case "5":
                    createPerson();
                    break;
                case "6":
                    listPerson();
                    break;
                case "7":
                    deletePerson();

                    break;
                case "8":
                    updatePerson();

                    break;
                case "9":
                    createSale();

                    break;
                case "10":
                    getAllSales();

                    break;
                case "11":
                    selectCarByPersonId();
                    break;

            }
        } while (!choix.equals("0"));
    }

    private void selectCarByPersonId() {
        System.out.println("Merci de saisir l'id de la personne : ");
        int id = sc.nextInt();
        sc.nextLine();
        saleService = new SaleService();
        System.out.println(saleService.getSale(id));
        }


    private void getAllSales() {
        saleService = new SaleService();
        saleService.getSales().forEach(s -> {
            System.out.println(s);
        });
    }

    private void createSale() {
        System.out.println("Merci de saisir l'id de la voiture : ");
        int carIdVente = sc.nextInt();
        sc.nextLine();
        System.out.println("Merci de saisir l'id de la personne : ");
        int personIdVente = sc.nextInt();
        sc.nextLine();
        SaleService saleService = new SaleService();
        if(saleService.createSale(carIdVente, personIdVente)) {
            System.out.println("Vente créée");
        }
        else {
            System.out.println("Erreur création");
        }
    }

    private void updatePerson() {
        System.out.println("Merci de saisir l'id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Merci de saisir le nom : ");
        String nom = sc.nextLine();
        System.out.println("Merci de saisir le prenom : ");
        String prenom = sc.nextLine();
        System.out.println("Merci de saisir l'age : ");
        int age = sc.nextInt();
        PersonService personService = new PersonService();
        if(personService.updatePerson(id, nom, prenom, age)) {
            System.out.println("Personne modifiée");
        }
        else {
            System.out.println("Erreur modification");
        }
    }

    private void deletePerson() {
        System.out.print("Merci de saisir l'id de la personne : ");
        int id = sc.nextInt();
        sc.nextLine();
        personService = new PersonService();
        if(personService.deletePerson(id)) {
            System.out.println("Contact supprimé");
        }
        else {
            System.out.println("Erreur suppression");
        }
    }

    private void listPerson() {
        personService = new PersonService();
        personService.getAllPersons().forEach(System.out::println);
    }

    private void createPerson() {
        System.out.println("Merci de saisir le nom : ");
        String nom = sc.nextLine();
        System.out.println("Merci de saisir le prenom : ");
        String prenom = sc.nextLine();
        System.out.println("Merci de saisir l'age : ");
        int age = sc.nextInt();
        PersonService personService = new PersonService();
    }

    private void updateCar() {
        System.out.print("Merci de saisir l'id : ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Merci de saisir le model : ");
        String model = sc.nextLine();
        System.out.print("Merci de saisir l'année : ");
        String year = sc.nextLine();
        System.out.print("Merci de saisir le prix : ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Merci de saisir la puissance : ");
        int power = sc.nextInt();
        sc.nextLine();
        carService = new CarService();
        if(carService.updateCar(id, model, price, power, year)) {
            System.out.println("voiture modifiée");
        }
        else {
            System.out.println("Erreur modification");
        }
        if(carService.updateCar(id, model, price, power, year)) {
            System.out.println("voiture modifiée");
        }
        else {
            System.out.println("Erreur modification");
        }
    }

    private void deleteCar() {
        System.out.print("Merci de saisir l'id de la voiture : ");
        int id = sc.nextInt();
        sc.nextLine();
        carService = new CarService();
        if(carService.deleteCar(id)) {
            System.out.println("voiture supprimée");
        }
        else {
            System.out.println("Erreur suppression");
        }
    }

    private void listCar() {
        carService = new CarService();
        carService.getAllCars().forEach(c -> {
            System.out.println(c);
        });
    }

    private void createCar() {
        System.out.print("Merci de saisir le model : ");
        String model = sc.nextLine();
        System.out.print("Merci de saisir l'année : ");
        String year = sc.nextLine();
        System.out.print("Merci de saisir le prix : ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Merci de saisir la puissance : ");
        int power = sc.nextInt();
        sc.nextLine();
        carService = new CarService();
        if(carService.createCar(model, price, power, year)){
            System.out.println("Voiture ajoutée");
        }
        else {
            System.out.println("Erreur d'ajout de voiture");
        }
    }

    private void menu() {
        System.out.println("-------------------------------");
        System.out.println(" TP 2 VOITURE ");
        System.out.println("-------------------------------");
        System.out.println();
        System.out.println("1 - Enregistrer la voiture ");
        System.out.println("2 - Lister toutes les voitures ");
        System.out.println("3 - Supprimer la voiture ");
        System.out.println("4 - Modifier une voiture ");
        System.out.println("5 - Inscrire un acheteur");
        System.out.println("6 - Lister toutes les acheteur");
        System.out.println("7 - Supprimer une personne");
        System.out.println("8 - Modifier un acheteur");
        System.out.println("9 - Faire la vente");
        System.out.println("10 - Afficher les ventes de voiture ");
        System.out.println("11 - Afficher la liste des ventes d'un véhicule pour un acheteur");
        System.out.println("12 - Quitter");
    }
}
