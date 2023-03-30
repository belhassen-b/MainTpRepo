import {BaseObjet} from "./BaseObjet";

export class Produits extends BaseObjet {
    constructor(titre, prix, description, stock) {
        super(titre, prix, description);
        this.stock = stock;
        this.produits = [];
    }

    ajouter() {
        const titre = this.formulaire.querySelector("#titre");
        const prix = this.formulaire.querySelector("#prix");
        const description = this.formulaire.querySelector("#description");
        const stock = this.formulaire.querySelector("#stock");
        const produit = new Produit(titre.value, prix.value, description.value, stock.value);
        this.produits.push(produit);
        this.afficher(produit);
        console.log(this.produits);
    }
}