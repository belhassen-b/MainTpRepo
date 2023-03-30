import Service from "./Services.js";

export  class Ihm {
    constructor(formulaire, domProduits, domServices) {
        this.articles = [];
        this.domProduits = domProduits;
        this.domServices = domServices;
        this.formulaire = formulaire;
    }

    demarrer() {
        this.formulaire.addEventListener("submit", (e) => {
            e.preventDefault();
            this.ajouter();
        });
    }
        ajouterArticle()
        {
            const titre = this.formulaire.querySelector("#titre");
            const prix = this.formulaire.querySelector("#prix");
            const description = this.formulaire.querySelector("#description");
            const domaine = this.formulaire.querySelector("#domaine");
            const service = new Service(titre.value, prix.value, description.value, domaine.value);
            this.services.push(service);
            this.afficher(service);
            console.log(this.services);
        }


        afficher(service)
        {
            this.tableauHtmlResultat.innerHTML += `
<tr>
   <td>titre</td>
    <td>prix</td>
    <td>description,</td>
    <td>domaine</td>
   
</tr>
`
        }
    }
