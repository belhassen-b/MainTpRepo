import { Article } from "./article.js";


export class Produit extends Article {
    constructor(titre, prix,description,stock){
        super(titre,prix,description)
        this.stock = stock
    }
}