package org.example.papeterie.utils;

import org.example.papeterie.article.Article;
import org.example.papeterie.article.ArticleUnitaire;
import org.example.papeterie.facture.Client;
import org.example.papeterie.produit.Lot;
import org.example.papeterie.produit.Ramette;
import org.example.papeterie.produit.Stylo;

import java.util.HashMap;
import java.util.List;

public class Utils {
    public static void remplirClients(List<Client> clients) {
        clients.add(new Client("Alice"));
        clients.add(new Client("Bob"));
        clients.add(new Client("Charlie"));
    }

    public static void remplirArticles(HashMap<Integer, Article> articles) {
        ArticleUnitaire styloBleu = new Stylo(1, "Bic bleu", 100, "bleu");
        articles.put(styloBleu.getRefArt(), styloBleu);

        ArticleUnitaire styloRouge = new Stylo(2, "Bic rouge", 100, "rouge");
        articles.put(styloRouge.getRefArt(), styloRouge);

        ArticleUnitaire ramette80g = new Ramette(3, "Ramette 80g", 300, 80);
        articles.put(ramette80g.getRefArt(), ramette80g);

        ArticleUnitaire ramette100g = new Ramette(4, "Ramette 100g", 350, 100);
        articles.put(ramette100g.getRefArt(), ramette100g);

        Article lot10Stylos = new Lot(5, 10, styloBleu, 50);
        articles.put(lot10Stylos.getRefArt(), lot10Stylos);

        Article lot10Ramettes = new Lot(6, 10, ramette80g, 75);
        articles.put(lot10Ramettes.getRefArt(), lot10Ramettes);
    }

}
