package org.example.ihm;

import org.example.dao.impl.AssociationDaoImpl;
import org.example.dao.impl.CommentDaoImpl;
import org.example.dao.impl.IngredientDaoImpl;
import org.example.dao.impl.RecipeDaoImpl;
import org.example.entity.Association;
import org.example.entity.Comment;
import org.example.entity.Ingredient;
import org.example.entity.Recipe;
import org.example.service.impl.AssociationServiceImpl;
import org.example.service.impl.CommentServiceImpl;
import org.example.service.impl.IngredientServiceImpl;
import org.example.service.impl.RecipeServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;


public class IHM {
    Scanner scanner;
    String choix;
    private RecipeServiceImpl recipeService;
    private IngredientServiceImpl ingredientService;
    private CommentServiceImpl commentService;
    private AssociationServiceImpl associationService;
    private CommentDaoImpl commentDao;
    private AssociationDaoImpl associationDao;
    private RecipeDaoImpl recipeDao;
    private IngredientDaoImpl ingredientDao;

    public IHM() {
        this.scanner = new Scanner(System.in);
        this.choix = "";
    }

    private void menu() {
        System.out.println("*************  Tp Recette *************");
        System.out.println("1.  Afficher les ingrédients");
        System.out.println("2.  Ajouter un ingrédient");
        System.out.println("3.  Ajouter un ingrédient à une recette");
        System.out.println("4.  Supprimer un ingrédient");
        System.out.println("5.  Afficher  les recettes");
        System.out.println("6.  Ajouter une recette");
        System.out.println("7.  Modifier une recette");
        System.out.println("8.  Supprimer une recette");
        System.out.println("9.  Afficher les commentaires");
        System.out.println("10.  Ajouter un commentaire");
        System.out.println("11. Supprimer un commentaire");
        System.out.println("12. Modifier un commentaire");
        System.out.println("0.  Quitter");
    }

    public void start() throws SQLException {
        do {
            menu();
            choix = scanner.nextLine();
            switch (choix) {
                case "1" -> getAllIngredients();
                case "2" -> createIngredients();
                case "3" -> createAssociation();
                case "4" -> deleteIngredients();
                case "5" -> getAllRecipes();
                case "6" -> createRecipes();
                case "7" -> updateRecipes();
                case "8" -> deleteRecipes();
                case "9" -> getAllComments();
                case "10" -> createComments();
                case "11" -> deleteComments();
                case "12" -> updateComments();
                case "0" -> System.out.println("Quitter");
                default -> System.out.println("Choix non valide");
            }
        } while (!choix.equals("0"));
    }

