

mot=  prompt("Merci de saisir un mot.");

if (estPalimdrome(mot)) {  // si true mot est palimdrome
    alert(`${mot} est un palimdrome!`);
}
else {
    alert(`${mot} n'est pas un palimdrome!`);
}

function estPalimdrome(mot) {
    let motInverse = "";

    for (let i = mot.length -1; i>=0; i--) {
        motInverse += mot[i];
    }
    for (let i = 0; i < mot.length; i++) {
        if (mot[i] !== motInverse[i]) {
            return false;
}
    }
    return true;
}