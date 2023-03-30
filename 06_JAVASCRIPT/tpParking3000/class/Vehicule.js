export default class Vehicule {
    constructor(immatriculation, heureEntree,) {
        this.immatriculation = immatriculation;
        this.heureEntree = heureEntree;
        this.heureSortie = "";
    }

refresh() {
        document.getElementById("myForm").reset();
}

}


