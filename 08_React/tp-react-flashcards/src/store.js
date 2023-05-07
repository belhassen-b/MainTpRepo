import { configureStore } from "@reduxjs/toolkit";
import FlashCardsSlice from "./routes/flashCards/FlashCardsSlice";


const store = configureStore({
  reducer: {
   flashcards: FlashCardsSlice
  }
})

export default store