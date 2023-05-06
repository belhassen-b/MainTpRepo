package org.example.ex113;

import org.example.ex113.enums.Etat;
import org.example.ex113.enums.Unite;

import java.util.List;
import java.util.Scanner;

public class Ihm {
    Scanner sc = new Scanner(System.in);
        private Plat plat;
        private boolean continuer;

    public Ihm(Plat plat) {
        this.plat = plat;
        this.continuer = true;
    }


    public void afficherMenu() {
        System.out.println("==============================");
        System.out.println("==============================");
        System.out.println("1- Afficher les plats ");
        System.out.println("2- Ajouter un plat");
        System.out.println("3- Supprimer un plat");
        System.out.println("0- Quitter");
        System.out.println("==============================");
        System.out.print("Votre choix : ");
    }


    //1-Afficher les plats
    public void afficherPlats() {
        System.out.println("==== Afficher les plats ====");
        System.out.println();
        System.out.println("Plat: " + plat.getNomPlat());
        System.out.println("Ingredients: ");
        for (Ingredient ingredient : plat.getIngredients()) {
            System.out.println(ingredient.getNomIngredient() + " " + ingredient.getEtat() + " " + ingredient.getQuantite() + " " + ingredient.getUnite());
        }
    }

    //2- Ajouter un plat
    private void ajouterPlat(){
        System.out.println("==== Ajouter un plat ====");
        System.out.println();
        System.out.println("Merci de saisir le nom  du plat: ");
        sc.nextLine();
        int compteur= 0;
        int idPlat  = ++compteur;
        String nomPlat = sc.nextLine();
        int idIngredient = ++compteur;
        System.out.println("Merci de saisir le nom de l'ingredient: ");
        String nomIngredient = sc.nextLine();
        System.out.println("Merci de saisir l'etat de l'ingredient:  ex :(  CUIT, ENTIER, CRU, DECOUPES)");
        String etat = sc.nextLine();
        System.out.println("Merci de saisir l'unite de l'ingredient:  ex :( KILOGRAMME, GRAMME, MILLIGRAMME, DECIGRAMME, CENTIGRAMME, UNITE, LITRE, MILLILITRE, CENTILITRE, DECILITRE, DECALITRE, HECTOLITRE\n)");
        String unite = sc.nextLine();
        System.out.println("Merci de saisir la quantite de l'ingredient: ");
        int quantite = sc.nextInt();
        Ingredient ingredient = new Ingredient(idIngredient, nomIngredient, etat, unite, quantite);
        Ingredient[] ingredients = new Ingredient[idIngredient];
        System.out.println("Voici la liste des ingredients pour ce plat: ");
    for (int i = 0; i < ingredients.length; i++) {
            System.out.println(ingredient.getNomIngredient() + " " + ingredient.getEtat() + " " + ingredient.getQuantite() + " " + ingredient.getUnite());
        }
        System.out.println("L'ingédient a bien ete ajouté");
        System.out.println("Ajouter un autre ingredient? (O/N)");
        String reponse = sc.nextLine();
        for (int i = 0; i < ingredients.length; i++) {
            if (reponse.equals("O")){
                System.out.println("Merci de saisir le nom de l'ingredient: ");
                nomIngredient = sc.nextLine();
                System.out.println("Merci de saisir l'etat de l'ingredient:  ex :(  CUIT, ENTIER, CRU, DECOUPES)");
                etat = sc.nextLine();
                System.out.println("Merci de saisir l'unite de l'ingredient:  ex :( KILOGRAMME, GRAMME, MILLIGRAMME, DECIGRAMME, CENTIGRAMME, UNITE, LITRE, MILLILITRE, CENTILITRE, DECILITRE, DECALITRE, HECTOLITRE\n)");
                unite = sc.nextLine();
                System.out.println("Merci de saisir la quantite de l'ingredient: ");
                quantite = sc.nextInt();
                ingredient = new Ingredient(idIngredient, nomIngredient, etat, unite, quantite);
                System.out.println("L'ingédient a bien ete ajouté");
                System.out.println("Ajouter un autre ingredient? (O/N)");
                reponse = sc.nextLine();
            }
        }


        Plat plat = new Plat(idPlat, nomPlat, ingredients);
        System.out.println("Le plat a bien ete ajoute");
        System.out.println();
    }

    //3- Supprimer un plat
    private void supprimerPlat(){
        System.out.println("==== Supprimer un plat ====");
        System.out.println();
        System.out.println("Merci de selectionner le plat a supprimer: ");
        int choix = sc.nextInt();
        if (choix == plat.getIdPlat()){
            plat = null;
        }
    }
    private void quitter(){
        System.out.println("Merci et a bientot");
        continuer = false;
    }

    public void demarrer() {
        while (continuer) {
            afficherMenu();
            int choix = sc.nextInt();
            switch (choix) {
                case 1:
                    afficherPlats();
                    break;
                case 2:
                    ajouterPlat();
                    break;
                case 3:
                    supprimerPlat();
                    break;
                case 0:
                    quitter();
                    break;
                default:
                    System.out.println("Choix incorrect");
            }
        }
    }
}


