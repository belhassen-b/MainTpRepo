import { Vehicule } from "./vehicule.js";

export class Voiture extends Vehicule {
    constructor(ma,m,k,a,c){
        super(ma,m,k,a)
        this.clim = c
    }

    display() {
        return "Voiture : "+super.display()+", clim : "+this.clim;
    }
}