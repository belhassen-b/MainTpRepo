import { Ihm } from "./modules/Ihm.js";

const form = document.querySelector("#myForm");
const result = document.querySelector("#table-data1");
const result2 = document.querySelector("#table-data2");

const ihm = new Ihm(form,result,result2);

ihm.demarrer();
