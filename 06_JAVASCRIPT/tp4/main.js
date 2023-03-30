// calcul du perimetre du carré


nbA = Number(prompt(`Saisir la longueur d'un côté:`));
permimetre = function calculPerimetre(nbA) {
    return Math.round(4 * nbA);
}
// perimeter method
aire = function (nbA) {
    return Math.round(nbA * nbA);

};

console.log(`Le perimètre d'un carré de côté ${nbA} cm est ${permimetre(nbA)} cm et son aire est :  ${aire(nbA)} cm2`);


nbB = Number(prompt(`Saisir la longueur d'un côté du rectangle:`));
nbC = Number(prompt(`Saisir la largeur d'un côté du rectangle:`));

permimetre = function calculPerimetre(nbB, nbC) {
    return Math.round(2 * (nbB * nbC));
}
// perimeter method
aire = function (nbB,nbC) {
    return Math.round(nbB * nbC);
};

console.log(`Le perimètre d'un rectangle ayant pour longueur ${nbB}cm  et pour largeur ${nbC} est: ${permimetre(nbB,nbC)}cm et son aire est : ${aire(nbB,nbC)} cm2`);