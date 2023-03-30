import { configureStore } from "@reduxjs/toolkit";
import fav from "./favorite";



export const store = configureStore({
    reducer : {
        fav : fav
    }
})
