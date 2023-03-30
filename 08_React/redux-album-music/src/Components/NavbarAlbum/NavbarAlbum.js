import React , {useEffect} from 'react';
import ModalLogin from "../shared/ModalLogin";
import {logDOM} from "@testing-library/react";



const NavbarAlbum = () => {
    const [modalShow, setModalShow] = React.useState(false);
    const [isLogged, setIsLogged] = React.useState(false);

useEffect(() => {
    const token = localStorage.getItem('token')
    if(token){
        setIsLogged(true)
    }
},[])

    const handleLogout = () => {
    console.log('logout')
        localStorage.removeItem('token')
        setIsLogged(false)
    }

    return  (
            <nav className="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
            <div className="container-fluid">
                <span style={{cursor: "pointer"}} className="navbar-brand text-white" ><i className="bi bi-globe"></i> eRecipes</span>
                <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul className="navbar-nav ms-auto me-5 mb-2 mb-lg-0">

                    </ul>
                    <button className="btn btn-primary" onClick={!isLogged?() => setModalShow(true): () => handleLogout()} >{isLogged?'Logout': 'Login'} </button>
                </div>
            </div>
            <ModalLogin show={modalShow} onHide={() => setModalShow(false)} islogged={setIsLogged}/>
        </nav>
    )
}

export default NavbarAlbum;

