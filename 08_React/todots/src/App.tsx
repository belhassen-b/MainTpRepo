import React, {useState, FormEvent} from 'react';
import './App.css';
import {TodoForm} from './Components/TodoForm';
import {TodoItem} from "./Components/TodoItem";

function App() {

    return (
        <div className="App container">
            <h1>TodoList React Typescript</h1>
<TodoForm/>
        </div>
    );
}

export default App;
