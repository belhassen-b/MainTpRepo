import Vehicule from "./class/Vehicule.js";


const vehicules = [];

const btnAdd = document.querySelector("#btnAdd");
const btnDepart = document.querySelector("#btnDepart")
const message = document.querySelector("#message");
const immat = document.querySelector("#immat");
document.querySelector("#btnAdd").addEventListener("click", (e) => {
    e.preventDefault();
    let immatriculation = document.getElementById("immat").value;
    let heureEntree = new Date();
    let heureSortie = "";
    if (!immatriculation) {
        message.classList.add("alert", "alert-danger");
        message.innerHTML = "Veuillez saisir une immatriculation";
        return;
    } else {
        let vehicule = new Vehicule(immatriculation, heureEntree, heureSortie);
        vehicules.push(vehicule);
    }
    message.classList.add("alert", "alert-success");
    message.innerHTML = `Votre stationnement a bien été enregistré. Votre immatriculation est ${immatriculation}`;
    setTimeout(() => {
        message.innerHTML = "";
        message.classList.remove("alert", "alert-success");
    },3000)
    console.table(vehicules);
    });

document.querySelector("#btnDepart").addEventListener("click", (e) => {
    e.preventDefault();

    let immatriculation = document.getElementById("immat").value;
    let heureSortie;
    let heureEntree;
    let prix;

    if (immatriculation) {
        let vehicule = vehicules.find((vehicule) => vehicule.immatriculation === immatriculation);

        if (vehicule) {
            heureSortie = vehicule.heureSortie = new Date();
            heureEntree = vehicule.heureEntree;
            let duree = (heureSortie - heureEntree) / 1000;
console.log(duree);
            console.log(vehicule);
            console.log(vehicule.heureSortie);
            console.table(vehicules);
            if (duree < 30) {
        prix = 0.8;
    } else if (duree >= 30 && duree <= 90) {
        prix = 1.3;
    } else if (duree > 90 && duree <= 180) {
        prix = 1.7;
    } else if (duree > 180) {
        prix = 6;
    }
alert(`Le prix est de ${prix}€`);


        } else if (vehicule === undefined) {
            alert("Veuillez saisir une immatriculation valide");
        }
    } else if (!immatriculation) {
        alert("Veuillez saisir une immatriculation");
    }
});


