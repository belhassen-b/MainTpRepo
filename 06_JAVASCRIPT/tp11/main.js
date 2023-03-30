montantNet = Number(prompt("Merci de saisir le montant net imposable: "));
nbreAdulte = Number(prompt("Merci de saisir le nombre d'adulte: "));
nbreEnfant = Number(prompt("Merci de saisir le nombre d'enfant:"));
let nbrePartAdulte;
let nbrePartEnfant;
let quotient;
let impotRevenu;

// calcul nombre de parts //
switch (nbreAdulte) {
    case 1:
        nbrePartAdulte = 1;
        break;
    case 2:
        nbrePartAdulte = 2;
        break;
}
console.log(nbrePartAdulte);

switch (nbreEnfant) {
    case 0:
        nbrePartEnfant = 0;
        break;
    case 1:
        nbrePartEnfant = .5;
        break;
    case 2:
        nbrePartEnfant = 1;
        break;
}
if (nbreEnfant > 2) {
    nbrePartEnfant = nbreEnfant - 1;
}
console.log(nbrePartEnfant);

let nbrePart = nbrePartAdulte + nbrePartEnfant;
quotient = montantNet / nbrePart;

if (quotient <= 10777) {
    impotRevenu = 0;
}
if (quotient > 10778 && quotient <= 27478) {
    impotRevenu = Math.round((montantNet * 0.11) - (1185.47* nbrePart));
}
if (quotient > 27478 && quotient <= 78570) {
    impotRevenu =Math.round((montantNet * 0.30) - (6406.29 * nbrePart));
}
if (quotient > 78570 && quotient <= 168994) {
    impotRevenu =Math.round((montantNet * 0.41) - (15048.99* nbrePart));
}
if (quotient >168994) {
    impotRevenu = Math.round((montantNet * 0.45) - (21808.75 * nbrePart));
}
console.log(nbrePart);
console.log(impotRevenu);

//calcul impot à payer
console.log(` vos impots sont de ${impotRevenu}`);



