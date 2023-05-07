import recipeItemsSlice from "./components/recipeItems/recipeItemsSlice";

const { configureStore } = require("@reduxjs/toolkit");

const store = configureStore({
    reducer: {
        recipeItems: recipeItemsSlice
    }
})

export default store