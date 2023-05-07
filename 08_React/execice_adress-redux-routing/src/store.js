import authSlice from "./routes/auth/authSlice";
import contactsSlice from "./Components/contactsSlice";

const { configureStore } = require("@reduxjs/toolkit");

const store = configureStore({
  reducer: {
    auth: authSlice,
    contacts: contactsSlice

  }
})

export default store