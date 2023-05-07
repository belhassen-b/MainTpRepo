import FlashCardDisplay from "./flashCards/FlashCardDisplayList";
import React from "react";
import {useSelector} from "react-redux";
import FlashCardDisplayList from "./flashCards/FlashCardDisplayList";
import {Outlet} from "react-router-dom";

const HomePage = () => {
    const flashcards = useSelector(state => state.flashcards.flashcards)

    return  (
    <>
            <div className="row my-3">
                <div className="col-10 offset-1 bg-dark rounded text-light p-3">
                    <div className="d-flex justify-content between">
                        <h3>Flashcards</h3>
                    </div>
                    <hr/>
                    <p className="text-start">Les flashcards sont des fiches de mémorisation. Le principe des flash
                        cards est extrêmement simple : sur des petites cartes plus c
                        moins grandes selon tes besoins, tu écris une question et sa réponse. Par exemple quelle est
                        la date de la prise de la Bastille ? U
                        Théorème / Formule Mathématique ? Une Définition philosophique ou économique ? Ou encore un
                        mot de vocabulaire
                        d'allemand, d'anglais ou d'espagnol. Un fois que tu as fait ton petit exercice de scribe, tu
                        te testes en t'auto-interrogeant carte
                        après carte. Facile non ?</p>
                    <hr/>
                    <h3>Listes des flashcards : </h3>
                    <div className="my-3">
    {flashcards.length === 0 ?
        <p>Il n'y a pas de flashcard dans la base de données !</p> :
      [...flashcards].map(f => <FlashCardDisplayList key={f.id} flashcardId={f.id} />)}
                    </div>

        </div>
    </div>
        </>
)
}

export default HomePage;