    private void createAssociation() throws SQLException {
        System.out.println("Ajouter un ingrédient à une recette");
        System.out.println("Liste des recettes : ");
        recipeService = new RecipeServiceImpl();
        try {
            recipeService.getAllRecipes().forEach(recipe -> System.out.println("idRecipe : " + recipe.getIdRecipe() + "\n" + "nom : " + recipe.getNameRecipe() + "\n" + "description : " + recipe.getDescription() + "\n"));
            if (recipeService.getAllRecipes().isEmpty()) {
                System.out.println("Il n'y a pas de recette");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Saisir l'id de la recette : ");
        int idRecipe = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Liste des ingrédients : ");
        ingredientService = new IngredientServiceImpl();
        try {
            ingredientService.getAllIngredients().forEach(ingredient -> System.out.println("idIngredient : " + ingredient.getIdIngredient() + "\n" + "nom : " + ingredient.getName() + "\n" + "unité : " + ingredient.getUnity() + "\n"));
            if (ingredientService.getAllIngredients().isEmpty()) {
                System.out.println("Il n'y a pas d'ingredient");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Saisir l'id de l'ingrédient : ");
        int idIngredient = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir la quantité de l'ingrédient : ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        AssociationServiceImpl associationService = new AssociationServiceImpl();
        Association association = Association.builder().idRecipe(idRecipe).idIngredient(idIngredient).quantity(quantity).build();
        associationService.save(association);
        System.out.println("Association ajoutée");
    }

    //1- Afficher tous les ingrédients
    private void getAllIngredients() throws SQLException {
        System.out.println("Afficher tous les ingredients");
        IngredientServiceImpl ingredientService;
        ingredientService = new IngredientServiceImpl();
        try {
            ingredientService.getAllIngredients().forEach(ingredient -> System.out.println("idIngredient : " + ingredient.getIdIngredient() + "\n" + "nom : " + ingredient.getName() + "\n" + "unité : " + ingredient.getUnity() + "\n"));
            if (ingredientService.getAllIngredients().isEmpty()) {
                System.out.println("Il n'y a pas d'ingredient");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //2- Ajouter un ingrédient
    private void createIngredients() throws SQLException {
        System.out.println("Ajouter un ingredient");
        System.out.println("Saisir le nom de l'ingredient : ");
        String nameIngredient = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Saisir l'unité de mesure pour cet ingredient (ex: Kg, Litre, cl ..) : ");
        String unity = scanner.nextLine();
        scanner.nextLine();
        IngredientServiceImpl ingredientService = new IngredientServiceImpl();
        Ingredient ingredient = Ingredient.builder().idIngredient(1).name(nameIngredient).unity(unity).build();
        ingredientService.save(ingredient);
        System.out.println("Ingredient ajouté");
    }

    //3- Supprimer un ingrédient
    private void deleteIngredients() throws SQLException {
        System.out.println("Supprimer un ingredient");
        System.out.println("Saisir l'id de l'ingredient à supprimer : ");
        int idIngredient = scanner.nextInt();
        scanner.nextLine();
        IngredientServiceImpl ingredientService = new IngredientServiceImpl();
        Ingredient ingredient = ingredientService.get(idIngredient);
        if (ingredient != null) {
            ingredientService.delete(idIngredient);
            System.out.println("Ingredient supprimé");
        } else {
            System.out.println("L'ingredient n'existe pas");
        }
    }

    //4- Afficher toutes les recettes
    private void getAllRecipes() throws SQLException {
        System.out.println("Afficher toutes les recettes");
        RecipeServiceImpl recipeService = new RecipeServiceImpl();
        if (recipeService.getAllRecipes() != null) {
            recipeService.getAllRecipes().forEach(recipe -> System.out.println("id Recette : " + recipe.getIdRecipe() + "\n" + "nom : " + recipe.getNameRecipe() + "\n" + "nombre de personne : " + recipe.getNbPerson() + "\n" + "temps de préparation : " + recipe.getPreparationTime() + "\n" + "temps de cuisson : " + recipe.getCookingTime() + "\n" + "description : " + recipe.getDescription() + "\n" + "difficulté : " + recipe.getDifficulty() + "\n"));
        } else {
            System.out.println("Il n'y a pas de recette");
        }
    }


    //5- Ajouter une recette
    private void createRecipes() throws SQLException {
        boolean isSave = false;
        System.out.println("Ajouter une recette");
        System.out.println("Saisir le nom de la recette : ");
        String nameRecipe = scanner.nextLine();
        System.out.println("Saisir le nombre de personne : ");
        int nbPerson = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir le temps de préparation (Minute): ");
        int preparationTime = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir le temps de cuisson (Minute) : ");
        int cookingTime = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir la difficulté (de 1 à 5) : ");
        int difficulty = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir la description : ");
        String description = scanner.nextLine();
        RecipeServiceImpl recipeService = new RecipeServiceImpl();
        Recipe recipe = Recipe.builder().idRecipe(1).nameRecipe(nameRecipe).nbPerson(nbPerson).preparationTime(preparationTime).cookingTime(cookingTime).difficulty(difficulty).description(description).build();
        recipeService.save(recipe);
        isSave = true;
        System.out.println("Recette ajoutée");
        System.out.println("voulez vous ajouter un  ingredient à la recette ? (O/N)");
        String reponse = scanner.nextLine();
        if (reponse.equals("O")) {
            addIngredientToRecipe();
        } else {
            System.out.println("Fin de l'ajout des ingredients");
        }
        if (isSave) {
            System.out.println("Recette ajoutée");
        } else {
            System.out.println("Erreur lors de l'ajout de la recette");
        }
    }

    //6- Modifier une recette
    private void updateRecipes() {
        System.out.println("Modifier une recette");
        System.out.println("Saisir l'id de la recette à modifier : ");
        int idRecipe = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir le nouveau nom de la recette : ");
        String nameRecipe = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Saisir la nouvelle description de la recette : ");
        String description = scanner.nextLine();
        scanner.nextLine();
        System.out.println("Saisir la nouvelle difficulté de la recette : ");
        int difficulty = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir le nouveau temps de préparation de la recette : ");
        int preparationTime = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir le nouveau temps de cuisson de la recette : ");
        int cookingTime = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir le nouveau nombre de personnes pour cette  recette : ");
        int nbPerson = scanner.nextInt();
        scanner.nextLine();
        RecipeServiceImpl recipeService = new RecipeServiceImpl();
        Recipe recipe = recipeService.getRecipe(idRecipe);
        if (recipe != null) {
            recipe = Recipe.builder().idRecipe(idRecipe).nameRecipe(nameRecipe).description(description).difficulty(difficulty).preparationTime(preparationTime).cookingTime(cookingTime).nbPerson(nbPerson).build();
            recipeService.updateRecipe(recipe);
            System.out.println("Recette modifiée");
        } else {
            System.out.println("La recette n'existe pas");
        }
    }

    //7- Supprimer une recette
    private void deleteRecipes() {
        System.out.println("Supprimer une recette");
        System.out.println("Saisir l'id de la recette à supprimer : ");
        int idRecipe = scanner.nextInt();
        RecipeServiceImpl recipeService = new RecipeServiceImpl();
        recipeService.deleteRecipe(idRecipe);
        if (recipeService.getRecipe(idRecipe) == null) {
            System.out.println("Recette supprimée");
        } else {
            System.out.println("Erreur lors de la suppression de la recette");
        }
    }

    //8- Afficher tous les commentaires
    private void getAllComments() {
        System.out.println("Afficher tous les commentaires");
        CommentServiceImpl commentService;
        try {
            commentService = new CommentServiceImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (commentService.findAll().isEmpty()) {
            System.out.println("Il n'y a pas de commentaire");
        } else {
            commentService.findAll().forEach(System.out::println);
        }
    }

    //9- Ajouter un commentaire
    private void createComments() {
        System.out.println("Ajouter un commentaire");
        System.out.println("Selectionner la recette à commenter : ");
        RecipeServiceImpl recipeService = new RecipeServiceImpl();
        try {
            recipeService.getAllRecipes().forEach(recipe -> System.out.println("Recette : " + recipe.getNameRecipe() + " - Nb Personne : " + recipe.getNbPerson() + " - Temps prepa : " + recipe.getPreparationTime() + " - Temps Cuisson : " + recipe.getCookingTime() + " - Niveau Difficulté : " + recipe.getDifficulty() + " - " + recipe.getDescription()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Saisir l'id de la recette à commenter : ");
        int idRecipe = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir le commentaire : ");
        String comment = scanner.nextLine();
        CommentServiceImpl commentService = null;
        try {
            commentService = new CommentServiceImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        Comment comment1 = Comment.builder().idComment(1).content(comment).idRecipe(idRecipe).build();
        commentService.create(comment1);
        System.out.println("Commentaire ajouté");

    }

    //10- Supprimer un commentaire
    private void deleteComments() {
        System.out.println("Supprimer un commentaire");
        CommentServiceImpl commentService = null;
        try {
            commentService = new CommentServiceImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (commentService.findAll().isEmpty()) {
            System.out.println("Il n'y a pas de commentaire");
        } else {
            commentService.findAll().forEach(System.out::println);
        }
        System.out.println("Saisir l'id du commentaire à supprimer : ");
        int idComment = scanner.nextInt();
        scanner.nextLine();
        try {
            commentService = new CommentServiceImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            commentService.delete(idComment);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (commentService.findById(idComment) == null) {
            System.out.println("Commentaire supprimé");
        } else {
            System.out.println("Erreur lors de la suppression du commentaire");
        }
    }

    //7- Supprimer une recette

    //11- Modifier un commentaire
    private void updateComments() throws SQLException {
        System.out.println("Modifier un commentaire");
        System.out.println("Saisir l'id du commentaire à modifier : ");
        int idComment = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Saisir le nouveau commentaire : ");
        String content = scanner.nextLine();
        CommentServiceImpl commentService = new CommentServiceImpl();
        Comment comment = commentService.findById(idComment);
        if (comment != null) {
            comment = Comment.builder().idComment(idComment).content(content).idRecipe(comment.getIdRecipe()).build();
            commentService.update(comment);
        }
        if (commentService.findById(idComment) != null) {
            System.out.println("Commentaire modifié");
        } else {
            System.out.println("Erreur lors de la modification du commentaire");
        }
    }


    public void addIngredientToRecipe() throws SQLException {
        System.out.println("Ajouter un ingredient à une recette");
        System.out.println("Liste des ingredients :");
        IngredientServiceImpl ingredientService;
        ingredientService = new IngredientServiceImpl();
        ingredientService.getAllIngredients().forEach(ingredient -> System.out.println("Ingredient :  id :  " + ingredient.getIdIngredient() + " " + ingredient.getName() + " - Quantité : " + " - Unité : " + ingredient.getUnity()));
        System.out.println("L'ingredient est-il déjà dans la base de données ? (O/N)");
        String answer = scanner.nextLine();
        if (answer.equals("O")) {
            System.out.println("Saisir l'id de l'ingredient à ajouter à la recette  : ");
            int idIngredient = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Saisir la quantité : ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Liste des recettes :");
            RecipeServiceImpl recipeService = new RecipeServiceImpl();
            recipeService.getAllRecipes().forEach(recipe -> System.out.println("Recette :  id :  " + recipe.getIdRecipe() + " " + recipe.getNameRecipe() + " - Nb Personne : " + recipe.getNbPerson() + " - Temps prepa : " + recipe.getPreparationTime() + " - Temps Cuisson : " + recipe.getCookingTime() + " - Niveau Difficulté : " + recipe.getDifficulty() + " - " + recipe.getDescription()));
            System.out.println("Saisir l'id de la recette pour l'ajout : ");
            int idRecipe = scanner.nextInt();
            scanner.nextLine();
            recipeService = new RecipeServiceImpl();
            Recipe recipe = recipeService.getRecipe(idRecipe);
            ingredientService = new IngredientServiceImpl();
            Ingredient ingredient;
            ingredient = ingredientService.get(idIngredient);
            if (recipe != null && ingredient != null) {
                AssociationServiceImpl associationService = new AssociationServiceImpl();
                Association association = Association.builder().idRecipe(idRecipe).idIngredient(idIngredient).quantity(quantity).build();
                associationService.save(association);
                System.out.println("Ingredient ajouté à la recette");
            } else {
                System.out.println("Erreur lors de l'ajout de l'ingredient à la recette");
            }
        } else {
            System.out.println("Merci de créer un ingrédient :");
            createIngredients();
            System.out.println("Saisir la quantité : ");
            int quantity = scanner.nextInt();
            scanner.nextLine();
            RecipeServiceImpl recipeService = new RecipeServiceImpl();
            Recipe recipe = recipeService.getRecipe(recipeService.getLastId());
            recipe = recipeService.getRecipe(recipe.getIdRecipe());
            ingredientService = new IngredientServiceImpl();
            Ingredient ingredient = ingredientService.get(ingredientService.getLastId());
            ingredient = ingredientService.get(ingredient.getIdIngredient());
            if (ingredient != null) {
                AssociationServiceImpl associationService = new AssociationServiceImpl();
                Association association = Association.builder().idRecipe(recipe.getIdRecipe()).idIngredient(ingredient.getIdIngredient()).quantity(quantity).build();
                associationService.save(association);
                System.out.println("Ingredient ajouté à la recette");
            }
            System.out.println("voulez vous ajouter un autre ingredient à la recette ? (O/N)");
            String answer2 = scanner.nextLine();
            if (answer2.equals("O")) {
                addIngredientToRecipe();
            } else {
                System.out.println("Retour au menu principal");
                menu();
            }
        }
    }
}