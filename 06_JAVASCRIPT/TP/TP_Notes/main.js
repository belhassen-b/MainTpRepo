

const addStudentToogleButton = document.querySelector("#add-student-visibility");
const addLessonFieldToogleButton = document.querySelector("#add-lessonfield-visibility");
const addGradeToogleButton = document.querySelector("#add-grade-visibility");

const addStudentForm = document.querySelector("#add-student-form");
const addLessonFieldForm = document.querySelector("#add-lessonfield-form");
const addGradeForm = document.querySelector("#add-grade-form");

const studentChoiceForm = document.querySelector('#grade-student');
const lessonfieldChoiceForm = document.querySelector('#grade-field');
const studentChoiceSelect = document.querySelector('#student-choice');
const lessonFieldChoiceSelect = document.querySelector('#lessonfield-choice');



//let bool = true;

let students = [
    {
        lastname : "MARTIN",
        firstname : "John",
        grades : {
            'français' : [12,14,9],
            'mathématiques' : [8,7,12,15]
        }
    },
    {
        lastname : "DUPONT",
        firstname : "Sophie",
        grades : {
            'français' : [18,17,15],
            'mathématiques' : [4,5,12,15]
        }
    }
]

let lessonFields = ['français','mathématiques'];

document.getElementById("btnajoutstudent").addEventListener("click", () => {
    console.log("ajout student");
    const newStudent = {
        lastname : document.querySelector("#student-lastname").value,
        firstname : document.querySelector("#student-firstname").value
    };

    students.push(newStudent);

    refreshSelectElements();
})

document.getElementById("btnajoutmatiere").addEventListener("click", () => {
    console.log("ajout matiere");
    const newLessonField = document.querySelector("#lesson-field").value.toLowerCase();
    lessonFields.push(newLessonField);
    refreshSelectElements();
})

document.getElementById("btnajoutnote").addEventListener("click", () => {
    console.log("ajout note");
    const grade = Number(document.querySelector('#grade').value);
    console.log(grade);
   const student = students[(document.querySelector("#grade-student").value)-1];
   console.log(student);
   const lessonFieldName = document.querySelector('#grade-field').value;
   console.log(lessonFieldName);
  // console.log(lessonFields[lessonFieldName-1]);
    let mat = lessonFields[lessonFieldName-1];

    if(!student.grades) student.grades = {};
    if(!student.grades[mat]) student.grades[mat] = [];
    
   
   student.grades[mat].push(grade);
   console.log(student.grades[mat]);
   console.log(student);
})






addStudentToogleButton.addEventListener("click", () => {
    console.log("clique bouton etudiant")
   // if(bool){
    if(addStudentToogleButton.textContent == "OFF"){
        addStudentForm.classList.remove("hidden");
        addStudentToogleButton.textContent = "ON";
      //  bool = false;
    }else {
        addStudentForm.classList.add("hidden");
        addStudentToogleButton.textContent = "OFF";
       // bool = true;
    }
    
});

addLessonFieldToogleButton.addEventListener("click", () => {
    console.log("clique bouton matiere")
    if(addLessonFieldToogleButton.textContent == "OFF"){
        addLessonFieldForm.classList.remove("hidden");
        addLessonFieldToogleButton.textContent = "ON";
    }else {
        addLessonFieldForm.classList.add("hidden");
        addLessonFieldToogleButton.textContent = "OFF";
    }
});

addGradeToogleButton.addEventListener("click", () => {
    console.log("clique bouton note")
    if(addGradeToogleButton.textContent == "OFF"){
        addGradeForm.classList.remove("hidden");
        addGradeToogleButton.textContent = "ON";
    }else {
        addGradeForm.classList.add("hidden");
        addGradeToogleButton.textContent = "OFF";
    }
});



const capitalize = (value) => {
    value = value.toLowerCase(); 
    return value.replace(value[0],value[0].toUpperCase());
}

const refreshSelectElements = () => {
studentChoiceForm.innerHTML =`<option value='0'>Sélectionnez un éléve </option>`;
studentChoiceSelect.innerHTML =`<option value='0'>Toute la classe </option>`;
students.forEach(student => {
    studentChoiceForm.innerHTML += `<option value='${students.indexOf(student)+1}'>${student.lastname} ${student.firstname}</option>`;
    studentChoiceSelect.innerHTML += `<option value='${students.indexOf(student)+1}'>${student.lastname} ${student.firstname}</option>`;
});

lessonfieldChoiceForm.innerHTML= `<option value='0'>Sélectionnez une matière </option>`;
lessonFieldChoiceSelect.innerHTML= `<option value='0'>Toutes les matières </option>`;
lessonFields.forEach(lesson => {
    lessonfieldChoiceForm.innerHTML += `<option value="${lessonFields.indexOf(lesson)+1}">${capitalize(lesson)}</option>`
    lessonFieldChoiceSelect.innerHTML += `<option value="${lessonFields.indexOf(lesson)+1}">${capitalize(lesson)}</option>`
})

};

