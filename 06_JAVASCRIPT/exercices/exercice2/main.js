// Déclaration des variables
let nb1 = 0,
    nb2 = 0,
    resultat,
    affichage;


// Récuperation et stockage des saisies utilisateur 
nb1 = Number(prompt("Saisir le premier nombre : "));
nb2 = Number(prompt("Saisir le deuxiéme nombre : "));

resultat = nb1+nb2;

affichage = `La somme de ${nb1} et ${nb2} est égale à ${resultat}`

console.log(affichage);