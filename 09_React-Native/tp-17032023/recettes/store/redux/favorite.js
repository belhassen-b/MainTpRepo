import { createSlice } from "@reduxjs/toolkit";



const fav = createSlice({
    name : 'fav',
    initialState : {
        ids : []
    },
    reducers : {
        addIds : (state,action) => {
            state.ids.push(action.payload.id)
        },
        removeIds : (state,action) => {
            state.ids.splice(state.ids.indexOf(action.payload.id),1)

        }
    }
})


export const addIds = fav.actions.addIds;
export const removeIds = fav.actions.removeIds;
export default fav.reducer;
