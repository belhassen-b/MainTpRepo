//Déclaration variables
let revenus = 0,
    nbAdulte = 0,
    nbEnfants = 0,
    nbParts = 0,
    revenuImposable = 0,
    montantImpot =0;

// Récuperation des informations
revenus = Number(prompt("Veuillez saisir le montant total des revenus du foyer : "));
nbAdulte = Number(prompt("Veuillez saisir le nombre d'adulte(s) : "));
nbEnfants = Number(prompt("Veuillez saisir le nombre d'enfant(s)  : "));

// Calcul du nombre de parts

if (nbEnfants <= 2) {
    nbParts = nbAdulte +(nbEnfants*0.5);
}else {
    nbParts = nbAdulte + nbEnfants -1;
}

// ternaire
//nbParts = nbEnfants <=2 ? nbAdulte + nbEnfants*0.5   : nbAdulte + nbEnfants -1;
// condition ? true : false

revenuImposable = revenus / nbParts;

switch (true) {
    case revenuImposable > 10777 && revenuImposable < 27479 :
        montantImpot = Math.round((revenuImposable- 10777)*0.11);
        break;
    case revenuImposable >= 27479 && revenuImposable <= 78570 :
        montantImpot = Math.round((revenuImposable - 27479)*0.3 + (27478-10778)*0.11);
        break; 
    case revenuImposable >= 78571 && revenuImposable <= 168994 :
        montantImpot = Math.round((revenuImposable - 78571)*0.41+ (78570-27479)*0.3 + (27478-10778)*0.11);
        break; 
    case revenuImposable >= 168995 :
        montantImpot = Math.round((revenuImposable - 168994)*0.45+ (168994-78571)*0.41 + (78570-27479)*0.3 + (27478-10778)*0.11);
        break;
}

montantImpot = montantImpot * nbParts;

// montantImpot *= nbParts


console.log("Le montant de vos impots est de "+montantImpot);




