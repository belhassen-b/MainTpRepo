import { Ihm } from "./classes/ihm.js";


const ihm = new Ihm(document.querySelector('#formArticle'),document.querySelector('#resultProduit'),document.querySelector('#resultService'))
ihm.demarrer();