// let aleat = Math.floor(Math.random()*10 );
// let chance = prompt(`Saisir un nombre de chance `);
// let cpt = 0;
// let vrai = false;
// alert(aleat)
// while (!vrai) {
//     monNombre = prompt(`Saisir un nombre entre 0 et 9 `);
//
//  if (monNombre == aleat) {
// alert (`bravo vous avez gagné `);
//      vrai = true;
//  }
//  else {
//     alert(`on recommence`);
//      cpt++;
//      if (cpt == chance) {
//          alert(`perdu `);
//   break;
//      }
//  }
//
// }
//
// let clients = [`nom: bree`, `nom: bree`, `nom: bree`, `nom: bree`];
// clients.forEach((value, index, array) =>{
//     console.log(index, value);
// } )
//
//
// let nombre = prompt(`Saisir un nombre`);
//
// for (let index = 1; index < nombre; index++) {
//     if (index % 3 === 0 && index % 5 === 0)
//         console.log("FIZZBUZZ");
//    else if (index % 5 === 0)
//         console.log("BUZZ");
//     else if (index % 3 === 0)        console.log("FIZZ");
//     else console.log(index);
//  }


// JUSTE PRIX
let nombreChance = prompt(`Saisir un nombre de chance`);

let justePrix = Math.round(Math.random() * (1000));

let cpt;
alert(justePrix);

for (let index = 0; index < nombreChance; index++) {
    let monPrix = prompt(`Saisir un prix compris entre 0 et 1000 `);
     cpt = (nombreChance - index) - 1;
     // let msgChance = alert(`il vous reste ${cpt} essai`);

    if (monPrix === justePrix) {
        alert(`Bravo vous avez gagné le juste prix étant ${justePrix}`);
        break;
    } else if (monPrix > justePrix) {
                alert(`c'est moins , il vous reste ${cpt} essai`);
            }

    else if (monPrix < justePrix) {
        alert(`c'est plus,il vous reste ${cpt} essai`);
            }
    }
        alert(`Perdu vous n'avez plus d'essai possible`);



