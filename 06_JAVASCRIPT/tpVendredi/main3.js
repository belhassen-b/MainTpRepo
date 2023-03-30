let annuaire = [
    {        nom: "Dupont", prenom: "Jean", age: 15 },
    {        nom: "Durant", prenom: "Pierre", age: 16 },
    {        nom: "Martin", prenom: "Jean", age: 17 }
];

// afficher les contacts
const afficherContacts = () => {
    let details = "";
    annuaire.forEach((contact, index) => {
        details += `${index} ) Nom: ${contact.nom}  Prénom :${contact.prenom}  Age: ${contact.age}\n`;
    });
    return details;
}


// Ajouter un contact
function ajouterContact() {
    let contact = {
        nom: prompt(`Saisir le nom du contact:`),
        prenom: prompt(`Saisir le prénom du contact:`),
        age: prompt(`Saisir l'âge du contact:`),
    };
    annuaire.push(contact);
}

// Fonction pour supprimer un contact
function supprimerContact() {
    let index = parseInt(prompt(`Sélectionnez un contact à supprimer :\n ${afficherContacts()}`));
    annuaire.splice(index, 1);
}


// permet le retour au menu après chaque choix sauf pour quitter
let continuer = true;

while (continuer) {
    choixMenu = Number(prompt("Bienvenue dans l'annuaire :\n" +
        "Merci de faire un choix : \n" +
        "1. Afficher les contacts  \n" +
        "2. Ajouter un contact  \n" +
        "3. Supprimer un contact \n" +
        "4. Quitter \n"
    ));
    // switch case pour la selection des options
    switch (choixMenu) {
        case 1:
            alert(afficherContacts());
            break;
        case 2:
            ajouterContact();
            alert("Le contact a été ajouté !");
            alert(afficherContacts());
            break;
        case 3:
            supprimerContact()
            alert(`Contact supprimé`)
            break;
        case 4:
            alert(`Au revoir`)
            continuer = false;
            break;
        default:
            alert(`vous n'avez rien choisi `)
    }
}
