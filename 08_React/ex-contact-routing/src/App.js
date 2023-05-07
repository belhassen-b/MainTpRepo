import './App.css';
import {NavLink , Outlet , useNavigate} from "react-router-dom";

function App() {
    const navigate = useNavigate();
  return (
      <div className="App">
        <header>
          <nav className="navbar navbar-expand-lg bg-body-tertiary text-white" data-bs-theme="dark">
            <div className="container">
              <span style={{cursor: "pointer"}} className="navbar-brand" ><i className="bi bi-globe"></i> eWebsites</span>
              <NavLink className="nav-link" to="/"><i className="bi bi-house"></i> Home</NavLink>
              <NavLink className="nav-link" to="/contact"><i className="bi bi-envelope"></i> Contact</NavLink>
            </div>
          </nav>
        </header>
        <main>
            <Outlet />
        </main>
        </div>


  );
}

export default App;
