import { useSelector } from "react-redux"
import {Navigate , Outlet} from "react-router-dom"
import ContactsList from "./ContactsList";

function ProtectedRoute({
    element: Element,
                            children
                        }) {
    const isAuthenticated = localStorage.getItem("isAuthenticated");
    console.log("this" , isAuthenticated);
    if (isAuthenticated) {
        return
            <Navigate to="/landing" replace/>;
                }
    return children ;

}
export default ProtectedRoute