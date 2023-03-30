let myStudent = [
    {
        nom: "Smith",
        prenom: "John",
        speciality:
            {
                "français": [10,12,20],
                "mathématiques": [15,18,20],
                "anglais": [10,12,20],
            }

    },
    {
        nom: "Doe",
        prenom: "Jane",
        speciality:
            {
                "français": [10,12,20],
                "mathématiques": [15,18,20],
                "anglais": [10,12,20],
            }
    }

];

let matiereList =  ["français", "mathématiques","anglais"];

$("#onoff1").click(function () {
    $("#mon-form1").toggle();
    $(this).text($(this).text() === 'OFF' ? 'ON' : 'OFF');
});
$("#onoff2").click(function () {
    $("#mon-form2").toggle();
    $(this).text($(this).text() === 'OFF' ? 'ON' : 'OFF');
});
$("#onoff3").click(function () {
    $("#mon-form3").toggle();
    $(this).text($(this).text() === 'OFF' ? 'ON' : 'OFF');
});

const selectStudentFirst = document.getElementById('eleveList1');
const selectStudentSecond = document.getElementById('eleveList2');
const selectSpeciality1 = document.getElementById('speciality1');
const selectSpeciality2 = document.getElementById('speciality2');

const btn1 = document.querySelector('#btn1');
const btn2 = document.querySelector('#btn2');
const btn3 = document.querySelector('#btn3');

const refreshStudentSelect = () => {
    selectStudentSecond.innerHTML = `<option value="0">Sélectionnez un élève</option>`;
    selectStudentFirst.innerHTML = `<option value="0">Sélectionnez un élève</option>`;
    myStudent.forEach(student => {
        selectStudentFirst.innerHTML += `<option value ="${student.nom}">${student.nom} ${student.prenom}</option>`;
        selectStudentSecond.innerHTML += `<option value ="${student.nom}">${student.nom} ${student.prenom}</option>`;
    });
}

const refreshSpecialitySelect = () => {
    selectSpeciality1.innerHTML = `<option value="0">Sélectionnez un matière</option>`;
    selectSpeciality2.innerHTML = `<option value="0">Sélectionnez un matière</option>`;
    matiereList.forEach((matiere,index) => {

        selectSpeciality1.innerHTML += `<option value ="${matiere}">${matiere}</option>`;
        selectSpeciality2.innerHTML += `<option value =="${matiere}">${matiere}</option>`;
    });
}

btn1.addEventListener("click", () => {
    let name = document.getElementById("name").value;
    name = name.toUpperCase();

    let firstName = document.getElementById("firstName").value;
    firstName = firstName.charAt(0).toUpperCase() + firstName.slice(1)

    myStudent.push({
        nom: name,
        prenom: firstName,
        speciality: {}
    })


    refreshStudentSelect();
    refreshSpecialitySelect();

})

btn2.addEventListener("click", () => {
    let matiereAdd = document.getElementById("addSpeciality").value;
    matiereAdd = matiereAdd.charAt(0).toUpperCase() + matiereAdd.slice(1)
    matiereList.push(matiereAdd)
    refreshStudentSelect();
    refreshSpecialitySelect();

})

btn3.addEventListener("click", () => {
    let selectStudent = document.getElementById("eleveList1").value;
    let note = document.getElementById("note").value;
    let matiere = document.getElementById("speciality1").value;
    console.log(matiere)
    let index = myStudent.findIndex(student => student.nom === selectStudent);
    if(matiere in myStudent[index].speciality){
        for(let item of Object.keys(myStudent[index].speciality)){
            if(item === matiere){
                myStudent[index].speciality[matiere].push(parseInt(note));
                console.log(myStudent[index].speciality[matiere])
            }
        }
    }else{
        myStudent[index].speciality[matiere] = [parseInt(note)]
    }
    refreshStudentSelect();
    refreshSpecialitySelect();
});


refreshStudentSelect();
refreshSpecialitySelect();
