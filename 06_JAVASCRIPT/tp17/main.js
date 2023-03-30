let chien = [
    {
        nom: "jack",
        race: "Jack Russell",
        age: "3"
    },
    {
        nom: "Bull",
        race: "Bulldog",
        age: "5"
    }
];

function ajouter() {
    let nom = document.getElementById("nom").value;
    let race = document.getElementById("race").value;
    let age = document.getElementById("age").value;
    let selectDog = { nom: nom, age: age, race: race };
    chien.push(selectDog);
    Afficher();
    console.table(chien);
}

Afficher = () => {
    let message  = "Vous avez selectionné :";
    let selected = document.getElementById('my-select');
    let value = selected.value;
    let text = selected.options[selected.selectedIndex].text;

        console.log(text);

        result.innerHTML += `<h3>  ${message} ${text} </h3>`
    result2.innerHTML += `<div>Voici la liste des chiens : ${chien.nom}<\div>`;
}

