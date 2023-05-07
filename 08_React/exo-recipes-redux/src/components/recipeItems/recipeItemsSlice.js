import {createSlice} from '@reduxjs/toolkit';

export const recipeItemsSlice = createSlice({
    name: 'recipeItems' ,
    initialState: {
        recipes: [],
        isLoading: false ,
        error: null ,
    } ,
    reducers: {


        // dispatch(addRecipeAction(<Ma recette>))
        addRecipeAction(state , action) { // <Ma recette> sera dans action.payload
            state.recipes.push(action.payload)
        } ,
        editRecipeAction(state , action) {
            const recipeToEdit = state.recipes.find(recipe => recipe.id === action.payload.id)
            if (recipeToEdit) {
                state.recipes = [...state.recipes.filter(recipe => recipe.id !== action.payload.id) , action.payload]
            }
        } ,
        // dispatch(removeRecipeAction(<recipeId>))
        removeRecipeAction(state , action) {
            state.recipes = state.recipes.filter(recipe => recipe.id !== action.payload)
        } ,
        // dispatch(setRecipesAction(<recipe[]>))
        setRecipesAction(state , action) {
            state.recipes = action.payload
        }
    }
})


// export const {actions , reducer} = recipeItemsSlice
export const {addRecipeAction , editRecipeAction , removeRecipeAction , setRecipesAction} = recipeItemsSlice.actions
export default recipeItemsSlice.reducer