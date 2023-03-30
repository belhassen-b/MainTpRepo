import {Voiture} from "./classes/voitures.js";


let voiture1 = new Voiture("BMW", "Serie 1", 80);
let voiture2 = new Voiture("Mercedes", "GLB", 100);


const resultOutput = document.querySelector("#result");

resultOutput.innerHTML += voiture1.accelerer();
resultOutput.innerHTML += voiture1.accelerer();
resultOutput.innerHTML += voiture1.accelerer();
resultOutput.innerHTML += voiture2.accelerer();
resultOutput.innerHTML += voiture2.accelerer();
resultOutput.innerHTML += voiture2.tourner();
resultOutput.innerHTML += voiture2.tourner();

// const btnAccelerer = document.querySelector("#accelerer");
// const btnTourner = document.querySelector("#tourner");
//
// const btnAccelerer2 = document.querySelector("#accelerer2");
// const btnTourner2 = document.querySelector("#tourner2");
//
//
//
//
// // resultOutput.innerHTML = voiture1.accelerer();
// if (btnAccelerer) {
//      btnAccelerer.addEventListener("click", () => {
//         resultOutput.innerHTML = voiture1.accelerer();
//              })
// }
// else if (btnTourner) {
//
//     resultOutput.innerHTML = "";
//     btnTourner.addEventListener("click", () => {
//         resultOutput.innerHTML = voiture1.tourner();
//     })
// }
// if (btnAccelerer2) {
//     btnAccelerer2.addEventListener("click", () => {
//         resultOutput.innerHTML = voiture2.accelerer();
//     })
// } else if (btnTourner2) {
//     console.log("tourner");
//     resultOutput.innerHTML = "";
//     btnTourner2.addEventListener("click", () => {
//         resultOutput.innerHTML = voiture2.tourner();
//     })
// }


