ageSalarie=  Number(prompt("Merci de l'âge du salarié"));
oldSalarie=  Number(prompt("Merci de l'ancienneté en année, du salarié"));
salairSalarie=  Number(prompt("Merci de le salaire mensuel du salarié"));

let indemnite;


        if(oldSalarie >= 1 && oldSalarie <= 10) {
    indemnite =  (salairSalarie / 2) * oldSalarie;
        }
        if(oldSalarie > 10){
                indemnite = salairSalarie * oldSalarie;
}
        if(ageSalarie>=46 && ageSalarie<=49) {
            indemnite  += 2*salairSalarie;
        }
        if(ageSalarie>50) {
            indemnite  += 5*salairSalarie;
        }

console.log(`Pour un salarié agé de ${ageSalarie}ans et ayant une ancienneté de ${oldSalarie} an(s), l'indemnité de licenciement sera de  ${indemnite} `);
