import { createSlice } from "@reduxjs/toolkit";


const myBudget = createSlice({
    name: "myBudget",
    initialState: {
        budget: 0,
        expenses: [],
    },
    reducers: {
        addBudget: (state, action) => {
        state.budget = action.payload;
        },
        addExpense: (state, action) => {
        state.expenses = [...state.expenses, action.payload];
        },
        deleteExpense: (state, action) => {
        state.expenses = state.expenses.filter(
            (expense) => expense.id !== action.payload
        );
        },
    },
    });

    export const { addBudget, addExpense, deleteExpense } = myBudget.actions;
    export default myBudget.reducer;
