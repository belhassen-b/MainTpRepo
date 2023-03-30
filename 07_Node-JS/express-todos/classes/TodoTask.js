import {Todo} from './Todo.js'

export class TodoTask {
    constructor() {
        this.todos = []
        this.compteur = 0
    }
    addTodo(title , content) {
        const todo = new Todo(++this.compteur , title , content )
        this.todos.push(todo)
    }
    getTodos(id) {
        return this.todos.find(t => t.id == id)
    }
    searchTodoByTitle(search)
    {
        return this.todos.filter(t => t.title.includes(search))
    }

    deleteTodoById(id)
    {
        const todo = this.getTodos(id)
        if (todo != undefined) {
            this.todos.splice(this.todos.indexOf(todo), 1)
            return true
        }
        return false
    }
    getAllTodos() {
        return this.todos
    }
modifyTodo(id , title , content)
{
    const todo = this.getTodos(id)
    if (todo != undefined) {
        todo.title = title
        todo.content = content
        return true
    }
    return false
}

modifyTodoStatus(id) {
    const todo = this.getTodos(id)
    if (todo != undefined) {
        todo.status != todo.status
        return true
    }
    return false
}
}


