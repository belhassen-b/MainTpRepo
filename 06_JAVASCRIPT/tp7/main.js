let email = "contact@teamjs.fr";
let mdp=  "leLundiAuSoleil";

emailUser=  prompt("Merci de saisir votre Email.");
mdplUser=  prompt("Merci de saisir votre mot de passe.");

// if(emailUser!=email){
//     alert("Merci de vérifier votre adresse Email.");
// }
// else if(mdp != mdplUser){
//
//     alert("Merci de vérifier votre mot de passe");
// }
// alert("Merci de vérifier votre mot de passe");


if(emailUser==email && mdp==mdplUser){
    alert("Bienvenue sur l'espace sécurisé");
}
else if(emailUser!=email ){
    alert("Merci de vérifier votre adresse Email.");
}
 if (mdp != mdplUser)
 {
     alert("Merci de vérifier votre mot de passe");
}