const tableDatas = document.querySelector('#table-data');

studentChoiceSelect.addEventListener("change", () => {
    refreshTableElement();
    refreshAverageGrade();
});

lessonFieldChoiceSelect.addEventListener("change", () => {
    refreshTableElement();
    refreshAverageGrade();
});

const averageGradeOutput = document.getElementById('average-grade');

const calculateAverage = (grades) => {
    let sum =0;
    for(const grade of grades) sum += grade;
    return (sum / grades.length).toFixed(1);
}

const refreshAverageGrade = () => {
    console.log("refresh grade");
    let currentGrades = [];

    if(studentChoiceSelect.value == 0 && lessonFieldChoiceSelect.value == 0) {
        console.log("cas Toute la classe et toutes les matiéres")
        for(const student of students){
            for (const lessonfield in student.grades){
                for(const grade of student.grades[lessonfield]){
                    currentGrades.push(grade);
                    averageGradeOutput.innerHTML = `Moyenne générale de la classe : <b>${calculateAverage(currentGrades)}</b>`
                }
            }
        }
        
       
    }else if(lessonFieldChoiceSelect.value == 0 ){
        console.log("aucune matiére ")
        const student = students[studentChoiceSelect.value-1]

        for(const lessonfield in student.grades){
            for(const grade of student.grades[lessonfield]){
                currentGrades.push(grade);
                averageGradeOutput.innerHTML = `Moyenne générale de <b>${student.lastname} ${student.firstname}</b>  : <b>${calculateAverage(currentGrades)}</b>`  
        }
       
    } 
    }else if(studentChoiceSelect.value == 0){
        console.log("aucun étudiant")
        const lessonfield = lessonFieldChoiceSelect.value;
        let mat = lessonFields[lessonfield-1];
        for (const student of students){
            for(const grade of student.grades[mat]){
                currentGrades.push(grade);
                averageGradeOutput.innerHTML = `Moyenne en <b>${mat}</b> de la classe : <b>${calculateAverage(currentGrades)}</b>`  
        }
        }
        

    }else {
        console.log("un étudiant et une matiére");
        const student = students[studentChoiceSelect.value-1];
        const lessonfield = lessonFieldChoiceSelect.value;
        let mat = lessonFields[lessonfield-1];

        for(const grade of student.grades[mat]) {
            currentGrades.push(grade);
            averageGradeOutput.innerHTML = `Moyenne en <b>${mat}</b> de <b>${student.lastname} ${student.firstname}</b> : <b>${calculateAverage(currentGrades)}</b>`  
        }
        
    }


}

const refreshTableElement = () => {
    console.log("refresh table");
    tableDatas.innerHTML="";

    if(studentChoiceSelect.value == 0 && lessonFieldChoiceSelect.value == 0) {
        console.log("cas Toute la classe et toutes les matiéres")
        for (const student of students){
            for(const lessonfield in student.grades){
                 for(const grade of student.grades[lessonfield]){
                        tableDatas.innerHTML += 
                         `<tr>
                             <td>${student.lastname}</td>
                             <td>${student.firstname}</td>
                           <td>${lessonfield}</td>
                            <td>${grade}</td>
                      </tr>
                        `
                }
            }
        }
    }else if(lessonFieldChoiceSelect.value == 0 ){
        console.log("aucune matiére ")
        const student = students[studentChoiceSelect.value-1]

        for(const lessonfield in student.grades){
            for(const grade of student.grades[lessonfield]){
                tableDatas.innerHTML += 
                 `<tr>
                     <td>${student.lastname}</td>
                     <td>${student.firstname}</td>
                   <td>${lessonfield}</td>
                    <td>${grade}</td>
              </tr>
                `
        }
        }
    }else if(studentChoiceSelect.value == 0){
        console.log("aucun étudiant")
        const lessonfield = lessonFieldChoiceSelect.value;
        let mat = lessonFields[lessonfield-1];
        for (const student of students){
            for(const grade of student.grades[mat]){
                tableDatas.innerHTML += 
                 `<tr>
                     <td>${student.lastname}</td>
                     <td>${student.firstname}</td>
                   <td>${mat}</td>
                    <td>${grade}</td>
              </tr>
                `
        }
        }

    }else {
        console.log("un étudiant et une matiére");
        const student = students[studentChoiceSelect.value-1];
        const lessonfield = lessonFieldChoiceSelect.value;
        let mat = lessonFields[lessonfield-1];

        for(const grade of student.grades[mat]) {
            tableDatas.innerHTML += 
            `<tr>
                     <td>${student.lastname}</td>
                     <td>${student.firstname}</td>
                   <td>${mat}</td>
                    <td>${grade}</td>
              </tr>
              `           
        }
    }


};

refreshSelectElements();