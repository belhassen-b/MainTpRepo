package org.example.papeterie.facture;

import org.example.papeterie.article.Article;

import java.util.ArrayList;
import java.util.List;

public class Facture<refArt, quantity> {
    private Client client;
    private String numero;
    private String date;
    private List<LignesFacture> lignesFacture;

    public Facture(Client client, String numero, String date) {
        this.client = client;
        this.numero = numero;
        this.date = date;
        this.lignesFacture = new ArrayList<>();
    }

    public void ajouterLigne(Article refArt, int quantity) {
    LignesFacture ligneFacture = new LignesFacture(refArt, quantity);
        lignesFacture.add(ligneFacture);
        }

    public double getTotal() {
        double total = 0;
        for (LignesFacture ligneFacture : lignesFacture) {
            if (ligneFacture != null) {
//                total += ligneFacture.getMontant();
            }
        }
        return total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<LignesFacture> getLignesFacture() {
        return lignesFacture;
    }

    public void setLignesFacture(LignesFacture[] lignesFacture) {
        this.lignesFacture = List.of(lignesFacture);
    }

    @Override
    public String toString() {
        return "Facture{" +
                "client=" + client +
                ", numero='" + numero + '\'' +
                ", date='" + date + '\'' +
                ", lignesFacture=" + lignesFacture +
                '}';
    }

}
