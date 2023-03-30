// Création d'un tableau de personne à deux dimensions
let annuaire = [
    {
        nom: "Dupont",
        prenom: "Jean",
        age: 15
    },
    {
        nom: "Durant",
        prenom: "Pierre",
        age: 16
    },
    {
        nom: "Martin",
        prenom: "Jean",
        age: 17
    }
];






function afficheContact(){
    console.table(annuaire);
    let affichage = "";
    for (i = 0; i < annuaire.length; i++) {
        affichage += `${i} ) ${annuaire[i].nom} ${annuaire[i].prenom} age : ${annuaire[i].age} \n`
      //  affichage += i+") "+annuaire[i].nom+" "+annuaire[i].prenom+" age : "+annuaire[i].age+ " \n";
    }
    //alert(affichage);
    return affichage;
}

function ajoutContact(){
    let nom = prompt("Nom du nouveau contact :");
    let prenom = prompt("Prenom du nouveau contact :");
    let age = Number(prompt("Age du nouveau contact :"));
    annuaire[annuaire.length] = {
        nom: nom,
        prenom: prenom,
        age: age
    };
}

function supprContact(){
    let message = "Taper le numéro du contact à supprimer :\n"+afficheContact();
    let contactASuppr = Number(prompt(message));
    annuaire.splice(contactASuppr,1);
}



let choix = 0;

function affichemenu() {

    choix = Number(prompt(`Bienvenue dans l'annuaire :
            1) Afficher Contacts
            2) Ajouter Contact
            3) Supprimer Contact
            4) Quitter
    
    `));

    switch (choix) {
        case 1:
            alert("Liste de tous mes contacts :\n"+afficheContact());
            break;
        case 2:
            ajoutContact();
            break;
        case 3:
            supprContact();
            break;
        case 4:
            alert("Aurevoir");
            break;
        default:
            alert("Merci de faire un choix entre 1 et 4");
            break;
    };
}


do {
    affichemenu();

} while (choix != 4);



