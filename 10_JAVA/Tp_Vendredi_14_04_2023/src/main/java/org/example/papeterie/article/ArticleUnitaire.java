package org.example.papeterie.article;

public class ArticleUnitaire extends Article{

    private String name;
    private double price;

    public ArticleUnitaire(Integer refArt, String name, double price) {
        super(refArt);
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ArticleUnitaire{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }


}
