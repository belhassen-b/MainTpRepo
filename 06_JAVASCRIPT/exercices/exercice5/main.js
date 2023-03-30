// Declarations des vaiables
let cote1=0, cote2=0,hypotenuse=0, affichage="";

cote1= Number(prompt("Saisir la longueur du coté 1 de votre triangle : "));
cote2= Number(prompt("Saisir la longueur du coté 2 de votre triangle : "));

hypotenuse = Math.sqrt((cote1 * cote1) + (cote2 * cote2)).toFixed(2); // Math.sqrt((Math.pow(cote1,2)) + (Math.pow(cote2,2))) 

affichage =`L' hypoténuse de votre triangle mesure ${hypotenuse}`;

alert(affichage);