import './App.css';

import {Link , NavLink , Outlet , useNavigate} from "react-router-dom";
import {useSelector} from "react-redux";
import React from "react";


function App() {
    const flashcardlength =  useSelector(state => state.flashcards.flashcards.length);

    const navigate = useNavigate();
    function getFlashcardRdm() {
        const rdm =  Math.floor(Math.random() * flashcardlength)+1 ;
        console.log(flashcardlength)
    navigate(`/flashcards/edit/${rdm}`)
    }
    const handleFoundFlashcard  = () => {
        const input = document.getElementById('form1').value;
        console.log(input)
        navigate(`/flashcards/edit/${input}`)
    }

    return (
        <>
            <header>
                <nav className="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
                    <div className="container-fluid">

                        <Link className="navbar-brand" to={`/`}><i className="bi bi-globe  p-1 px-2"></i> Accueil eFlashcard</Link>

                        <Link className="navbar-brand" to={`/flashcard/add`}><i className="bi bi-plus-circle-fill rounded-circle p-1 px-2"></i> Ajouter une Flashcard</Link>
                        <button className="navbar-brand"  id="rdmButton" onClick={getFlashcardRdm}><i className="bi bi-shuffle p-1" id="rdm" >Flashcard au hasard</i></button>

                        <input type="search" id="form1" placeholder="Numéro Flashcard" className="form-control w-25 me-2"/>
                        <button type="button" onClick={handleFoundFlashcard} className="btn btn-outline-info "><i className="fas fa-search">GO</i></button>
                    </div>
                </nav>
            </header>
            <main className="container bg-dark text-white">
                <Outlet/>
            </main>

        </>
    );
}



export default App;
