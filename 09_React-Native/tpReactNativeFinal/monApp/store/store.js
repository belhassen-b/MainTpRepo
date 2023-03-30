import { configureStore } from "@reduxjs/toolkit";
import myExpense from "./expenseSlice";
import myBudget from "./budgetSlice";



export const store = configureStore({
    reducer : {

        expense : myExpense,
        budget : myBudget

    }
})