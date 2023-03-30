import './App.css'
import { Link, NavLink, Outlet } from "react-router-dom";



function App() {
  return (
    <div className="App">
      <header>
      <nav className="navbar navbar-expand-lg bg-body-tertiary text-white" data-bs-theme="dark">
        <div className="container-fluid">
          <span style={{cursor: "pointer"}} className="navbar-brand" ><i className="bi bi-globe"></i> eWebsites</span>
          <NavLink className="nav-link" to="/"><i className="bi bi-house"></i> Home</NavLink>
            <NavLink className="nav-link" to="/project"><i className="bi bi-folder"></i> Projects</NavLink>
            <NavLink className="nav-link" to="/about"><i className="bi bi-person"></i> About</NavLink>
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
