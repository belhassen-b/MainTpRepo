
// calcul du perimetre


nbA = Number(prompt(`Saisir le prix du produit :`));
nbB = Number(prompt(`Saisir la TVA souhaitée  :`));
prixTtc = function calculTtc(nbA) {
    return Math.round (nbA *(1+(nbB/100)));
}
nbC = prixTtc(nbA) -nbA;


console.log(`Le montant de la TVA  est : ${nbC} € et le prix TTC est : ${prixTtc(nbA)} €`);