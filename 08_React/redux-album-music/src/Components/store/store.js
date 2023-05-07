import { configureStore } from '@reduxjs/toolkit'
import authSlice from "../reducer/authSlice";
import albumSlice from "../reducer/albumSlice";


export default configureStore({
    reducer: {
        auth: authSlice,
        albums: albumSlice
    }
})