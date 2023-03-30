import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ErrorPage from "./routes/ErrorPage";
import HomePage from "./routes/HomePage";
import FlashCardForm from "./routes/flashCards/FlashCardForm";
import React from "react";
import FlashCardItemDisplay from "./routes/flashCards/FlashCardItemDisplay";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/",
        element: <HomePage />
      },
      {
        path: "/flashcard/add",
        element: <FlashCardForm />
      },
      {
        path: "/flashcards/edit/:flashcardId",
        element: <FlashCardItemDisplay />
      },
      {
        path: "/flashcards/delete/:flashcardId",
        element: <FlashCardForm />
      },
    ]
  }
])

export default router