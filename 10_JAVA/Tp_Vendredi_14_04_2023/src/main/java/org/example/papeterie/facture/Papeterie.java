package org.example.papeterie.facture;

import org.example.papeterie.article.Article;
import org.example.papeterie.utils.Utils;
import org.example.papeterie.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Papeterie {
    private static Papeterie instance = null;

    private String nom;
    private List<Client> clients;
    private HashMap<Integer, Article> articles;

    public Papeterie(String nom) {
        this.nom = nom;
        this.clients = new ArrayList<>();
        this.articles = new HashMap<>();
        Utils.remplirClients(this.clients);
        Utils.remplirArticles(this.articles);
    }

    public static Papeterie getInstance() {
        if (instance == null) {
            instance = new Papeterie("Papeterie du coin");
        }
        return instance;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Client> getClients() {
        return clients;
    }

    public HashMap<Integer, Article> getArticles() {
        return articles;
    }

    public void ajouterArticle(Article article) {
        articles.put(article.getRefArt(), article);
    }

    public void supprimerArticle(Article article) {
        articles.remove(article.getRefArt());
    }

    public Article rechercherArticle(int reference) {
        return articles.get(reference);
    }
}