import {useDispatch , useSelector} from "react-redux";
import {Link , useNavigate , useParams} from "react-router-dom";

const FlashCardItemDisplay = () => {
    const {flashcardId} = useParams();

    const flashcard = useSelector(state => state.flashcards.flashcards).find(f => f.id == flashcardId)


    return (
        <div className="p-3 mt-3 w-auto">
            <h5>Flashcard n°{flashcard.id}: {flashcard.question}</h5>
            <hr/>
            <div className="row">
                <div className="col-12">
                    <p>
                        <span id="solution" className="mt-1 p-3 text-info"  data-bs-toggle="collapse"
                                data-bs-target="#collapseExample" aria-expanded="false" aria-controls="collapseExample">
                            Solution
                        </span>
                        <div className="collapse" id="collapseExample">
                            <div className="text-start p-3 bg-success">
                                <p className=""><b>Solution :</b> {flashcard.answer}</p>
                            </div>
                        </div>
                    </p>

                </div>
            </div>
        </div>


    )
}


export default FlashCardItemDisplay;
