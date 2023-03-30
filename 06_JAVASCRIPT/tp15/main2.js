// ////////////////////////////////
// // declarations de deux tableaux
// // let legumes = ["Carottes", "Choux", "Haricots"];
// // let fruits = ["apple", "banana", "cherry"];
//
// //affichage des 2 tableaux
// //console.table(legumes);
// //console.table(fruits);
//
// //creation d untableua à 2 dimensions depuis nos 2 tableaux
// //let primeur = [legumes, fruits];
//
// //console.table(primeur);
//
// //affichage d'un element à un index precis
// //console.log(primeur[0][0]); //carottes
// //console.log(primeur[1][2]); //cherry
//
// // let jourSem = ["Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"];
// // for (i = 0; i < jourSem.length; i++) {
// //     console.log(jourSem[i]);
// //
// //     if (i >= 1 && i <= 5) {
// //         console.log("début de semaine");
// //     }
// //
// // }
// //
//   let names = ["Adam", "Etienne", "Sebastien", "Clement", "Virgine"];
// // let j = 0;
// // console.log("avec For");
// //   for (i = 0; i < names.length; i++) {
// //
// //       console.log(names[i]);
// //   }
// // console.log("avec While");
// // while (j < names.length) {
// //
// //     console.log(names[j]);
// //     j++
// // }
// //
// //Parfait pour les tableaux associatifs
// let contact = {
//     nom : "Richard",
//     prenom : "Pierre",
//     specialite : "Boucle infinie"
// };
// for(let key in contact) {
//     console.log(key  +" " + ": "+ contact[key]);
// }
// // boucle for of
// for (let value of names) {
//     console.log("La boucle for ... of , names contient " + value );
// }
// //boucles imbriquées
//
// for (let i = 1; i < 5; i++) {
//     console.log("I ="+i);
//     for (let j = 1; j < 5; j++) {
//         console.log("Deuxieme boucle j ="+j);
//     }
//     i++
// }
//
// // // declaration d un tableau associatif (objet litrealq)
// // //let personne = {
// //     nom : "Richard",
// //     prenom : "Pierre",
// //     age:  25
// // }
//
// //affichage objet
// // console.log(personne);
// // console.table(personne);
// // console.log(typeof personne);
//
// // affichage valeur à une clé
// //console.log(personne[nom]);
// //console.log(personne.prenom);
//
// // destructuring
// const tabNum=[1,2,3];
// console.table(tabNum);
//
// // en es5
// const a = tabNum[0];
// const b = tabNum[1];
//
// // es6
// const  [c,e,...d] = tabNum;
// console.log(c);
// console.log(e);
// console.log(d);
// let legumes = ["Carottes", "Choux", "Haricots"];
// let fruits = ["apple", "banana", "cherry"];
// let aliments = [...legumes,"",...fruits,"Cerises"];
// console.log(aliments);

// meme pricipe avec des objets

const personne = {
    nom : "Richard",
    prenom : "Pierre",
    specialite: "boucle infinie"
}
// const {specialite,...person}= personne;
// console.log(specialite);
//
// console.log(person);

// const {nom,prenom} = personne;
// console.log(nom);
// console.log(prenom);

const personneAvecAge = {...personne,age:30};
console.table(personneAvecAge);
