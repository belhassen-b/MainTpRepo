import { Vehicule } from "./vehicule.js";


export class Moto extends Vehicule {
    constructor(ma,m,k,a){
        super(ma,m,k,a)
    }

    display() {
        return "Moto : "+super.display();
    }
}