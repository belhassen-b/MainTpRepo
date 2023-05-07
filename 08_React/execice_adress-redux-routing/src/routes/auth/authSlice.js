import { createSlice } from "@reduxjs/toolkit";

const authSlice = createSlice({
  name: "auth",
  initialState: {
    user: {
      role: 'Client'
    },
    isLoading: false,
    error: null
  },
  reducers: {
    setUser(state, action) {
      state.user = action.payload
    }
  }
})

export const { setUser } = authSlice.actions

export default authSlice.reducer