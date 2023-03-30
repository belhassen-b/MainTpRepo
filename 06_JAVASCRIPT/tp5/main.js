
// calcul du perimetre


nbA = Number(prompt(`Saisir le 1er côté adjacent du triangle:`));
nbB = Number(prompt(`Saisir le 2eme côté adjacent du triangle:`));

//calcul de l'hypothénuse
hypothenuse = function calculHyp(nbA, nbB) {
    return (Math.pow(nbA,2)) + (Math.pow(nbB,2));
}



console.log(`La longueur de l'hypothénuse du triangle rectangle ayant pour côté adjacent :
 ${nbA} et ${nbB} est :  ${Math.sqrt(hypothenuse(nbA, nbB)).toFixed(2)}`);