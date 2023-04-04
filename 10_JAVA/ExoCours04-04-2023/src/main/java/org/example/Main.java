package org.example;

import org.example.TpClasseChaise.Chaise;
import org.example.heritage.CompteEpargne;
import org.example.heritage.ComptePayant;
import org.example.heritage.CompteSimple;

import java.util.Scanner;

import static sun.security.pkcs.PKCS9Attribute.getName;

public class Main {
    public static void main(String[] args) {

//        System.out.println("--------------- Affichage d'un nouvel objet ---------------");
//        System.out.println();
//        String nbrePieds;
//        Chaise chaise = new Chaise("bleue", 4, "bois");
//        System.out.println("Je suis une Chaise  avec " + chaise.getNbrePieds() + " pieds en " + chaise.getMateriaux() + " de couleur " + chaise.getCouleur());
//        System.out.println( "---------------------------------------------------------------");
//        System.out.println();
//        System.out.println("--------------- Affichage d'un nouvel objet ---------------");
//        System.out.println();
//        Chaise chaise1 = new Chaise("blanche", 4, "métal");
//        System.out.println("Je suis une Chaise  avec " + chaise1.getNbrePieds() + " pieds en " + chaise1.getMateriaux() + " de couleur " + chaise1.getCouleur());
//        System.out.println( "---------------------------------------------------------------");
//        System.out.println();
//        System.out.println("--------------- Affichage d'un nouvel objet ---------------");
//        System.out.println();
//        Chaise chaise2 = new Chaise("transparente", 1, "plexiglass");
//        System.out.println("Je suis une Chaise  avec " + chaise2.getNbrePieds() + " pieds en " + chaise2.getMateriaux() + " de couleur " + chaise2.getCouleur());
//        System.out.println( "---------------------------------------------------------------");
//        System.out.println();
        System.out.println("Bienvenue dans votre banque");
        System.out.println("merci de faire votre choix");
        System.out.println("1- Compte simple");
        System.out.println("2- Compte payant");
        System.out.println("3- Compte épargne");
        System.out.println("4- Quitter");
        System.out.println("Votre choix : ");
        Scanner sc = new Scanner(System.in);
        int choix = sc.nextInt();
        switch (choix) {
            case 1:
                System.out.println("--------------- Affichage d'un nouveau compte Simple ---------------");
                CompteSimple compteSimple = new CompteSimple(1000, 500);
                //affichage du compte avec chaque opération
                System.out.println("Solde du compte : " + compteSimple.getSolde());
                System.out.println("Montant du découvert autorisé : " + compteSimple.getDecouvert());
                System.out.println();
                compteSimple.versement(1000);
                System.out.println("versement de 1000");
                System.out.println("Solde du compte : " + compteSimple.getSolde());
                System.out.println();
                compteSimple.retrait(2000);
                System.out.println("retrait de 2000");
                System.out.println("Solde du compte : " + compteSimple.getSolde());
                System.out.println();
                break;
            case 2:
                System.out.println("--------------- Affichage d'un nouveau compte Payant ---------------");
                ComptePayant comptePayant = new ComptePayant(1000, 500);
                //affichage du compte avec chaque opération
                System.out.println("Solde du compte : " + comptePayant.getSolde());
//                System.out.println("Montant du découvert autorisé : " + comptePayant.getDecouvert());
//                System.out.println();
                comptePayant.versement(1000);
                System.out.println("versement de 1000");
                System.out.println("Solde du compte : " + comptePayant.getSolde());
                System.out.println();
                comptePayant.retrait(2000);
                System.out.println("retrait de 2000");
                System.out.println("Solde du compte : " + comptePayant.getSolde());
                System.out.println();
                break;
            case 3:
                System.out.println("--------------- Affichage d'un nouveau compte Epargne ---------------");
                CompteEpargne compteEpargne = new CompteEpargne(1000, 500);
                //affichage du compte avec chaque opération
                System.out.println("Solde du compte : " + compteEpargne.getSolde());
//                System.out.println("Montant du découvert autorisé : " + compteEpargne.getDecouvert());
                System.out.println();
                compteEpargne.versement(1000);
                System.out.println("versement de 1000");
                System.out.println("Solde du compte : " + compteEpargne.getSolde());
                System.out.println();
                compteEpargne.retrait(2000);
                System.out.println("retrait de 2000");
                System.out.println("Solde du compte : " + compteEpargne.getSolde());
                System.out.println();
                break;
            case 4:
                System.out.println("Au revoir");
                break;

        }
    }
}