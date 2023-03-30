let monTableau = [];

monTableau[0]="pomme";
monTableau[1]="poire";

console.log(monTableau);
console.log(monTableau [1]);
//console.table(monTableau);

let legumes=["pomme","poire","patate"];
console.log(legumes[2]);
legumes[2] = "epinard";
console.log(legumes[2]);

let nbLegumes = legumes.length;
console.log(nbLegumes);

legumes[legumes.length] = "cerise";
console.table(legumes);

//retirer dernier element
legumes.pop();
console.table(legumes);

//retirer premier element d un tableau
legumes.shift();
console.table(legumes);

//insertion avec recuperation auto du dernier
legumes[legumes.length] = "cerise";
legumes[legumes.length] = "cerise";
legumes[legumes.length] = "cerise";
console.table(legumes);

//retirer un ou plusieurs elememt  à un indice donné
legumes.splice(2,4);
console.table(legumes);

//ajouter un element à un index donné
legumes.splice(7,0,"concombre","test");
console.table(legumes);

//obtenir l index d une valeur dans un tableau
console.log(legumes.indexOf("Test"));

//verifier que mon tableau contient une valeur
console.log(legumes.includes("poire"));



