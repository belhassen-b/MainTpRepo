import { Car } from "./classes/car.js";


const resultOutput = document.querySelector("#result");

resultOutput.innerHTML += `<h2>Course de Voiture</h2><hr>`

let bmw = new Car("BMW","Serie 1",80);
const mercedes = new Car("Mercedes","GLB",100);


resultOutput.innerHTML += bmw.accelerate();
resultOutput.innerHTML += bmw.accelerate();
resultOutput.innerHTML += bmw.accelerate();
resultOutput.innerHTML += mercedes.accelerate();
resultOutput.innerHTML += mercedes.accelerate();
resultOutput.innerHTML += mercedes.brake();
resultOutput.innerHTML += mercedes.brake();