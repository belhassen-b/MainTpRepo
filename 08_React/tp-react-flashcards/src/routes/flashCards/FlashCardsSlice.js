import { createSlice } from "@reduxjs/toolkit";
import baseFlashcards from "../../utils/baseFlashcards";

const flashCardsSlice = createSlice({
  name: "flashcards",
  initialState: {
    flashcards: [...baseFlashcards],
    isLoading: false,
    error: null,
  },
  reducers: {
    addFlashcard(state, action) {
      const id = state.flashcards.length+1
      state.flashcards.push({id:id,...action.payload})
    },

    editFlashcard(state, action) {
      const {id} = action.payload
      const flashcardFound = state.flashcards.find(r => r.id === id)
      if (flashcardFound) {
        state.flashcards = [...state.flashcards.filter(r => r.id !== id), action.payload]
      }
    },
    deleteFlashcard(state, action) {
      const id = action.payload
      const flashcardFound = state.flashcards.find(r => r.id === id)
      if (flashcardFound) {
        state.flashcards = state.flashcards.filter(r => r.id !== id)
      }
    },
  }
})

export const {  addFlashcard, editFlashcard, deleteFlashcard, randomFlashcard  } = flashCardsSlice.actions

export default flashCardsSlice.reducer