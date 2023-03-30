//import de Vehicule
import Vehicule from './classes/Vehicule.js'

const btnPayer = document.querySelector("#paymentBtn");
const btnEnter = document.querySelector("#enterBtn");
const licencePlate = document.querySelector("#licencePlate");
const succesBox = document.querySelector("#successBox");
const alertBox = document.querySelector("#alertBox");
const messageBox = document.querySelector("#messageBox");
const vehicules = new Array(); // [] 

btnEnter.addEventListener('click', () => {
    console.log("clique bouton entrer")
    const vehicule = findCar();
    console.log(vehicule);

    //vérification de la présence du véhicule
    if(!vehicule){
        if(licencePlate.value != ''){
            addtoPark();
        }else {
            displayBox(alertBox,"Veuillez saisir votre immatriculation",3000)
        }
    }else {
        if(vehicule.endDate != ''){
            addtoPark();
        }else {
            displayBox(alertBox, `Le véhicule ${licencePlate.value} est déja présent dans le parking`,3000)
        }
        
    }
    console.table(vehicules);
    resetInput();
   
})

btnPayer.addEventListener('click', () => {
    console.log("clique bouton payer")
    let duree, prix = 0;
    //Récuperation du véhicule
    const vehicule = findCar();
    //vérification de la présence du véhicule
    if(vehicule != undefined) {
        if(vehicule.endDate == ''){
                // definir une end date
        vehicule.endDate = new Date();
        //calculer la duree
        duree =(vehicule.endDate - vehicule.startDate) / 60000;
        //calculer le prix
        switch(true) {
            case duree <= 15:
                prix = 0.8;
                break;
            case duree <= 30:
                prix = 1.3;
                break;
            case duree <= 45:
                prix = 1.7;
                break;
            default:
                prix = 6;
                break;
        };
        //affichage du prix
        displayBox(messageBox,`Le prix à payer pour le véhicule ${licencePlate.value} est de ${prix}€`,5000);
        }else {
            displayBox(alertBox,`Le véhicule ${licencePlate.value} a déja soldé le parking`, 3000)
        }
        
    }else {
        displayBox(alertBox,`Le véhicule ${licencePlate.value} n'est pas présent dans le parking`, 3000)
    }
    console.table(vehicules);
    resetInput();

})

function resetInput(){
    licencePlate.value= '';
}

function findCar(){
    //trouver un véhicule en fonction de la plaque
    // return vehicules.find(vehicule => {
    //     return vehicule.id == licencePlate.value
    // })
    return vehicules.findLast(vehicule => {
        return vehicule.id == licencePlate.value
    })
}

function addtoPark(){
    vehicules.push(new Vehicule(licencePlate.value));
    console.table(vehicules);
    displayBox(succesBox,"Veuillez prendre votre ticket pour le véhicule "+licencePlate.value,3000)
}

function displayBox(domElement,message,delay){
        // afficher un élement du dom
            domElement.style.display ="block";
        //inserer un message dans cet element
        domElement.textContent = message;
    setTimeout(() => {
        // cacher cet element apres delay seconde
        domElement.style.display ="none";
    },delay);
}


function init(){
//Ajouter des véhicules à mon parking
vehicules.push(new Vehicule('AA-123-AA',new Date("2023-01-31T15:00:00")))
vehicules.push(new Vehicule('BB-123-AA',new Date("2023-01-31T15:15:00")))
vehicules.push(new Vehicule('CC-123-AA',new Date("2023-01-31T15:28:00")))
vehicules.push(new Vehicule('ZZ-123-AA'))
console.table(vehicules);
// cacher les champs
alertBox.style.display = "none";
succesBox.style.display = "none";
messageBox.style.display = "none";
}


window.onload = init();
