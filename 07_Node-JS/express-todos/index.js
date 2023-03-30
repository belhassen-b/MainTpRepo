import express from 'express'
import {TodoTask} from './classes/TodoTask.js'


const app = express()
const todoTask = new TodoTask()

app.use(express.json())


app.get('/todos' , (req , res) => {  // endpoint pour récupérer la liste des todo
// res.send(' bienvenue sur la todo list')
    res.json(todoTask.todos)
})

app.get('/todos/:id',(req,res) => {
    const todo = todoTask.getTodos(req.params.id)
    if(todo != undefined) {
        res.json(todo)
    }else {
        res.json({message : "aucun contact avec cet id"})
    }
})



app.get('/todos/search/:search' , (req , res) => { // endpoint pour rechercher des todos par leur titre
    const todo = todoTask.searchTodoByTitle(req.params.title)
    if (todo != undefined) {
        res.json(todo)
    } else {
        res.json({message: "aucune todo avec ce titre"})
    }
})





app.put('/todos/:id' , (req , res) => { // endpoint pour modifier une todo
    const {title , content} = req.body
    if (todoTask.modifyTodo(req.params.id , title , content)) {
        res.json({message: "todo modifiée"})
    } else {
        res.json({message: "erreur modification"})
    }
})

app.patch('/todos/:id' , (req , res) => { // endpoint pour modifier le statut d'une todo
    const {completed} = req.body
    if (todoTask.modifyTodoStatus(req.params.id , completed)) {
        res.json({message: "todo modifiée"})
    } else {
        res.json({message: "erreur modification"})
    }
})


app.post('/todos',(req,res) => {
    const {title, content} = req.body
    if (title != undefined && content != undefined) {
        todoTask.addTodo(title, content)
        res.json({message : "todo ajoutée"})
    } else {
        res.json({message : "erreur ajout"})
    }
})
app.delete('/todos/:id' , (req , res) => { // endpoint pour supprimer une todo
    if (todoTask.deleteTodoById(req.params.id)) {
        res.json({message: "todo supprimée"})
    } else {
        res.json({message: "erreur suppression"})
    }
})

app.listen(5001 , () => {
    console.log("go")
})



