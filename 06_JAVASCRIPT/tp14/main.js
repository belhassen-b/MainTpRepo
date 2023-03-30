nbreNotes = Number(prompt("Merci de saisir le nombre de notes : "));
let noteMax= 0;
let noteMin=20;
let moyenneNote =0;

for (let i = 1; i <= nbreNotes; i++) {
    noteTmp = Number(prompt(`Merci de saisir la note n ${i} : `));
    moyenneNote += noteTmp;
    if (noteTmp > noteMax) {
        noteMax = noteTmp;
    }
    if (noteTmp < noteMin) {
        noteMin = noteTmp;
    }
}

moyenneNote = Math.round(moyenneNote/nbreNotes);
console.log(+noteMin);
console.log(+noteMax);
console.log(+moyenneNote);
