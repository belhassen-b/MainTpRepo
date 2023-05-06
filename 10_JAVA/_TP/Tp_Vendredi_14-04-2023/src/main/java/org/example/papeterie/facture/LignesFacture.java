package org.example.papeterie.facture;

import org.example.papeterie.article.Article;

public class LignesFacture {

        private Article article;
        private int quantite;

    public LignesFacture() {
    }

    public LignesFacture(Article article, int quantite) {
        this.article = article;
        this.quantite = quantite;
    }

    public Article getArticle() {
            return article;
        }

        public void setArticle(Article article) {
            this.article = article;
        }

        public int getQuantite() {
            return quantite;
        }

        public void setQuantite(int quantite) {
            this.quantite = quantite;
        }

        @Override
        public String toString() {
            return "LigneFacture{" +
                    "article=" + article +
                    ", quantite=" + quantite +
                    '}';
        }

        public void afficherLigneFacture(){
            System.out.println("Article : " + article + "Quantité : " + quantite);
        }

}
