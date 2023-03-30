let nombre =0;
let affichage = `liste des entiers chaînés`;


nombre = Number(prompt("Saisir un nombre: "));

for (let i = 1; i <= nombre/2 +1; i++) {
somme = i;
let chaine = " "+nombre+ "="+i+" ";
 for (let j = i+1; j <= nombre/2 +1; j++) {

     somme += j;
     chaine += "+" +j;
     if (somme == nombre) {
         affichage += `${chaine}`;
         break;
     }
     else if (somme>nombre){
         break;
     }

 }
}
console.log(affichage);


