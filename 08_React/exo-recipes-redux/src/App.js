import {useDispatch , useSelector} from "react-redux";
import {apiKey , RECIPE_URL} from "./firebaseConfig";
import {BASE_DB_URL, SIGN_IN_URL , SIGN_UP_URL} from "./firebaseConfig";
import {    addRecipeAction ,    editRecipeAction ,    removeRecipeAction ,    setRecipesAction} from "./components/recipeItems/recipeItemsSlice";
import {useEffect , useState} from 'react';
import {SignForm}   from "./components/auth/SignForm";
import {createPortal} from "react-dom";
import Modal from "./components/shared/Modal";
import RecipeDisplay from "./components/recipeItems/RecipesDisplay";
import {RecipeForm} from "./components/recipeItems/RecipeForm";



function App() {
    const dispatch = useDispatch();
    const recipes = useSelector(state => state.recipeItems.recipes)
    const [recipe, setRecipe] = useState({})
    const [isLogged, setIsLogged] = useState(false)
    const [signFormMode, setSignFormMode] = useState("")
    const [recipeFormMode, setRecipeFormMode] = useState("")
    // useEffect(() => {
    //         fetch(`${BASE_DB_URL}/recipes.json`)
    //             .then(response => response.json())
    //             .then(data => {
    //                 const recipes = [];
    //                 for (const key in data) {
    //                     recipes.push({
    //                         id: key ,
    //                         ...data[key]
    //                     })
    //                 }
    //                 dispatch(setRecipesAction(recipes))
    //             })
    //     }
    //     , [])

    const signFormSubmitHandler = async (credentials) => {

        try {
            const URL = signFormMode === "Sign In" ? SIGN_IN_URL : SIGN_UP_URL

            console.log(URL)

            const response = await fetch(URL, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(credentials)
            })

            if (!response.ok) {
                throw new Error("Il y a eu un problème lors de " + signFormMode === 'Sign In' ? "la connexion" : "l'enregistrement")
            }

            const data = await response.json()

            localStorage.setItem('token', data.idToken)
            setIsLogged(true)
            setSignFormMode("")

        } catch (error) {
            console.error(error.message);
        }
    }

    const recipeFormSubmitHandler = async (recipe) => {
        try {
            const newRecipe = {
                name : recipe.name,
                ingredients : recipe.ingredients,
                instructions : recipe.instructions,
            }

            const response = await fetch(`${RECIPE_URL}`, {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify(newRecipe)
            })
            if (!response.ok) {
                throw new Error("Something went wrong!")
            }
            const data = await response.json()

            dispatch(addRecipeAction({...newRecipe, id: data.name}))

            setRecipeFormMode("")
        } catch (error) {
            console.log(error)
        }
    }

    const logoutHandler = () => {
        localStorage.removeItem('token')
        setIsLogged(false)
    }
    const refreshRecipes = async () => {
        try {
            const response = await fetch(`${RECIPE_URL}`)
            if (!response.ok) {
                throw new Error("Something went wrong!")
            }
            const data = await response.json()
            const tmpRecipes = [];
            for (const key in data) {
                tmpRecipes.push({
                    id: key,
                    ...data[key]
                })
            }
            dispatch(setRecipesAction(recipes))
        } catch (error) {
            console.log(error)
        }
        }


    useEffect(() => {
        refreshRecipes()
    }
    , [])






return (
    <div className="App">
        {signFormMode === "Sign In" && createPortal(<Modal onClose={() => setSignFormMode("")} modalTitle={"Sign In"}>
            <SignForm mode="Sign In" onSubmit={signFormSubmitHandler} />
        </Modal>, document.getElementById("modal-root"))}
        {signFormMode === "Sign Up" && createPortal(<Modal onClose={() => setSignFormMode("")} modalTitle={"Sign Up"}>
            <SignForm mode="Sign Up" onSubmit={signFormSubmitHandler} />
        </Modal>, document.getElementById("modal-root"))}
        {recipeFormMode  === "Edit" && createPortal(<Modal onClose={() => setRecipeFormMode("")} modalTitle={"Edit Recipe"}>
            <RecipeForm mode="Edit" onSubmit={recipeFormSubmitHandler} />
        </Modal>, document.getElementById("modal-root"))}


        <header>
            <nav className="navbar navbar-expand-lg bg-body-tertiary" data-bs-theme="dark">
                <div className="container-fluid">
          <span className="navbar-brand" style={{cursor: "pointer"}}>
            <i className="bi bi-globe"></i> eRecipes
          </span>
                    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarContacts" aria-controls="navbarContacts" aria-expanded="false" aria-label="Toggle navigation">
                        <span className="navbar-toggler-icon"></span>
                    </button>
                    <div className="collapse navbar-collapse" id="navbarContacts">
                        {isLogged ? (
                            <button onClick={logoutHandler} className="ms-auto btn btn-secondary">Sign Out</button>
                        ) : (
                            <>
                                <button onClick={() => setSignFormMode("Sign Up")} className="ms-auto btn btn-outline-info">Register</button>
                                <button onClick={() => setSignFormMode("Sign In")} className="ms-2 btn btn-primary">Sign In</button>
                            </>
                        )}
                    </div>
                </div>
            </nav>
        </header>
        <main className="container">
            <h1>Recipes List</h1>
            <hr/>
            <div className="my-3 row">
                <div className="col-10 offset-1 bg-dark text-light p-3 rounded">
                    <div className="d-flex justify-content-between align-items-center">
                        <h2>Recipes List</h2>
                        <button className="btn btn-primary" onClick={() => setRecipeFormMode("Edit")}>Add Recipe</button>
                    </div>
                    <hr/>
                    <div className="row">
                        {recipes.length === 0 ?
                            <p>No recipes yet</p> :
                        recipes.map(recipe => <RecipeDisplay key={recipe.id} recipeItemId={recipe.id}/>)}
                    </div>
                </div>
            </div>
        </main>
    </div>
);
}


export default App;
