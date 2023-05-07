import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import AboutPage from "./routes/AboutPage";
import ErrorPage from "./routes/ErrorPage";
import HomePage from "./routes/HomePage";
import ContactPage from "./routes/ContactPage";
import ProjectPage from "./routes/ProjectPage";
import React from "react";



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
                path: "/project",
                element: <ProjectPage />
            },
            {
                path: "/about",
                element: <AboutPage />
            },
            {
                path: "/contact",
                element: <ContactPage />
            }
        ]
    }
])

export default router