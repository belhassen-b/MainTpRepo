
// export default class Task {
//     constructor(id, title, content, status = "Non Fait") {
//         this.id = id;
//         this.title = title;
//         this.content = content;
//         this.status = status;
//     }
//
//     addTask(title, content) {
//         const btnAdd = document.getElementById("btnAdd");
//
//         btnAdd.addEventListener("click", (e) => {
//                 return new Promise((resolve, reject) => {
//                     const task = new Task(title, content);
//                     this.tasks.push(task);
//                     resolve(task);
//                 });
//             }
//         );
//     }
// }

export  default class Task {
    constructor(id, title, content, status = "Non Fait") {
        this.id = id;
        this.title = title;
        this.content = content;
        this.status = status;
    }


}
