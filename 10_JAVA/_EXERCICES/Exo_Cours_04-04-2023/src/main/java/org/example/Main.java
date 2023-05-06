package org.example;

import org.example.house.House;
import org.example.personne.Person;

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




//
//        Tp Banque
//        System.out.println("Bienvenue dans votre banque");
//        System.out.println("merci de faire votre choix");
//        System.out.println("1- Compte simple");
//        System.out.println("2- Compte payant");
//        System.out.println("3- Compte épargne");
//        System.out.println("4- Quitter");
//        System.out.println("Votre choix : ");
//        Scanner sc = new Scanner(System.in);
//        int choix = sc.nextInt();
//        double retrait;
//
//        switch (choix) {
//            case 1:
//                System.out.println("--------------- Affichage d'un nouveau compte Simple ---------------");
//                CompteSimple compteSimple = new CompteSimple(1000, 500);
//                //affichage du compte avec chaque opération
//                System.out.println("Solde du compte : " + compteSimple.getSolde());
//                System.out.println("Montant du découvert autorisé : " + compteSimple.getDecouvert());
//                System.out.println();
//                System.out.println("Saisir le montant du versement :");
//                double versement = sc.nextDouble();
//                compteSimple.versement(versement );
//                System.out.println("versement de " + versement);
//                System.out.println("Solde du compte : " + compteSimple.getSolde());
//                System.out.println();
//                System.out.println("Saisir le montant du retrait :");
//                retrait = sc.nextDouble();
//                compteSimple.retrait(retrait);
//                System.out.println("retrait de " + retrait);
//                if (compteSimple.getSolde() > 0) {
//                    System.out.println("Solde du compte : " + compteSimple.getSolde());
//                } else {
//                    System.out.println("Vous avez dépassé votre découvert autorisé");
//                }
//                System.out.println();
//                break;
//            case 2:
//                System.out.println("--------------- Affichage d'un nouveau compte Payant ---------------");
//                ComptePayant comptePayant = new ComptePayant(1000, 500, 1000);
//                System.out.println("Solde du compte : " + comptePayant.getSolde());
//                System.out.println("Montant du découvert autorisé : " + comptePayant.getDecouvert());
//                System.out.println();
//                System.out.println("Saisir le montant du versement :");
//                versement = sc.nextDouble();
//                comptePayant.versement(versement);
//                System.out.println("versement de " + versement);
//                System.out.println("Solde du compte : " + comptePayant.getSolde());
//                System.out.println();
//                System.out.println("Saisir le montant du retrait :");
//                retrait = sc.nextDouble();
//                comptePayant.retrait(retrait);
//                System.out.println("retrait de " + retrait);
//                if (comptePayant.getSolde() > 0) {
//                    System.out.println("Solde du compte : " + comptePayant.getSolde());
//                } else {
//                    System.out.println("Vous avez dépassé votre découvert autorisé");
//                }
//                System.out.println();
//                break;
//            case 3:
//                System.out.println("--------------- Affichage d'un nouveau compte Epargne ---------------");
//                CompteEpargne compteEpargne = new CompteEpargne(1000, 500, 1000);
//                System.out.println("Solde du compte : " + compteEpargne.getSolde());
//                System.out.println("Montant du découvert autorisé : " + compteEpargne.getDecouvert());
//                System.out.println();
//                System.out.println("Saisir le montant du versement :");
//                versement = sc.nextDouble();
//                compteEpargne.versement(versement);
//                System.out.println("versement de " + versement);
//                System.out.println("Solde du compte : " + compteEpargne.getSolde());
//                System.out.println();
//                System.out.println("Saisir le montant du retrait :");
//                retrait = sc.nextDouble();
//                System.out.println("retrait de " + retrait);
//                if (compteEpargne.getSolde() > 0) {
//                    System.out.println("Solde du compte : " + compteEpargne.getSolde());
//                } else {
//                    System.out.println("Vous avez dépassé votre découvert autorisé");
//                }
//                System.out.println();
//                break;
//            case 4:
//                System.out.println("Au revoir");
//                break;
//
//        }


//         Tp Personne
//
//        Person p1 = new Person("Doe", "John", 25);
//
//        p1.SayHello();
//
//        System.out.println();
//
//        Student Student1 = new Student("Doey", "Tony", 15);
//        Student1.SayHello();
//        Student1.GoToClasses();
//        Student1.DisplayAge();
//        System.out.println();
//
//        Teacher Teacher1 = new Teacher("Newton", "John",40, "Maths");
//        Teacher1.SayHello();
//        Teacher1.Explain();
//        System.out.println( );


        // tp House

        Person p1 = new Person("Thomas");
        House Appartement = new House(50, 1 , "Verte");
        System.out.println("Je m'appelle "+ p1.getName() );
        Appartement.DisplayHouse();
        Appartement.DisplayDoor();






    }
}