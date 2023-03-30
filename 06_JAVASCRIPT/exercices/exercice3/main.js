// Déclaration des variables
let diametre, perimetre, aire, affichage;

// Déclaration de constante
const pi = Math.PI;

// Calcul du périmetre du cercle

diametre =Number(prompt("Veuillez saisir le diamétre de votre cercle : "));
perimetre = diametre*pi;
aire = pi*Math.pow((diametre/2),2)

affichage = `Le perimetre de votre cercle est égale à : ${perimetre} et l'aire de votre cercle : ${aire}`

console.log(affichage);

alert(affichage);