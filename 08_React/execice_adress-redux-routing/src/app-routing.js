import App from "./App";
import AdminPage from "./routes/admin/AdminPage";
import HomePage from "./routes/HomePage";
import { createBrowserRouter, redirect } from "react-router-dom";
import LoginForm from "./routes/loginForm";
import ProtectedRoute from "./Components/ProtectedRoute";
import ContactsList from "./Components/ContactsList";
import ContactForm from "./Components/ContactForm";
import React from "react";



const authCheck = () => {
}

const router = createBrowserRouter(
    [{
    path: "/",
    element: <App />,
    children: [
        {
            path: "/",
            element: <HomePage />
        },
        {
            path: "/loginForm",
            element:  <LoginForm />,

        },
        {
            path: "/admin",
            element:
                <ProtectedRoute>
                <AdminPage />
                </ProtectedRoute>,
        },
        {
            path:   "/ContactsList",
            element:<ProtectedRoute><ContactsList /></ProtectedRoute> ,
        },
        {
            path: "/contacts/add",
            element: <ContactForm />
        },
        // {
        //     path: "/contacts/edit/:contactId",
        //     element: <ContactForm />
        // },
        // {
        //     path: "/contacts/delete/:contactId",
        //     element: <ContactForm />
        // },
    ]
        }
    ]
)
export default router