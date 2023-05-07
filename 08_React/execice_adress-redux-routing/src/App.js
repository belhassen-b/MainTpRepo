import './App.css';
import {Link , NavLink , Outlet , useNavigate} from "react-router-dom";
import ContactsList from "./Components/ContactsList";
import {useState} from "react";

function App() {
  const navigate = useNavigate()

  return (
    <div className="App">
      <header>
        <nav className="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
          <div className="container-fluid">
            <Link className="navbar-brand" to={`/`}><i className="bi bi-globe"></i> eMonSite</Link>
            <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
              <span className="navbar-toggler-icon"></span>
            </button>
            <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
              <div className="navbar-nav">
                <NavLink className="nav-link" to={`/HomePage`}>Accueil</NavLink>
                <NavLink className="nav-link" to={`/ContactsList`}>Liste Contact </NavLink>

                {/*{user?.role === 'Admin' && <NavLink className="nav-link" to={`/admin`}>Administration</NavLink>}*/}
              </div>
            </div>
          </div>
        </nav>
      </header>
      <main className="container">
        <div className="row my-3">
          <div className="col-10 offset-1 bg-dark text-light rounded p-3">
            <Outlet />
          </div>
        </div>
      </main>
    </div>
  );
}

export default App;
