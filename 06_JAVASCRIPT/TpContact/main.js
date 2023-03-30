import Contact from './modules/Contact.js';
import Ihm from "./modules/Ihm.js";

const formulaire = document.querySelector("#myForm");
const tableauHtmlResultat = document.querySelector("#table-data");
const ihm = new Ihm(formulaire, tableauHtmlResultat);

ihm.ecouter();

//
// let submit = document.querySelector("#submit");
// let tableDatas = document.querySelector("#table-data");
//
// let contacts = [];
// submit.addEventListener("click", function (e) {
//     e.preventDefault();
//     // let gender = document.querySelector('.form-check-input:checked');
//     // let lastName = document.querySelector("#lastName");
//     // let firstName = document.querySelector("#firstName");
//     // let dateOfBirth = document.querySelector("#birthDate").value;
//     // let birthDate = new Date(dateOfBirth).toLocaleDateString('fr-FR');
//     // let phone = document.querySelector("#phone");
//     // let email = document.querySelector("#email");
//     // let contact = new Services(gender.value, lastName.value, firstName.value, birthDate, phone.value, email.value);
//     // contacts.push(contact);
//     //
//     // refreshTableElement()
//
// });


// const refreshTableElement = () => {
//
//     tableDatas.innerHTML = "";
//     for (const contact of contacts) {
//         tableDatas.innerHTML += `<tr>
//
//                              <td class="border border-dark">${contact.gender}</td>
//                              <td class="border border-dark">${contact.lastName}</td>
//                              <td class="border border-dark">${contact.firstName}</td>
//                              <td class="border border-dark">${contact.birthDate}</td>
//                              <td class="border border-dark">${contact.phone}</td>
//                              <td class="border border-dark">${contact.email}</td>
//                       </tr>
//                         `
//     }
//     document.forms["myForm"].reset();
// }