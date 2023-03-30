import { Article } from "./article.js";


export class Service extends Article {
    constructor(titre, prix,description,domaine){
        super(titre,prix,description)
        this.domaine = domaine
    }
}