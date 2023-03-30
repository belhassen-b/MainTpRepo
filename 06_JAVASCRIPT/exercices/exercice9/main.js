// Declarations des variables
let indemnite  = 0, salaire =0, anciennete =0, age = 0;

// Récupération et stockage des saisie utilisateur
salaire = Number(prompt("Veuillez saisir le dernier salaire :"));
anciennete = Number(prompt("Veuillez saisir l'ancienneté':"));
age = Number(prompt("Veuillez saisir l'age du salarié :"));

if (anciennete >= 1 && anciennete <=10 ){
    indemnite = (salaire/2) * anciennete;
}

if(anciennete > 10) {
    indemnite = salaire * anciennete;
    // si on veut que les 10 premieres annés soit calculé avec un demi salaire
    /*
    indemnite = (salaire/2) * 10;
    indemnite += (anciennete-10)*salaire
    */
}

if(age >= 46 && age <=49) {
   // indemnite = indemnite + salaire*2;
    indemnite += salaire*2;
}else if (age >= 50){
    indemnite += 5*salaire;
}


console.log(`Votre indeminité est de ${indemnite}`)

