// Etape 1: récupérer les éléments du DOM 
let buttons = document.querySelectorAll(".buttons");                                //récupère tous les boutons
buttons.forEach(function (button) {                                        //pour chaque bouton
    button.addEventListener("click", getButtonValue);                                  //ajoute un déclencheur au clic
});


// Etape 2: récupérer la valeur du bouton cliqué et l'afficher dans affichage
function getButtonValue(event) { 
    document.getElementById("affichage").innerText += event.target.textContent;     //affiche la valeur du bouton cliqué
}

// Etaoe 3: récupérer la valeur de la touche appuyée et l'afficher dans affichage
document.addEventListener('keyup', function (e) {
    let key = e["keyCode"];                                                                 //récupère le code de la touche
    let valeur = e.key;                                                                     //récupère la valeur de la touche
    if (key >= 96 && key <= 111) {                                                          //vérifie si la touche est un chiffre ou un opérateur
        document.getElementById("affichage").innerText += valeur;
          console.log(key)
    } else if (key === 13) {                                                                //vérifie si la touche est la touche entrée
        calculer();
    }
});

//Etape 4: calculer la valeur de l'écran
function calculer() {
    let a = document.getElementById("affichage").textContent;                       //récupère la valeur de l'écran
    document.getElementById("affichage").textContent = eval(a);                       //  eval permet de calculer une expression mathématique  //affiche le résultat
    // console.log(a);
    // console.log(b);
}

//fonction qui efface l'écran 
function effacer() {
    document.getElementById("affichage").textContent = ""
}

window.