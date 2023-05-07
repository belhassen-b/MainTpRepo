import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ErrorPage from "./routes/ErrorPage";
import HomePage from "./routes/HomePage";
import React from "react";
import ContactPage from "./routes/ContactPage";
import ContactListPage from "./routes/ContactListPage";
import ContactAddPage from "./routes/ContactAddPage";



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
                path: "/contact",
                element: <ContactListPage />
            },
            {
                path: "/contact/contactEdit",
                element: <ContactPage />
            },   {
                path: "/contact/contactAdd",
                element: <ContactAddPage />
            }
        ]
    }
])

export default router