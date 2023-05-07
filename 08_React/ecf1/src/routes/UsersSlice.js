import {createSlice} from "@reduxjs/toolkit";
import baseUsers from "../utils/baseUser";

let usersSlice;
usersSlice = createSlice({
    name: "users" ,
    initialState: {
        users: [],
        isLoading: false ,
        error: null ,
    } ,
    reducers: {
        addUser(state , action) {
            state.users.push(action.payload)
        },
        editUser(state , action) {
            const {id} = action.payload
            const userFound = state.users.find(r => r.id === id)
            if (userFound) {
                state.users = [...state.users.filter(r => r.id !== id) , action.payload]
            }
        },
        deleteUser(state , action) {
            const id = action.payload
            const userFound = state.users.find(r => r.id === id)
            if (userFound) {
                state.users = state.users.filter(r => r.id !== id)
            }
        }

    }
});

export const {addUser , editUser , deleteUser} = usersSlice.actions
export default usersSlice.reducer