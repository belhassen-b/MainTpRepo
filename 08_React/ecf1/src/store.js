import { configureStore } from "@reduxjs/toolkit";
import UsersSlice from "./routes/UsersSlice";

const store = configureStore({
    reducer: {
        users: UsersSlice,
    }
})

export default store