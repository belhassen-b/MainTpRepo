let nbreNote = prompt(`Saisir le nombre de notes:`);
let note = prompt(`Saisir la note:`);
let sum = 0 ;
let moyenne =0;
let j = 0;

etudiants.forEach(person => {
    console.log(`prenom: ${person.prenom} Nom : ${person.nom}`);
    person.matieres.forEach(matiere => {
        console.log(`nom: ${matiere}`)
        
   })
})