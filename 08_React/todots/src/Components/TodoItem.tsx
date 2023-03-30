import React, { useState } from 'react';
import {Todo} from "./Interfaces";



export function TodoItem () {

    const [todoState, setTodoState] = useState<{ currentTodo: Todo }>({
        currentTodo: {
            title: '',
            description: '',
            date: '',
            completed: false
        }

    });
}