import { Produit } from "./produit.js"
import { Service } from "./service.js"


export class Ihm {
    constructor(formulaire,domProduits,domServices){
        this.articles = []
        this.formulaire = formulaire
        this.domProduits = domProduits
        this.domServices = domServices
    }

    demarrer(){
        const radios = this.formulaire.querySelector("#parentRadio")
        
        radios.addEventListener('change', (e) => {
            console.log(e.target.value)
            this.switchProduitService(e.target.value)
        })


        this.formulaire.addEventListener('submit', (e) => {
            e.preventDefault();

            if(this.ajouterArticle().type =="produit"){
                this.domProduits.innerHTML += this.ajouterArticle().renduHtml
            }else if(this.ajouterArticle().type =="service"){
                this.domServices.innerHTML += this.ajouterArticle().renduHtml
            }


        })
    }

    ajouterArticle(){
        const type = this.formulaire.querySelector("input[name='type']:checked").value
        //Si produit => ajouterProduit
        if(type == 'produit') {
            return this.ajouterProduit()
        }
        //Si Service => ajouterService
        else if(type == 'service'){
            return this.ajouterService()
        }
    }

    ajouterProduit(){
        const {titre, description, prix, renduHtml } = this.constructionArticle()
        const stock = document.querySelector("input[name='stock']").value
        const produit = new Produit(titre,prix,description,stock);
        this.articles.push(produit)
        return { type : 'produit', renduHtml : `${renduHtml}<td>${stock}</td></tr>`}

    }

    ajouterService(){
        const {titre, description, prix, renduHtml } = this.constructionArticle()
        const domaine = document.querySelector("input[name='domaine']").value
        const service = new Service(titre,prix,description,domaine);
        this.articles.push(service)
        return { type : 'service', renduHtml : `${renduHtml}<td>${domaine}</td></tr>`}

    }

    constructionArticle(){
        const titre = document.querySelector("input[name='titre']").value
        const prix = document.querySelector("input[name='prix']").value
        const description = document.querySelector("textarea[name='description']").value
        return {
            titre : titre,
            prix : prix,
            description : description,
            renduHtml : `<tr><td>${titre}</td><td>${prix}</td><td>${description}</td>`
        }
    }

    switchProduitService(type){
        const inputStock = this.formulaire.querySelector("input[name='stock']")
        const inputDomaine = this.formulaire.querySelector("input[name='domaine']")
        if(type == "produit"){
            inputDomaine.style.display ='none'
            inputStock.style.display = 'block'
        }else if(type == "service")
        {
            inputDomaine.style.display ='block'
            inputStock.style.display = 'none'
        }
    }
}