import * as React from 'react';
import {ChangeEvent, useState} from "react";
import {TodoList} from "./Interfaces";


export const TodoForm = () => {

    const [todoState, setTodoState] = useState<TodoList>({
        currentTodo: {
            title: '',
            description: '',
            date: '',
            completed: false
        },
        todos: []
    });
    const onchangehandler = (event: ChangeEvent<HTMLInputElement>): void => {
// console.log(event.target.value);
        setTodoState({
                ...todoState,
                currentTodo: {
                    ...todoState.currentTodo,
                    [event.target.name]: event.target.value
                },
                todos: [
                    ...todoState.todos, todoState.currentTodo
                ]
            }
        )
    }

    const submitForm = (e: React.SyntheticEvent): void => {
        e.preventDefault();
        setTodoState({
                currentTodo: {
                    title: '',
                    description: '',
                    date: '',
                    completed: false
                },

                todos: [...todoState.todos, todoState.currentTodo]

            }
        );

    }
    const todos = todoState.todos.map((todo, index) => (
            <div key={index}>
                <h3>{todo.title}</h3>
                <p>{todo.description}</p>
                <p>{todo.date}</p>
            </div>
        )
    )


// console.log(todoState )

    return (
        <>
            <form onSubmit={submitForm} className="form-control">
                <label htmlFor="todo">Title</label>
                <input className="form-control" type="text" id="todo" name="title" value={todoState.currentTodo.title}
                     />
                <label htmlFor="description">Description</label>
                <input className="form-control" type="text" id="description" name="description"
                       value={todoState.currentTodo.description}
                       onInput={onchangehandler}/>
                <label htmlFor="date">Date</label>
                <input className="form-control" type="date" id="date" name="date" value={todoState.currentTodo.date}
                       onChange={onchangehandler}/>
                <button type="submit">Submit</button>
                {todos}
            </form>
        </>
    )
}



