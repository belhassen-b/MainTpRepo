nbHabAct = Number(prompt(`Entrer le nombre d'habitant actuel:`));
taux = Number(prompt(`Entrer le de croissance :`));
nbHabCible = Number(prompt(`Entrer le nombre d'habitant cible:`));

// Boucle jusqu'à ce que la population atteigne la population cible
let nbAnnee = 0;
while (nbHabAct < nbHabCible) {
    nbHabAct += nbHabAct * (taux/100);
    nbAnnee++;
}

alert(`il faudra ${nbAnnee} ans pour la population actuelle atteigne ${nbHabCible} habitants.`);