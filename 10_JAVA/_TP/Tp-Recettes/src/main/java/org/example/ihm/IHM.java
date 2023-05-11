package org.example.ihm;

import org.example.dao.impl.CommentDaoImpl;
import org.example.dao.impl.IngredientDaoImpl;
import org.example.dao.impl.LiaisonDaoImpl;
import org.example.dao.impl.RecipeDaoImpl;
import org.example.entity.Recipe;
import org.example.service.impl.CommentServiceImpl;
import org.example.service.impl.IngredientServiceImpl;
import org.example.service.impl.LiaisonServiceImpl;
import org.example.service.impl.RecipeServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class IHM {
Scanner scanner;
String choix;

private RecipeServiceImpl recipeService;

private IngredientServiceImpl ingredientService;

private CommentServiceImpl commentService;

private LiaisonServiceImpl liaisonService;

private CommentDaoImpl commentDao;

private RecipeDaoImpl recipeDao;

private IngredientDaoImpl ingredientDao;

private LiaisonDaoImpl liaisonDao;


public IHM() {
    this.scanner = new Scanner(System.in);
    this.choix = "";
}


private void menu(){
    System.out.println("*************  Tp Recette *************");
    System.out.println("1. Ajouter une recette");
    System.out.println("2. Afficher les recettes");
    System.out.println("3. Supprimer une recette");
    System.out.println("4. Modifier une recette");
    System.out.println("5.Ajouter un ingredient");
    System.out.println("6. Afficher les ingredients");
    System.out.println("7. Supprimer un ingredient");
    System.out.println("8. Modifier un ingredient");
    System.out.println("9. Ajouter un commentaire");
    System.out.println("10. Afficher les commentaires");
    System.out.println("11. Supprimer un commentaire");
    System.out.println("12. Modifier un commentaire");
    System.out.println("0. Quitter"
    );
}
public void start() throws SQLException {
    do {
        menu();
        choix = scanner.nextLine();
        switch (choix) {
            case "1":
                createRecipes();
                break;
            case "2":
                showRecipes();
                break;
            case "3":
                System.out.println("Supprimer une recette");
                break;
            case "4":
                System.out.println("Modifier une recette");
                break;
            case "5":
                System.out.println("Ajouter un ingredient");
                break;
            case "6":
                System.out.println("Afficher les ingredients");
                break;
            case "7":
                System.out.println("Supprimer un ingredient");
                break;
            case "8":
                System.out.println("Modifier un ingredient");
                break;
            case "9":
                System.out.println("Ajouter un commentaire");
                break;
            case "10":
                System.out.println("Afficher les commentaires");
                break;
            case "11":
                System.out.println("Supprimer un commentaire");
                break;
            case "12":
                System.out.println("Modifier un commentaire");
                break;
            case "0":
                System.out.println("Quitter");
                break;
            default:
                System.out.println("Choix non valide");
                break;
        }
    }
    while (!choix.equals("0"));
}

    private void showRecipes() throws SQLException {
        System.out.println("Liste des recettes :");
        RecipeServiceImpl recipeService = new RecipeServiceImpl();
        recipeService.getAllRecipes().forEach(System.out::println);
    }

    private void createRecipes() throws SQLException {
        System.out.println("Ajouter une recette");
        System.out.println("Nom de la recette : ");
        String nameRecipe = scanner.nextLine();
        System.out.println("Nombre de personnes : ");
        int nbPerson = scanner.nextInt();
        System.out.println("Temps de préparation : ");
        int preparationTime = scanner.nextInt();
        System.out.println("Temps de cuisson : ");
        int cookingTime = scanner.nextInt();
        System.out.println("Difficulté : ");
        int difficulty = scanner.nextInt();
        System.out.println("Description : ");
        String description = scanner.nextLine();
        RecipeServiceImpl recipeService = new RecipeServiceImpl();
        Recipe recipe = Recipe.builder()
                .idRecipe(1)
                .nameRecipe(nameRecipe)
                .nbPerson(nbPerson)
                .preparationTime(preparationTime)
                .cookingTime(cookingTime)
                .difficulty(difficulty)
                .description(description).build();
        recipeService.save(recipe);


    }


}
