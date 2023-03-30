import { environment } from './environment.js';

const { urlApi } = environment;
let userToken = '';

document.formSignUp.addEventListener('submit', async function(e) {
  e.preventDefault();

  let user = {};
  new FormData(this).forEach((v, k) => user[k] = v);

  const res = await fetch(`${urlApi}/signup`, {
    method: 'post',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(user),
  });

  const data = await res.json();
  this.firstElementChild.textContent = data.message || "L'utilisateur a bien été enregistré !";
  setTimeout(() => this.firstElementChild.textContent = "", 3000);
});

document.formLogIn.addEventListener('submit', async function(e) {
  e.preventDefault();

  let user = {};
  new FormData(this).forEach((v, k) => user[k] = v);

  const res = await fetch(`${urlApi}/login`, {
    method: 'post',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(user),
  });

  const data = await res.json();

  if (data && data.user) {
    userToken = data.token;
    this.firstElementChild.textContent = data.message || `Bienvenue ${data.user.firstname} !`;
    setTimeout(() => this.firstElementChild.textContent = "", 3000);
  }
});

document.querySelector('.get-users').addEventListener('click', async () => {
  const res = await fetch(`${urlApi}/users`, {
    headers: { 'Authorization': userToken },
  });
  const data = await res.json();
  
  if (data && data.users) {
    let usersHTML = "";
    for (let { firstname, lastname, email, pseudo } of data.users) {
      usersHTML += `
        <div class="user">
          <h1>${firstname} ${lastname}</h1>
          <h3>Email: ${email} - Pseudo: ${pseudo}</h3>
        </div>
        <hr />
      `;
      document.querySelector('.users').innerHTML = usersHTML;
    }
  }
});
