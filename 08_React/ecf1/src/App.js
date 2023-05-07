import './App.css';
import React , {useState} from "react";
import {NavLink , Outlet} from "react-router-dom";


function App() {
    const [isLogin , setIsLogin] = useState(false);
    const loginHandler = () => {
        setIsLogin(true);
    }

    const logoutHandler = () => {
        setIsLogin(false);
    }


    return (
        <div className="App">
            <header>
                <nav className="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
                    <div className="container-fluid">
          <span className="navbar-brand" style={{cursor: "pointer"}}>
            <i className="bi bi-globe"></i> IMC Calculator
          </span>
                        <button className="navbar-toggler bg-info" type="button" data-bs-toggle="collapse"
                                data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup"
                                aria-expanded="false" aria-label="Toggle navigation">
                            <span className="navbar-toggler-icon"></span>
                        </button>
                        <div className="collapse  navbar-collapse" id="navbarNavAltMarkup">
                            <div className="navbar-nav">
                                <NavLink className="nav-link" to="/" exact>
                                    <i className="bi bi-house-door-fill"></i> Home
                                </NavLink>
                                <NavLink className="nav-link" to="/signup">
                                    <i className="bi bi-person-plus-fill"></i> Signup
                                </NavLink>
                                <NavLink className="nav-link" to="/login">
                                    <i className="bi bi-person-plus-fill"></i> Login
                                </NavLink>
                            </div>
                            <button className="btn btn-outline-success" type="submit">Ajouter des données</button>
                        </div>
                    </div>

                </nav>
            </header>
            <main className="container bg-dark text-white">
                <Outlet/>
            </main>
        </div>
    );
}


export default App;
