package org.example.papeterie.produit;

import org.example.papeterie.article.Article;
import org.example.papeterie.article.ArticleUnitaire;

public class Lot extends Article {

        private int article;
        private ArticleUnitaire pourcentage;
        private int quantity;

        public Lot(int refArt, int article, ArticleUnitaire pourcentage, int quantity) {
            super(refArt);
            this.article = article;
            this.pourcentage = pourcentage;
            this.quantity = quantity;
        }

        public int getArticle() {
            return article;
        }

        public void setArticle(int article) {
            this.article = article;
        }

        public ArticleUnitaire getPourcentage() {
            return pourcentage;
        }

        public void setPourcentage(ArticleUnitaire pourcentage) {
            this.pourcentage = pourcentage;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Lot{" +
                    "article=" + article +
                    ", pourcentage=" + pourcentage +
                    ", quantity=" + quantity +
                    '}';
        }


}
