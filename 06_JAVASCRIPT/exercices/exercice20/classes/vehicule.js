export class Vehicule {
    constructor(ma,m,k,a){
        this.marque = ma;
        this.model = m;
        this.km = k;
        this.annee = a;
    }

    display(){
        return `Marque : ${this.marque}, Modele : ${this.model}, Km : ${this.km}, annee : ${this.annee}`
    }
}