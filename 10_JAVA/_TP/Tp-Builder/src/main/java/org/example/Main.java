package org.example;

public class Main {
    public static void main(String[] args) {

Livre.LivreBuilder livre = Livre.builder();

        System.out.println(livre);


//        Livre livre = new Livre.Builder()
//                .titre("Le seigneur des anneaux")
//                .auteur("J.R.R. Tolkien")
//                .nbPages(576)
//                .anneePublication(1954)
//                .genre("Fantasy")
//                .ISBN(9782070)
//                .build();
//        Livre livre2 = new Livre.Builder()
//                .titre("Le seigneur des anneaux2")
//                .auteur("J.R.R. Tolkien")
//                .nbPages(576)
//                .anneePublication(1954)
//                .genre("Fantasy")
//                .build();
//
//       System.out.println("Livre 1 :" + livre.getTitre() + " " + livre.getAuteur() + " " +livre.getNbPages() + " " + livre.getAnneePublication() + " " + livre.getGenre() + " " + livre.getISBN());
//        System.out.println(livre2);


    }
}