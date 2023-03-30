import { Moto } from "./classes/moto.js";
import { Voiture } from "./classes/voiture.js";


const kangoo = new Voiture("Renault","Kangoo","240000","2003","Non Climatisée");
const motoBmw = new Moto("BMW","R1150R Rockster","65000","2005");

console.log(kangoo.display());
console.log(motoBmw.display());

const result = document.querySelector("#result")

result.innerHTML = kangoo.display();
result.innerHTML += "<br>";
result.innerHTML += motoBmw.display();