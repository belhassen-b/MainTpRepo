let etudiants = [
    {
        prenom: "José", nom: "Garcia",
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
            francais: 16,
            anglais: 7,
            humour: 14,
            informatique: 4,
            sport: 10
        }

    }
];
//affichage liste etudiants
for ( let person of etudiants)
{   console.log(`prenom: ${person.prenom} Nom : ${person.nom}`);
// affiche les matieres et les notes
    for (let detail in person.matieres) {

    console.log(`${detail}: ${person.matieres[detail]}`);
    }
}
