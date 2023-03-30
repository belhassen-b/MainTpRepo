// Récuperation des elements du DOM
const ecranHaut = document.querySelector('.ecranHaut');
const ecranBas = document.querySelector('.ecranBas');
const touches = [...document.querySelectorAll(".bouton")];
const listKeycode = touches.map(touche => touche.dataset.key);

//Ecouteur évenement Keydown
document.addEventListener('keydown',(e) => {
    //console.log(e.keyCode);
    let valeur = e.keyCode.toString();
  //  console.log("keyCode : "+e.keyCode);
    calculer(valeur);
});

//Ecouteur évenement click
document.addEventListener('click',(e) => {
  //  console.log(e.target.dataset.key);
    const valeur = e.target.dataset.key;
    calculer(valeur);
});

// Fonction permettant d'effectuer les actions des touches
const calculer = (valeur) => {
       // console.log(valeur);
        if(listKeycode.includes(valeur)){
         //   console.log("on calcule");
            switch(valeur){
                case '8' : // touche 'c'
               // console.log("clear les écrans");
                ecranHaut.textContent = ""; // clear ecranHaut
                ecranBas.textContent =""; // clear ecranBas
                break;
                case '13' : // touche 'Enter'
               // console.log("afficher le résultat");
               const calcul = eval(ecranHaut.textContent);
               ecranBas.textContent = "= "+calcul;
                break;
                default :
             //   console.log("opération en cours");
                const indexKeycode = listKeycode.indexOf(valeur);
                const touche = touches[indexKeycode];
             //   console.log(touche);
                ecranHaut.textContent += touche.innerHTML;
               // ecranBas.textContent = touche.textContent;
                ecranBas.textContent = touche.innerHTML;

            }
        }

}

window.addEventListener('resize', () => {
    console.log("Largeur :"+window.innerWidth+" hauteur : "+window.innerHeight);
});