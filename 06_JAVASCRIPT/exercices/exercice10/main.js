// Declarations des variables
let choix, boisson, affichage;

const menu = `***** Distributeur de Boisson *****
                    1) Eau
                    2) jus d'oranges
                    3) Limonade
                    4) Café
                    5) Thé
                    
                    Faites votre choix : `;

choix= prompt(menu);


switch(choix) {
    case "1":
        boisson = "Eau"
        break;
    case "2":
        boisson = "jus d'oranges"
        break;
    case "3":
        boisson = "Limonade"
        break;
    case "4":
        boisson = "Café"
        break;
    case "5":
        boisson = "Thé"
        break;
    default :
        boisson ="Inconnu"
        break;
}

if (boisson != "Inconnu"){
    affichage = `Voici votre ${boisson}`;
}else {
    affichage = "Choix invalide";
}

alert(affichage);
console.log(affichage);
