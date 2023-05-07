import {useRef} from "react"

export const RecipeForm = (props) => {
    const mode = props.mode

    const nameRef = useRef()
    const ingredientsRef = useRef()
    const instructionsRef = useRef()


    const submitFormHandler = (event) => {
        event.preventDefault()

        const name = nameRef.current.value
        const ingredients = ingredientsRef.current.value
        const instructions = instructionsRef.current.value

        console.log(name, ingredients, instructions)


        const recipeDetail = {
            name ,
            ingredients ,
            instructions ,
        }
        nameRef.current.value = ''
        ingredientsRef.current.value = ''
        instructionsRef.current.value = ''


        props.onSubmit(recipeDetail)
    }

    return (
        <form onSubmit={submitFormHandler}>
            <div className="mb-3">
                <label htmlFor="name" className="form-label">Titre: </label>
                <input className="form-control" type="text" id="recipeDetail" required ref={nameRef}/>
            </div>
            <div className="mb-3">
                <label htmlFor="ingredients" className="form-label">Ingredients: </label>
                <input className="form-control" type="text" id="ingredients" required ref={ingredientsRef}/>
            </div>
            <div className="mb-3">
                <label htmlFor="instructions" className="form-label">Instructions: </label>
                <input className="form-control" type="text" id="instructions" required ref={instructionsRef}/>
            </div>
            <div className="text-end">
                <button className={`btn btn-${mode === 'recipeDetail'}`}>{mode}</button>
            </div>
        </form>
    )
}

