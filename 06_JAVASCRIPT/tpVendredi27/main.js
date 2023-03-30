import Vehicule from "./modules/Vehicule.js";
import  Voiture from "./modules/Voiture.js";
import Moto  from "./modules/Moto.js";


const resultOutput = document.querySelector("#result");

resultOutput.innerHTML += `<h2>TRAVAUX PRATIQUE POO HERITAGE - Class Véhicule </h2><hr>`
resultOutput.innerHTML += `<h4>Création et utilisation des Class en Javascript</h4>`

let renault = new Voiture("Renault","Kangoo","240.000",2003,"clim");
let bmw = new Moto("BMW","R1150R Rockster","65.000",2005);


resultOutput.innerHTML += renault.display() + `<br>`+ bmw.display() ;
