export class Voiture {
    constructor(marque, modele, vitesse) {
        this.marque = marque;
        this.modele = modele;
        this.vitesse = vitesse;
    }
    accelerer() { this.vitesse += 10;
    console.log(this.vitesse.toString());
    return `<p>Marque : ${this.marque} Modéle : ${this.modele} avance desormais à Vitesse : ${this.vitesse} Km/h</p>`; }

    tourner() { this.vitesse -= 5;
        console.log(this.vitesse.toString());
        return `<p>Marque : ${this.marque} Modéle : ${this.modele} avance desormais à Vitesse : ${this.vitesse} Km/h</p>`; }
}

    // console.log(`Marque : ${this.marque} Modèle : ${this.modele} vitesse : ${this.vitesse} `)
