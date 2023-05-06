package org.example.ex113;

import org.example.ex113.enums.Etat;
import org.example.ex113.enums.Unite;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Plat plat1 = new Plat(1, "Choucroute", new Ingredient[]{new Ingredient(1, "Choucroute", Etat.CRU, Unite.GRAMME, 500), new Ingredient(2, "Saucisse", Etat.CRU, Unite.UNITE, 2), new Ingredient(3, "Lard", Etat.CUIT, Unite.GRAMME, 150),});
        Plat plat2  = new Plat( 2, "Couscous", new Ingredient[]{new Ingredient(4, "Couscous", Etat.CRU, Unite.KILOGRAMME, 2), new Ingredient(5, "Tomaque", Etat.CRU, Unite.KILOGRAMME, 1), new Ingredient(6, "Oignon", Etat.CRU, Unite.KILOGRAMME, 1), new Ingredient(7, "Poulet", Etat.ENTIER, Unite.UNITE, 1), new Ingredient(8, "Merguez", Etat.ENTIER, Unite.UNITE, 7),});
        Ihm ihm = new Ihm();
        ihm.demarrer();

    }
}
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        List<Plat> plats = List.of(new Plat(1, "Choucroute", new Ingredient[]{new Ingredient(1, "Choucroute", Etat.CRU, Unite.GRAMME, 500), new Ingredient(2, "Saucisse", Etat.CRU, Unite.UNITE, 2), new Ingredient(3, "Lard", Etat.CUIT, Unite.GRAMME, 150),}), new Plat(2, "Couscous", new Ingredient[]{new Ingredient(4, "Couscous", Etat.CRU, Unite.KILOGRAMME, 2), new Ingredient(5, "Tomaque", Etat.CRU, Unite.KILOGRAMME, 1), new Ingredient(6, "Oignon", Etat.CRU, Unite.KILOGRAMME, 1), new Ingredient(7, "Poulet", Etat.ENTIER, Unite.UNITE, 1), new Ingredient(8, "Merguez", Etat.ENTIER, Unite.UNITE, 7),}));
//
//
//        System.out.println("Affichage du plat");
//        System.out.println("Merci de selectionner le plat à afficher : ");
//
//        for (Plat plat : plats) {
//            System.out.println("- " + plat.getId() + "." + plat.getNom());
//        }
//        System.out.println("Votre choix : ");
//        String choixPlat = scanner.nextLine();
//        for (Plat plat : plats) {
//            if (plat.getId() == Integer.parseInt(choixPlat)) {
//                plat.afficher();
//            }
//        }
//        System.out.println("Faut-il cuire un ingrédient ? : ");
//        System.out.println("1- Oui");
//        System.out.println("2- Non");
//        String choixCuisson = scanner.nextLine();
//        System.out.println("Quel ingrédient faut-il cuire ? : ");
//        System.out.println("Ingredients: ");
//        if (choixCuisson.equals("1")) {
//            for (Plat plat : plats) {
//                if (plat.getId() == Integer.parseInt(choixPlat)) {
//                    for (Ingredient ingredient : plat.getIngredients()) {
//                        System.out.println(ingredient.getId() + "-" + ingredient.getNom_aliment());
//                    }
//                    int choixIngredient = scanner.nextInt();
//                    for (Plat platCuit : plats) {
//                        if (plat.getId() == Integer.parseInt(choixPlat)) {
//                            for (Ingredient ingredient : plat.getIngredients()) {
//                                if (ingredient.getId() == choixIngredient) {
//                                    ingredient.cuire();
//                                }
//                                System.out.println(ingredient.getNom_aliment() + " " + ingredient.getEtat());
//                            }
//                        }
//                    }
//                }
//            }
//        } else if (choixCuisson.equals("2")) {
//            System.out.println("Faut-il découper un ingrédient ? : ");
//            System.out.println("1- Oui");
//            System.out.println("2- Non");
//            String choixDecoupe = scanner.nextLine();
//            if (choixDecoupe.equals("1")) {
//                System.out.println("Ingredients:");
//                for (Plat platD : plats) {
//                    if (platD.getId() == Integer.parseInt(choixPlat)) {
//                        for (Ingredient ingredient : platD.getIngredients()) {
//                            System.out.println(ingredient.getId() + "-" + ingredient.getNom_aliment());
//                        }
//                        int choixIngredientDecoupe = scanner.nextInt();
//                        for (Plat platDecoupe : plats) {
//                            if (platD.getId() == Integer.parseInt(choixPlat)) {
//                                for (Ingredient ingredient : platD.getIngredients()) {
//                                    if (ingredient.getId() == choixIngredientDecoupe) {
//                                        ingredient.decouper();
//                                    }
//                                    System.out.println(ingredient.getNom_aliment() + " " + ingredient.getEtat());
//                                }
//                            }
//                        }
//                    }
//                }
//            } else if (choixDecoupe.equals("2")) {
//                System.out.println("Merci de choisir un plat");
//                System.out.println("Liste des plats : ");
//                for (Plat plat : plats) {
//                    System.out.println(plat.getId() + "-" + plat.getNom());
//                }
//                System.out.println("Votre choix : ");
//                String choixPlat2 = scanner.nextLine();
//                for (Plat plat : plats) {
//                    if (plat.getId() == Integer.parseInt(choixPlat2)) {
//                        plat.afficher();
//                    }
//                }
//            }
//        }
//    }
//}
