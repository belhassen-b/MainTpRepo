package org.example.exercice5;


import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Produit {

    private String nom;

    private String type;
    private int sellIn;
    private int quality;

    public Produit(String nom, int sellIn, int quality) {
        this.nom = nom;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void update() {
if (this.quality > 0) {
            this.quality = this.quality - 1;
        }
        this.sellIn = this.sellIn - 1;
        if (this.sellIn < 0) {
            if (this.quality > 0) {
                this.quality = this.quality - 1;
            }
        }
    }

    public void setSellIn(int i) {
    }

    public int getSellIn() {
        return 0;
    }

    public void setQuality(int i) {
    }

    public int getQuality() {
        return 0;
    }
}
