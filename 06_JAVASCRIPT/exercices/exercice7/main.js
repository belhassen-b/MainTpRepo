// Declarations des vaiables
let email = "contact@teamjs.fr"; 
let mdp = "leLundiAuSoleil";
let message = "";

let userEmail = prompt("Saisir votre email :");
let userPassword = prompt("Saisir votre mot de passe :");

if(userEmail == email){
    if(userPassword == mdp) {
        message = "Bienvenue dans votre espace";
    }else {
        message = "Mot de passe incorrect";
    }
}else {
    message = "Email inconnu";
}

console.log(message);