import {useSelector} from "react-redux";
import {editRecipeAction} from "./recipeItemsSlice";


const RecipeDisplay = ({recipeItemId}) => {
    const recipeItem = useSelector(state => state.recipeItems.recipes).find(recipe => recipe.id === recipeItemId)
    return (
        <div className="my-3">
            <h3>{recipeItem.name}</h3>
            <hr/>
            <table className="table table-striped text-white">
                <thead>
                <tr>
                    <th scope="col">Ingredients</th>
                    <th scope="col">Instructions</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td className="text-white">
                        {recipeItem.ingredients}
                    </td>
                    <td className="text-white">
                        {recipeItem.instructions}

                    </td>
                </tr>
                </tbody>
            </table>
            <div className="px-3 align-items-end">
                <button className="btn btn-warning me-4" onClick={() => editRecipeAction()}>Edit</button>
                <button className="btn btn-danger">Delete</button>
            </div>
            <hr/>
        </div>

    )
}
export default RecipeDisplay