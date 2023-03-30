import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ErrorPage from "./routes/ErrorPage";
import HomePage from "./routes/HomePage";
import React from "react";
import Signup from "./routes/Signup";
import Login from "./routes/Login";
import UserImcDataForm from "./routes/UserImcDataForm";
import ImcDisplay from "./routes/ImcDisplay";


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
            path:"/signup",
            element:<Signup />
                },
            {
                path:"/login",
                element:<Login />
            },
            {
                path:"/userImc",
                element:<UserImcDataForm />
            },
            {
                path: "/imcDisplay",
                element: <ImcDisplay />

            }

        ]
    }
])

export default router
