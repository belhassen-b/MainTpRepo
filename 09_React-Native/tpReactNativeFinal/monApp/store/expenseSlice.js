import { createSlice } from "@reduxjs/toolkit";



const myExpense = createSlice({
    name : 'myExpense',
    initialState : {
        id: ' ',
        name : ' ',
        amount : ' ',
        date : ' ',
        category : [
            {
                id : ' ',
                name : ' '
            }
        ],
    },
    reducers : {
        addCategory : (state, action) => {
            state.id = action.payload.id;
            state.name = action.payload.name;
        },
        RemoveCategory : (state, action) => {
            state.id = action.payload.id;
            state.name = action.payload.name;
        },
        addExpense : (state, action) => {
            state.id = action.payload.id;
            state.name = action.payload.name;
            state.amount = action.payload.amount;
            state.date = action.payload.date;
            state.category = action.payload.category;
        },
        }
    }
);


export const { addCategory, RemoveCategory, addExpense } = myExpense.actions;
export default myExpense.reducer;