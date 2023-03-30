// Declarations des vaiables
let cote, longueur,largeur, perimetreCarre,aireCarre,perimetrerectangle,aireRectangle,affichage;

// Carré

cote = Number(prompt("Veuillez saisir le coté de votre carré : "));

perimetreCarre = cote*4;

aireCarre = cote*cote;

affichage=`Le perimetre de votre carre est de ${perimetreCarre} et son aire est de ${aireCarre}`;

console.log(affichage);

// Rectangle

longueur = Number(prompt("Veuillez saisir la longueur de votre rectangle : "));
largeur = Number(prompt("Veuillez saisir la largeur de votre rectangle : "));

perimetrerectangle =(longueur + largeur )*2;

aireRectangle = longueur * largeur;

affichage=`Le perimetre de votre rectangle est de ${perimetrerectangle} et son aire est de ${aireRectangle}`;

console.log(affichage);
