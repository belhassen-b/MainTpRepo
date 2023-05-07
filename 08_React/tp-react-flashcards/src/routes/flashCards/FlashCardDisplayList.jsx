import { useSelector } from "react-redux"
import {Link} from "react-router-dom";


const FlashCardDisplayList =  ({flashcardId}) => {
    const flashcard = useSelector(state => state.flashcards.flashcards).find(f => f.id === flashcardId)



  return (
                  <Link to={`/flashcards/edit/${flashcard.id}`} className="list-group-item link-info">Flashcard N° {flashcard.id}</Link>
  )
}
export default FlashCardDisplayList