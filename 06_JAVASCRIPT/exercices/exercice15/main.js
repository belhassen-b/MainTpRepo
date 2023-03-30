// Déclaration des variables
let etudiants = [ 
    { 
        prenom: "José", 
        nom: "Garcia", 
        matieres: { 
            francais: 16, 
            anglais: 7, 
            humour: 14 
        }  
    }, 
    { 
        prenom: "Antoine", 
        nom: "De Caunes", 
        matieres: { 
            francais: 15, 
            anglais: 6, 
            humour: 16, 
            informatique: 4, 
            sport: 10 
        } 
    } 
]; 

//console.log(etudiants);

let somme =0;
let nbrNote =0;
let moyenne =0;

//Parcourir mon tableau étudiants
for(let etudiant of etudiants) {
    console.log("###########DEBUT etudiant##########");
   // console.log(etudiant.nom);
   // console.log(etudiant.prenom);
   console.log(`Etudiant : ${etudiant.nom} ${etudiant.prenom}`);
   //console.log(etudiant.matieres)
    for(let key in etudiant.matieres){
       // console.log("###########DEBUT Matieres##########");
         //   console.log(key);
         //   console.log(etudiant.matieres[key]);
         console.log(` ${key} : ${etudiant.matieres[key]} /20`);
        // console.log(typeof etudiant.matieres[key]);
         somme += etudiant.matieres[key];
       //  console.log(somme);
         nbrNote++;
       //  console.log(nbrNote);
         //   console.log("###########FIN Matieres##########");
    }
    moyenne = somme/nbrNote;
    console.log("La moyenne est de "+moyenne);
    console.log(moyenne.toFixed(2))
    console.log("###########FIN etudiant###########");

    somme = 0;
    nbrNote = 0;
};





// Autres possibilités
// for(let i= 0; i < etudiants.length; i++){
//     console.log(etudiants[i]);
// }
