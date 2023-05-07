import React, { useEffect, useState } from "react";
import { Route, useNavigate } from "react-router-dom"

const ProtectedRoute = ({ component: Component, ...rest }) => {
    const navigate = useNavigate();
    const [isAuth, setIsAuth] = useState(false);

    useEffect(() => {
        const user = localStorage.getItem("user");
        if (user) {
            setIsAuth(true);
        } else {
            navigate("/login");
        }
    }, [navigate]);

    return (
        <Route
            {...rest}
            render={(props) => {
                if (isAuth) {
                    return <Component {...props} />;
                }
            }}
        />
    );
}