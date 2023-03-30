export interface Todo {
    title: string;
    description: string;
    date: string;
    completed: boolean;
}
export interface TodoList {
    currentTodo: Todo;
    todos: Array<Todo>;
}