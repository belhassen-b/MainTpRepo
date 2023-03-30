
// calcul du perimetre


nbA = Number(prompt(`Saisir le diametre du cercle:`));
permimetre = function calculPerimetre(nbA) {
    return Math.round ( 2 * Math.PI * (nbA/2));
}
// perimeter method
aire = function (nbA)
{
    return Math.round(Math.PI * (nbA/2) * (nbA/2));

};


console.log(`Le perimètre d'un cercle de diamètre ${nbA} cm est ${permimetre(nbA)} et son aire est :  ${aire(nbA)} cm2`);