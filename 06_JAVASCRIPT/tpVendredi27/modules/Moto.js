import Vehicule from "./Vehicule.js";



export default class Moto extends Vehicule {
    constructor(marque, modele, kilometrage, annee) {
        super(marque, modele, kilometrage, annee);
    }

toString()
{
    return (`${this.marque} - ${this.modele} - ${this.kilometrage} - ${this.annee}`);
}
display(){
        
  //  console.log(this.toString());
    return `Moto : ${super.display()}`;
    }

}