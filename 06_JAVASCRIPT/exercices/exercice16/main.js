/**
 * Notes
 */

// Déclaration variables
let nbNotes = 0,
    maxNote = 0,
    minNote = 20,
    moyNote = 0,
    affichage = `<h2>Meilleur note, moins bonne note, moyenne des notes</h2><br><hr>`;


// Récupération du nombre saisi par l'utilisateur et traitement des notes
nbNotes = Number(prompt("Combiens de notes allez vous saisir ?"));

// Affichage de la saisi de l'utilisateur
affichage += `<p>La série contient <b>${nbNotes} notes</b> : </p><ul>`;

// Boucle pour saisie et traiement des notes
for (let i = 1; i <= nbNotes; i++) {
    
    let noteTmp = Number(prompt(`Merci de saisir la note ${i} (sur 20):`));

    affichage+=`<li>En note <b>${i}</b>, vous avez saisi <b>${noteTmp}/20</b>.</li>`;
    // Ajoute la note saisie au total
    moyNote += noteTmp;
    // Verifie si la note saisie est supérieure à la note max, Si oui Note max prend la valeur de noteTmp
    if (noteTmp > maxNote)
        maxNote = noteTmp;
    // Verifie si la note saisie est inférieure à la note min, Si oui note min prend la valeur de noteTmp
    if (noteTmp < minNote)
        minNote = noteTmp;
}
affichage+="</ul><hr>"

// Calcul de la moyenne des notes
moyNote = Math.round(((moyNote / nbNotes)+Number.EPSILON)*100)/100;

// Affichage des résultats
affichage+=`<p>Sur l'ensemble des <b>${nbNotes} notes</b> :</p>
            <ul>
                <li class="green">La meilleur note est de <b>${maxNote}/20</b></li>
                <li class="red">La moins bonne note est de <b>${minNote}/20</b></li>
                <li class="gray">La moyenne des notes est de <b>${moyNote}/20</b></li>
            </ul><hr>
`;

// Création de la constante result permettant de recupérer l'élément HTML class="result"
const result = document.querySelector('.result');

// Injection du résultat dans l'element HTML .result
result.innerHTML = affichage;