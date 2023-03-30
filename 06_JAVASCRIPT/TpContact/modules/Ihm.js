import Service from "./Services.js";
export default class Ihm {
    constructor(formulaire, tableauHtmlResultat) {
        this.services = [];
        this.formulaire = formulaire;
        this.tableauHtmlResultat = tableauHtmlResultat;
    }

    demarrer() {
        this.formulaire.addEventListener("submit", (e) => {
            e.preventDefault();
            this.ajouter();
        });
    }
    ajouter() {
        const titre = this.formulaire.querySelector("#titre");
        const prix = this.formulaire.querySelector("#prix");
        const description = this.formulaire.querySelector("#description");
        const domaine = this.formulaire.querySelector("#domaine");
        const service = new Service(titre.value, prix.value, description.value, domaine.value);
        this.services.push(service);
        this.afficher(service);
        console.log(this.services);
    }


    afficher(c) {
        this.tableauHtmlResultat.innerHTML += `
<tr>
   <td>c.titre</td>
    <td>c.prix</td>
    <td>c.description,</td>
    <td>c.domaine</td>
   
</tr>
`
    }
}