// Déclaration des variables
let prenom="",
    nom="",
    nomComplet="",
    affichage="";

prenom=prompt("Veuillez saisir votre prénom : ");
nom= prompt("Veuillez saisir votre nom : ");

nomComplet=prenom+" "+nom;

affichage=`Bonjour ${nomComplet}`

console.log(affichage);

alert(affichage);