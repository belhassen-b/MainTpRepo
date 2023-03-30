import { recipes } from "./recipes.js";
const info = document.getElementById("info");
const range = document.getElementById("rangeValue");
const rangeValue = range.value;
const recipesList = [];
for (const key in recipes) {
    recipesList.push(Object.assign({ id: key }, recipes[key]));
    // console.log(recipesList);
    // info.innerHTML = recipesList.name;
}
range.addEventListener('input', function (event) {
    const target = event.target;
    const value = target.value;
    const valString = value.toString();
    // console.log(valString);
    for (const recipe of recipesList) {
        const prep = recipe.prepTime;
        const prep2 = prep.split(" ");
        if (prep2[0] === valString) {
            console.log("found");
            info.innerHTML = recipe.instructions;
            // console.log(recipe.name + " " + recipe.prepTime)
        }
    }
});
