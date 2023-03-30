// Déclaration des variables
let nombre =0;
let affichage =`Liste d'entiers chaînés `;

//Récuperation du nombre saisi par l'utilisateur
nombre = Number(prompt("Veuillez saisir un chiffre / nombre : "));


for(let i = 1; i<= nombre/2 +1; i++){
        let somme = i;
        let chaine = " "+nombre+ " = "+ i + " ";
        for(let j = i+1; j <= nombre/2 +1; j++) {
            somme += j;
            chaine += " + "+ j;
            if(somme == nombre){
                affichage += ` ${chaine} `;
                break;
            }else if(somme > nombre){
                break;
            }

        }


}

console.log (affichage);