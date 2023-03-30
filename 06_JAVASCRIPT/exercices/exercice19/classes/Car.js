export class Car {
        constructor(brand,model,speed){
            this.brand = brand;
            this.model = model;
            this.speed = speed;
        }

        toString(){
            return `Voiture : ${this.brand} ${this.model} va à ${this.speed}  km/h`
        }

        accelerate() {
            console.log(this.toString());
            this.speed += 10;
            console.log(this.toString());
            return `<p>La voiture <b>${this.brand} ${this.model}</b> avance désormais à <b>${this.speed}km/h</b></p>`
        }

        brake(){
            console.log(this.toString());
            this.speed -= 5;
            console.log(this.toString())
            return `<p>La voiture <b>${this.brand} ${this.model}</b> avance désormais à <b>${this.speed}km/h</b></p>`
        }



}