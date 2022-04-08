import { addRecipe, addIngredient } from '../adapters/recipeAdapter'
import { ingredients } from './ingredients';
import { recipes } from './recipes';

const postRecipes = () => {
    //const recipes = getRecipes();
    for (let recipe of recipes) {
        addRecipe(recipe);
    }
}

const postIngredients = () => {
    //const ingredients = getIngredients()
    for (let ing of ingredients) {
        addIngredient(ing);
    }
}

export { postIngredients, postRecipes }