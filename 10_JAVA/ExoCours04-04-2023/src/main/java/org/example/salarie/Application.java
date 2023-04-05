package org.example.salarie;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.example.salarie.Salarie.*;

public class Application {


    public static void main(String[] args) {

        List tabSalarie = new ArrayList();
        tabSalarie.add(
                new Salarie("Jean", "A", "Commercial", "S001", 1500.0));
        new Commercial("C001", "A", "Commercial", "Jean", 1500.0, 0, 0.0, 0.0F);
        new Manager("M002", "B", "Comptabilité", "Pierre", 2500.0, 0, 0.2, 0.0F);

        Scanner sc = new Scanner(System.in);
        System.out.println("===== Gestion des salariés =====");
        System.out.println("1. Ajouter un salarié");
        System.out.println("2. Afficher le salaire des salariés");
        System.out.println("3. Rechercher un salarié");
        System.out.println("4. Quitter");

        double sommeSalaire = 0;
        int choix = sc.nextInt();

        switch (choix) {
            case 1:
                System.out.println("Ajouter un salarié");
                break;
            case 2:
                System.out.println("Afficher le salaire des salariés");
                break;
            case 3:
                System.out.println("Rechercher un salarié");
                break;
            case 4:
                System.out.println("Quitter");
                break;
            default:
                System.out.println("Choix incorrect");
                break;
        }


        double salaire = 0;


        double chiffreAffaire = 0;

        Salarie salarie = new Salarie();
        Commercial commercial = new Commercial();
        if (choix == 1) {
            System.out.println("=== Ajouter un salarié ===");
            System.out.println("1. Salarié");
            System.out.println("2. Commercial");
            System.out.println("0. Retour");
            System.out.println("Entrez votre choix : ");
            int choix2 = sc.nextInt();
            salaire = 0;
            if (choix2 == 1) {
                System.out.println("=== Ajouter un salarié ===");
                System.out.println("Nom : ");
                String nom = sc.next();
                System.out.println("Matricule : ");
                String matricule = sc.next();
                System.out.println("Catégorie : ");
                String categorie = sc.next();
                System.out.println("Service : ");
                String service = sc.next();
                System.out.println("Salaire : ");
                salaire = sc.nextDouble();
                salarie = new Salarie(nom, matricule, categorie, service, salaire);
                tabSalarie.add(salarie);
                salarie.afficherSalaire();
            } else if (choix2 == 2) {
                System.out.println("=== Ajouter un commercial ===");
                System.out.println("Nom : ");
                String nom = sc.next();
                System.out.println("Matricule : ");
                String matricule = sc.next();
                System.out.println("Catégorie : ");
                String categorie = sc.next();
                System.out.println("Service : ");
                String service = sc.next();
                System.out.println("Salaire : ");
                salaire = sc.nextDouble();
                System.out.println("Déplacement  : ");
                String deplacement = sc.next();
                if (deplacement.equals("oui")) {
                    distance += 1000;
                    System.out.println("Distance : " + distance + " km");
                } else {
                    System.out.println("Distance : 0");
                    int distance = 0;
                }
                System.out.println("Chiffre d'affaire : ");
                chiffreAffaire = sc.nextDouble();
                System.out.println("Commission en % : ");
                float commission = sc.nextFloat();
                commission = commission / 100;
                commercial = new Commercial(matricule, categorie, service, nom, salaire, distance, chiffreAffaire, commission);
                tabSalarie.add(commercial);
                commercial.afficher();
                commercial.seDeplacer();
                commercial.afficherSalaire();
                commercial.calculerSalaireCom();
            } else if (choix2 == 0) {
                System.out.println("Retour");
            } else {
                System.out.println("Choix incorrect");
            }
        } else if (choix == 2) {
            System.out.println("==== Afficher le salaire des salariés ====");
            System.out.println("Le salarié " + nom + " a un salaire de : " + salaire + " € ");
            if (chiffreAffaire > 0) {
                commercial.afficherSalaire();
            } else {
                salarie.afficherSalaire();
            }
        }
        else if (choix == 3) {
            System.out.println("Rechercher un salarié");
            System.out.println("==== Rechercher un salarié par nom ====");
            System.out.println("Merci de saisir le nom du salarié : ");
            String nom = sc.next();
            System.out.println("Le salarié " + nom + " a un salaire de : " + salaire + " € ");
            if (chiffreAffaire > 0) {
                commercial.afficherSalaire();
        } else {
            salarie.afficherSalaire();
        }
    } else if (choix == 4) {
            System.out.println("Quitter");
        } else {
            System.out.println("Choix incorrect");
        }

    }
}

