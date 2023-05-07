import { createSlice } from "@reduxjs/toolkit";
import {baseContacts} from "../util/baseContacts";


const contactsSlice = createSlice({
  name: "contacts",
  initialState: {
    contacts: [...baseContacts],
    isLoading: false,
    error: null
  },
  reducers: {
    addContact(state, action) {
      state.contacts.push(action.payload)
    },
    deleteContact(state, action) {
      state.contacts = state.contacts.filter(c => c.id !== action.payload)
    },
    editContact(state, action) {
      state.contacts = [...state.contacts.filter(c => c.id !== action.payload.id), action.payload]
    }
  }
})

export const { addContact, editContact, deleteContact } = contactsSlice.actions

export default contactsSlice.reducer