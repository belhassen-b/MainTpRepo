import Task from "./class/Task.js";


const btnAdd = document.getElementById("btnAdd");
const btnSearch = document.getElementById("btnSearch");

const todoSearch = document.getElementById("todoSearch");
const table = document.getElementById("table-data");
const tasks = [];
const id = tasks.length + 1;
const title = document.getElementById("addTodoTitle").value;
const content = document.getElementById("addTodoContent").value;


btnAdd.addEventListener("click", (e) => {
    console.log("Search button clicked");
    e.preventDefault();
    return  new Promise((resolve, reject) => {
        const task = new Task(id,title, content);
        tasks.push(task);
        resolve(console.log("c'est ajouté!"))
    }
    );
});

btnSearch.addEventListener("click", (e) => {
    e.preventDefault();
for (let task of tasks) {
    if (task.title === todoSearch.value) {
        console.log("titre trouvé");

    }
}
    console.log("Search button clicked");
    return new Promise((resolve, reject) => {
        for (let task of tasks) {
        if (task.title === todoSearch.value) {
            alert   ("titre trouvé");
        }
        resolve(console.log("c'est ajouté!"));
    }
});
});










//
// static changeStatus(id, status) {
//     return new Promise((resolve, reject) => {
//         const task = this.allTasks.find(task => task.id === id);
//         if (!task) return reject(`La tâche avec l'ID ${id} n'a pas été trouvée.`);
//         task.status = status;
//         resolve(task);
//     });
// }
//
// static deleteTask(id) {
//     return new Promise((resolve, reject) => {
//         const taskIndex = this.allTasks.findIndex(task => task.id === id);
//         if (taskIndex === -1) return reject(`La tâche avec l'ID ${id} n'a pas été trouvée.`);
//         const [deletedTask] = this.allTasks.splice(taskIndex, 1);
//         resolve(deletedTask);
//     });
// }
//
// static searchTask(query) {
//     return new Promise((resolve, reject) => {
//         const matchingTasks = this.allTasks.filter(task =>
//             task.title.includes(query) || task.content.includes(query)
//         );
//         resolve(matchingTasks);
//     });
// }


// btnAdd.addEventListener("click", (e) => {
//     e.preventDefault();
//     addTodoTitle.value = document.getElementById("addTodoTitle").value;
//     addTodoContent.value = document.getElementById("addTodoContent").value;
//
// btnSearch.addEventListener("click", (e) => {
//     e.preventDefault();
//     console.log("Search button clicked");
//
//
//  if (todoSearch.value !== "") {
//      for (let task of tasks) {
//          if (task.title === todoSearch.value) {
//              console.log("titre trouvé");
//              table.innerHTML +=
//                  `<tr>
//     <td>${task.id}</td>
//     <td>${task.title}</td>
//     <td>${task.content}</td>
//     <td><button class="alert-danger">Supprimer</button> <button class="alert-success">Fait</button></td>
//     </tr>`;
//          }
//      }
//
//     }
//  else {
//      console.log("Please enter a title to search for.");
//  }
// }
// );
//
//
