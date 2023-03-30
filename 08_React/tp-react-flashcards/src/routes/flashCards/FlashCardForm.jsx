import { useRef } from "react"
import {useDispatch , useSelector} from "react-redux"
import {useNavigate , useParams , useSearchParams} from "react-router-dom";
import {addFlashcard , deleteFlashcard , editFlashcard} from "./FlashCardsSlice";

const FlashCardForm = () => {

    const {flashcardId} = useParams()
   const flashcard = useSelector(state=> state.flashcards.flashcards).find(f => f.id == flashcardId)
    const flashcards = useSelector(state => state.flashcards.flashcards)

    const [searchParams] = useSearchParams()
    const mode = searchParams.get('mode') ?? 'add'

    const dispatch = useDispatch()
    const navigate = useNavigate()

    const questionRef = useRef()
    const answerRef = useRef()

  const submitFormHandler = async (e) => {
        e.preventDefault();
      if (mode === 'delete') {
          await dispatch(deleteFlashcard(flashcardId))
      } else {
          const id = flashcards.length+1
          const question = questionRef.current.value
          const answer  = answerRef.current.value


          const flashcardValues = {
              id,
              question,
              answer
          }

          if (mode === 'add') {

              await dispatch(addFlashcard(flashcardValues))
          } else if (mode === 'edit') {
              await dispatch(editFlashcard({id: flashcardId, ...flashcardValues}))
          }
      }

      navigate(`/`)
  }

       return  (
    <form onSubmit={submitFormHandler}>
      <div className="mb-3">
        <label htmlFor="question" className="form-label">Question: </label>
        <input type="text" ref={questionRef} required={mode !== 'delete'} disabled={mode === 'delete'} ref={questionRef} defaultValue={flashcard?.question} className="form-control" />
      </div>
      <div className="mb-3">
        <label htmlFor="answer" className="form-label">Réponse: </label>
        <textarea ref={answerRef} required={mode !== 'delete'} disabled={mode === 'delete'} ref={answerRef} defaultValue={flashcard?.answer} className="form-control" cols={30} rows={10} style={{resize: "none"}}></textarea>
      </div>
      <div className="text-end">
        <button className={`btn btn-${mode === 'delete'? 'danger' : mode === 'edit' ? 'warning' : 'success'}`}>
          <i className={`bi bi-${mode === 'delete' ? 'trash' : mode === 'edit' ? 'pencil-square' : 'plus-circle'}`}></i> {mode === 'delete' ? 'Confirmer' : mode === 'edit' ? 'Editer' : 'Envoyer'}
          </button>
      </div>
    </form>
  )
}

export default FlashCardForm